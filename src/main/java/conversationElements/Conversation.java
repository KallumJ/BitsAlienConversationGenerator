package conversationElements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to model a conversation for the aliens in Bits+
 */
public class Conversation {

    private final JsonArray nodesJsonArray = new JsonArray();
    private final ArrayList<ConvoNode> nodesList = new ArrayList<>();

    /**
     * Constructs a conversationElements.Conversation object with the provided Nodes
     *
     * @param convoNodes an array of conversation Nodes
     */
    public Conversation(ConvoNode[] convoNodes) {
        this.nodesList.addAll(Arrays.asList(convoNodes));
    }

    public Conversation() {

    }

    /**
     * Adds a node to the conversation
     *
     * @param convoNode conversationElements.Node, node to add
     */
    public void encodeNode(ConvoNode convoNode) {
        JsonObject jsonNode = new JsonObject();

        // Adds the required properties for a node
        jsonNode.addProperty("node", convoNode.getId());
        jsonNode.add("text", convoNode.getTextsJsonArray());

        // If there are no responses, this is a final node
        if (!convoNode.getResponseArrayList().isEmpty()) {
            jsonNode.add("responses", convoNode.getResponsesJsonArray());
        } else {
            jsonNode.addProperty("final", true);
        }

        this.nodesJsonArray.add(jsonNode);
    }

    public void addNode(ConvoNode node) {
        this.nodesList.add(node);
    }

    /**
     * Returns a string in Json format of the this conversation
     *
     * @return String, a Json string
     */
    public String getJsonString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject conversationJsonObject = new JsonObject();

        // Add each node to a json array of nodes
        this.nodesList.forEach(this::encodeNode);

        // Adds the nodes json array to a root json object
        conversationJsonObject.add("nodes", this.nodesJsonArray);

        // Return the conversation json object as string
        return gson.toJson(conversationJsonObject);
    }

}
