package gui.components.buttons;

import gui.GUI;
import gui.components.IComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class RemoveNodeButton implements IComponent<Button>, EventHandler<ActionEvent> {

    private final Button removeNodeButton;

    public RemoveNodeButton() {
        this.removeNodeButton = new Button("Delete");
        this.removeNodeButton.setOnAction(this);
    }

    @Override
    public Button getComponent() {
        return this.removeNodeButton;
    }

    @Override
    public void handle(ActionEvent event) {
        Button sendingButton = (Button) event.getSource();
        TitledPane nodeGuiComponent = (TitledPane) sendingButton.getParent().getParent().getParent().getParent();

        int nodeId = Integer.parseInt(nodeGuiComponent.getText().replaceAll("Node ", ""));

        GUI.NODES_BOX.removeNode(nodeGuiComponent, nodeId);
    }
}
