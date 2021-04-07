package actions;

import com.google.gson.JsonObject;
import gui.components.GUITextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class to model an advance_and_remember action in Alien Conversations
 */
public class AdvanceAndRemember implements IAction {

    public static final String ACTION_STRING = "advance_and_remember";
    private final String key;
    private final String value;

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

    public static VBox getGUIComponent() {
        VBox vbox = new VBox(5);
        vbox.setId(ACTION_STRING);

        HBox keyTextField = new GUITextField("Key").getComponent();
        HBox valueTextField = new GUITextField("Value").getComponent();

        vbox.getChildren().addAll(keyTextField, valueTextField);

        return vbox;
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
