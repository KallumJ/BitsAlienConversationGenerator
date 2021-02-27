package actions;

import com.google.gson.JsonObject;

/**
 * A class to model a pay_and_advance action in Alien Conversations
 */
public class PayAndAdvance implements IAction {
    private static final String ACTION_STRING = "pay_and_advance";

    private final String item;

    /**
     * Constructs PayAndAdvance object
     *
     * @param item the item to be paid
     */
    public PayAndAdvance(String item) {
        this.item = item;
    }

    /**
     * Returns the item to be paid
     *
     * @return String, the item
     */
    public String getItem() {
        return item;
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
        json.addProperty("item", this.getItem());
    }
}
