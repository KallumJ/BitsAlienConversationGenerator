package actions;

import com.google.gson.JsonObject;

/**
 * An interface to model an Action in Alien Conversations
 */
public interface IAction {
    /**
     * Returns the action as lower case snake_case string
     *
     * @return String, the action string
     */
    String getActionString();

    /**
     * Writes the required information for this action to the passed Json Object
     *
     * @param json the JsonObject
     */
    void writeToJson(JsonObject json);
}
