package conversationElements;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to model a conversation for the aliens in Bits+
 */
public class Conversation {

    private final JsonArray nodesJsonArray = new JsonArray();
    private final ArrayList<Node> nodesList = new ArrayList<>();

    /**
     * Constructs a conversationElements.Conversation object with the provided Nodes
     *
     * @param nodes an array of conversation Nodes
     */
    public Conversation(Node[] nodes) {
        this.nodesList.addAll(Arrays.asList(nodes));
    }

    /**
     * Adds a node to the conversation
     *
     * @param node conversationElements.Node, node to add
     */
    public void addNode(Node node) {
        JsonObject jsonNode = new JsonObject();

        // Adds the required properties for a node
        jsonNode.addProperty("node", node.getId());
        jsonNode.add("text", node.getTextsJsonArray());

        // If there are no responses, this is a final node
        if (!node.getResponseArrayList().isEmpty()) {
            jsonNode.add("responses", node.getResponsesJsonArray());
        } else {
            jsonNode.addProperty("final", true);
        }

        this.nodesJsonArray.add(jsonNode);
    }

    /**
     * Returns a string in Json format of the this conversation
     *
     * @return String, a Json string
     */
    public String getJsonString() {
        Gson gson = new Gson();
        JsonObject conversationJsonObject = new JsonObject();

        // Add each node to a json array of nodes
        this.nodesList.forEach(this::addNode);

        // Adds the nodes json array to a root json object
        conversationJsonObject.add("nodes", this.nodesJsonArray);

        // Return the conversation json object as string
        return gson.toJson(conversationJsonObject);
    }

}
