import actions.AdvanceAndRemember;
import actions.IAction;
import actions.PayAndAdvance;
import actions.RememberFromChat;
import com.google.gson.JsonObject;

/**
 * A class to model an individual response from the player in the alien conversation system in Bits+
 */
public class Response {
    private String text;
    private IAction action;
    private int nextNode;

    /**
     * Constructs a response object with the provided information
     * @param text The text for the player to respond with
     * @param action The action of the response
     * @param nextNode The node that this node points to go to next
     */
    public Response(String text, IAction action, int nextNode) {
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
        jsonObject.addProperty("action", this.action.getActionString());
        jsonObject.addProperty("next_node", this.nextNode);

        if (this.action instanceof RememberFromChat) {
            jsonObject.addProperty("key", ((RememberFromChat) this.action).getKey());
        } else if (this.action instanceof AdvanceAndRemember) {
            jsonObject.addProperty("key", ((AdvanceAndRemember) this.action).getKey());
            jsonObject.addProperty("value", ((AdvanceAndRemember) this.action).getValue());
        } else if (this.action instanceof PayAndAdvance) {
            jsonObject.addProperty("item", ((PayAndAdvance) this.action).getItem());
        }

        return jsonObject;
    }

}
