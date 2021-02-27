package gui.components;

import gui.IComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * A class to model an add responses button for the NodeGUIComponent
 */
public class AddResponsesButton implements EventHandler<ActionEvent>, IComponent<Button> {

    private final Button addResponsesButton;

    /**
     * Constructs an AddResponsesButton object
     */
    public AddResponsesButton() {
        this.addResponsesButton = new Button("Add Responses");
        this.addResponsesButton.setOnAction(this);
    }

    /**
     * Returns the button
     * @return Button, the button
     */
    @Override
    public Button getComponent() {
        return this.addResponsesButton;
    }

    /**
     * A method to be called when the add responses button is pressed
     * @param event, The invoking event
     */
    @Override
    public void handle(ActionEvent event) {

    }
}
