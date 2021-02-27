package gui.components.buttons;

import gui.GUI;
import gui.IComponent;
import gui.components.ResponseGUIComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

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
     *
     * @return Button, the button
     */
    @Override
    public Button getComponent() {
        return this.addResponsesButton;
    }

    /**
     * A method to be called when the add responses button is pressed
     *
     * @param event, The invoking event
     */
    @Override
    public void handle(ActionEvent event) {
        Button sendingButton = (Button) event.getSource();
        TitledPane nodeGuiComponent = (TitledPane) sendingButton.getParent().getParent().getParent();
        VBox nodeGuiComponentContent = (VBox) sendingButton.getParent();


        ResponseGUIComponent responseGUIComponent = new ResponseGUIComponent();
        nodeGuiComponentContent.getChildren().add(responseGUIComponent.getComponent());
        nodeGuiComponent.setContent(nodeGuiComponentContent);

        // Add response and associated node to response map;
        int nodeId = Integer.parseInt(nodeGuiComponent.getText().replaceAll("Node ", ""));
        responseGUIComponent.getResponse().setParentNode(nodeId);
        GUI.RESPONSE_LIST.add(responseGUIComponent.getResponse());
    }
}
