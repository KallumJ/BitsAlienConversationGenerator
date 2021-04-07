package actions;

import com.google.gson.JsonObject;
import gui.components.GUITextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class to model a "remember_from_chat" action in an Alien conversationElements.Conversation
 */
public class RememberFromChat implements IAction {
    public static final String ACTION_STRING = "remember_from_chat";
    private final String key;

    /**
     * Constructs a RememberFromChat object
     *
     * @param key the key being remembered
     */
    public RememberFromChat(String key) {
        this.key = key;
    }

    public static VBox getGUIComponent() {
        VBox vbox = new VBox();
        vbox.setId(ACTION_STRING);

        HBox keyTextField = new GUITextField("Key").getComponent();

        vbox.getChildren().addAll(keyTextField);

        return vbox;
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
