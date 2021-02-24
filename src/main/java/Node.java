import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to model a conversation node in the alien conversation system in Bits+
 */
public class Node {

    private int nodeId;
    private final ArrayList<String> nodeTexts = new ArrayList<>();
    private final ArrayList<Response> responseList = new ArrayList<>();

    /**
     * Constructs a conversation node object with the provided information
     * @param nodeId The id for the node
     * @param texts The available text options for the node
     * @param responses The responses available to the node
     */
    public Node(int nodeId, String[] texts, Response[] responses) {
        this.nodeId = nodeId;

        this.nodeTexts.addAll(Arrays.asList(texts));

        this.responseList.addAll(Arrays.asList(responses));
    }

    /**
     * Returns the text options for this node as a JsonArray
     * @return JsonArray, the generated JsonArray
     */
    public JsonArray getTextsJsonArray() {
        JsonArray jsonArray = new JsonArray();

        // For each text available to the node, add it to this JsonArray
        this.nodeTexts.forEach(jsonArray::add);

        return jsonArray;
    }

    /**
     * Returns the id for this node
     * @return int, the node id
     */
    public int getId() {
        return this.nodeId;
    }

    /**
     * Returns the arraylist of responses for this node
     * @return ArrayList of Response objects
     */
    public ArrayList<Response> getResponseArrayList() {
        return responseList;
    }

    /**
     * Return the response options available to this node as a JsonArray
     * @return JsonArray, the generated JsonArray
     */
    public JsonArray getResponsesJsonArray() {

        JsonArray jsonArray = new JsonArray();

        responseList.forEach(response -> jsonArray.add(response.getJsonObject()));

        return jsonArray;
    }
}
