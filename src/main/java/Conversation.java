import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to model a conversation for the aliens in Bits+
 */
public class Conversation {

    public Gson gson = new Gson();
    private final JsonObject conversationJsonObject = new JsonObject();
    private final JsonArray nodesJsonArray = new JsonArray();
    private final ArrayList<Node> nodesList = new ArrayList<>();

    /**
     * Constructs a Conversation object with the provided Nodes
     * @param nodes an array of conversation Nodes
     */
    public Conversation(Node[] nodes) {
        this.nodesList.addAll(Arrays.asList(nodes));
    }

    /**
     * Adds a node to the conversation
     * @param node Node, node to add
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

        nodesJsonArray.add(jsonNode);
    }

    /**
     * Returns a string in Json format of the this conversation
     * @return String, a Json string
     */
    public String getJsonString() {
        // Add each node to a json array of nodes
        nodesList.forEach(this::addNode);

        // Adds the nodes json array to a root json object
        conversationJsonObject.add("nodes", nodesJsonArray);

        // Return the conversation json object as string
        return gson.toJson(conversationJsonObject);
    }

}
