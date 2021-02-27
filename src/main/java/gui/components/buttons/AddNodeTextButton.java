package gui.components.buttons;

import gui.IComponent;
import gui.components.GUITextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class AddNodeTextButton implements IComponent<Button>, EventHandler<ActionEvent> {
    private final Button addNodeTextButton;

    public AddNodeTextButton() {
        this.addNodeTextButton = new Button("Add Text");
        this.addNodeTextButton.setOnAction(this);
    }

    @Override
    public Button getComponent() {
        return this.addNodeTextButton;
    }

    @Override
    public void handle(ActionEvent event) {
        VBox nodeBox = (VBox) this.getComponent().getParent();

        nodeBox.getChildren().add(new GUITextField("Node text").getComponent());

        TitledPane nodeGUIComponent = (TitledPane) nodeBox.getParent().getParent();
        nodeGUIComponent.setContent(nodeBox);
    }
}
