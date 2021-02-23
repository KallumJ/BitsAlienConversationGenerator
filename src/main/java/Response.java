import com.google.gson.JsonObject;

/**
 * A class to model an individual response from the player in the alien conversation system in Bits+
 */
public class Response {
    private String text;
    private Action action;
    private int nextNode;
    private boolean isFinal;

    /**
     * Constructs a response object with the provided information
     * @param text The text for the player to respond with
     * @param action The action of the response
     * @param nextNode The node that this node points to go to next
     */
    public Response(String text, Action action, int nextNode) {
        this.text = text;
        this.action = action;
        this.nextNode = nextNode;
    }

    /**
     * Return this response as a JsonObject in the required Json format
     * @return JsonObject, this response as a JsonObject;
     */
    public JsonObject getJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", text);
        jsonObject.addProperty("action", this.getActionString());
        jsonObject.addProperty("next_node", this.nextNode);

        return jsonObject;
    }

    /**
     * Return the string required in the json file for this action
     * @return String, the formatted string
     */
    private String getActionString() {
        String string = "";

        switch (this.action) {
            case ADVANCE_AND_REMEMBER:
                string = "advance_and_remember";
                break;
            case ADVANCE_CONVERSATION:
                string = "advance_conversation";
                break;
            case REMEMBER_FROM_CHAT:
                string = "remember_from_chat";
                break;
            case OPEN_TRADE:
                string = "open_trade";
                break;
            case PAY_AND_ADVANCE:
                string = "pay_and_advance";
                break;
            case CHANGE_REPUTATION:
                string = "change_reputation";
                break;
        }

        return string;
    }

}
