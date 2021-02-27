package gui.components.buttons;

import conversationElements.Response;
import gui.GUI;
import gui.IComponent;
import gui.components.NodeChoiceDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddNodeLinkButton implements IComponent<HBox>, EventHandler<ActionEvent> {

    private final Button addNodeLinkButton;
    private final HBox hbox;
    private final Label label;
    private static final String LABEL_TEXT = "Linked to: ";

    public AddNodeLinkButton() {
        this.addNodeLinkButton = new Button("⛓️");
        this.addNodeLinkButton.setOnAction(this);
        this.hbox = new HBox(5);

        this.label = new Label(LABEL_TEXT + " Unlinked");

        this.hbox.getChildren().addAll(label, addNodeLinkButton);
    }

    @Override
    public HBox getComponent() {
        return this.hbox;
    }

    @Override
    public void handle(ActionEvent event) {
        ChoiceDialog<String> dialog = new NodeChoiceDialog().getComponent();
        dialog.showAndWait();

        VBox responseGuiComponent = (VBox) this.addNodeLinkButton.getParent().getParent();

        int nextNodeId = Integer.parseInt(dialog.getSelectedItem());
        int responseId = Integer.parseInt(responseGuiComponent.getId().replaceAll("Response ", ""));

        for (Response response : GUI.RESPONSE_LIST) {
            if (response.getResponseId() == responseId) {
                response.setNextNode(nextNodeId);
                break;
            }
        }

        this.label.setText(LABEL_TEXT + " " + nextNodeId);
    }
}
