package actions;

import com.google.gson.JsonObject;

/**
 * A class to model an advance_and_remember action in Alien Conversations
 */
public class AdvanceAndRemember implements IAction {

    private final String key;
    private final String value;

    private static final String ACTION_STRING = "advance_and_remember";

    /**
     * Constructs an Advance and Remember object
     *
     * @param key   the key to remember
     * @param value the value to remember
     */
    public AdvanceAndRemember(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key for this action
     *
     * @return String, the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the value for this action
     *
     * @return String, the value
     */
    public String getValue() {
        return value;
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
        json.addProperty("value", this.getValue());
    }
}
