package actions;

import com.google.gson.JsonObject;

/**
 * A class to model a "remember_from_chat" action in an Alien conversationElements.Conversation
 */
public class RememberFromChat implements IAction {
    private static final String ACTION_STRING = "remember_from_chat";
    private final String key;

    /**
     * Constructs a RememberFromChat object
     *
     * @param key the key being remembered
     */
    public RememberFromChat(String key) {
        this.key = key;
    }

    /**
     * Returns the key for this action
     *
     * @return String the key
     */
    public String getKey() {
        return key;
    }

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
        json.addProperty("key", this.getKey());
    }
}
