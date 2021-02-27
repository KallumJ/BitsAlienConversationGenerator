package actions;

import com.google.gson.JsonObject;

/**
 * A class to model the change_reputation action in Alien Conversations
 */
public class ChangeReputation implements IAction {
    private static final String ACTION_STRING = "change_reputation";

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
