package conversationElements;

import actions.IAction;
import com.google.gson.JsonObject;

/**
 * A class to model an individual response from the player in the alien conversation system in Bits+
 */
public class Response {
    private final String text;
    private final IAction action;
    private final int nextNode;

    /**
     * Constructs a response object with the provided information
     *
     * @param text     The text for the player to respond with
     * @param action   The action of the response
     * @param nextNode The node that this node points to go to next
     */
    public Response(String text, IAction action, int nextNode) {
        this.text = text;
        this.action = action;
        this.nextNode = nextNode;
    }

    /**
     * Return this response as a JsonObject in the required Json format
     *
     * @return JsonObject, this response as a JsonObject;
     */
    public JsonObject getJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", this.text);

        // Adds the action specific information to jsonObject
        this.action.writeToJson(jsonObject);

        jsonObject.addProperty("next_node", this.nextNode);

        return jsonObject;
    }

}
