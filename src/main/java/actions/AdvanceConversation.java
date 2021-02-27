package actions;

import com.google.gson.JsonObject;

/**
 * A class to model and advance_conversation action in Alien Conversations
 */
public class AdvanceConversation implements IAction {
    private static final String ACTION_STRING = "advance_conversation";

    /**
     * Returns the action as lower case snake_case string
     *
     * @return String, the action string
     */
    @Override
    public String getActionString() {
        return ACTION_STRING;
    }

    /**
     * Writes the required information for this action to the passed Json Object
     *
     * @param json the JsonObject
     */
    @Override
    public void writeToJson(JsonObject json) {
        json.addProperty("action", this.getActionString());
    }
}
