package conversationElements;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to model a conversation node in the alien conversation system in Bits+
 */
public class ConvoNode {

    private static int startingNodeId = 0;
    private final int nodeId;
    private ArrayList<String> nodeTexts = new ArrayList<>();
    private ArrayList<Response> responseList = new ArrayList<>();

    /**
     * Constructs a conversation node object with the provided information
     *
     * @param texts     The available text options for the node
     * @param responses The responses available to the node
     */
    public ConvoNode(String[] texts, Response[] responses) {
        startingNodeId++;

        this.nodeId = startingNodeId;

        this.nodeTexts.addAll(Arrays.asList(texts));

        this.responseList.addAll(Arrays.asList(responses));
    }

    public ConvoNode() {
        startingNodeId++;

        this.nodeId = startingNodeId;
    }

    public void setNodeTexts(ArrayList<String> texts) {
        this.nodeTexts = texts;
    }

    public void setResponseList(ArrayList<Response> responses) {
        this.responseList = responses;
    }

    /**
     * Returns the text options for this node as a JsonArray
     *
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
     *
     * @return int, the node id
     */
    public int getId() {
        return this.nodeId;
    }

    /**
     * Returns the arraylist of responses for this node
     *
     * @return ArrayList of conversationElements.Response objects
     */
    public ArrayList<Response> getResponseArrayList() {
        return this.responseList;
    }

    /**
     * Return the response options available to this node as a JsonArray
     *
     * @return JsonArray, the generated JsonArray
     */
    public JsonArray getResponsesJsonArray() {

        JsonArray jsonArray = new JsonArray();

        this.responseList.forEach(response -> jsonArray.add(response.getJsonObject()));

        return jsonArray;
    }
}
