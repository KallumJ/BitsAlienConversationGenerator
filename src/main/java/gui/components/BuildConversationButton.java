package gui.components;

import gui.IComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * A class to model a button that builds the conversation currently modelled in the GUI
 */
public class BuildConversationButton implements IComponent<Button>, EventHandler<ActionEvent> {
    private final Button buildConvoButton;

    /**
     * Constructs a BuildConversationButton object
     */
    public BuildConversationButton() {
        this.buildConvoButton = new Button("Build Conversation");
    }

    /**
     * Returns the button
     * @return Button, the button
     */
    @Override
    public Button getComponent() {
        return this.buildConvoButton;
    }

    /**
     * A method to be called when the Build Conversation button is pressed
     * @param event ActionEvent, the invoking event
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println("BUILDING CONVERSATION");
    }
}
