package gui.components;

import actions.AdvanceAndRemember;
import actions.PayAndAdvance;
import actions.RememberFromChat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ResponsesComboBox implements IComponent<HBox>, EventHandler<ActionEvent> {
    private final HBox hbox;
    private final ComboBox<String> comboBox;

    public ResponsesComboBox() {
        this.hbox = new HBox(5);

        this.comboBox = new ComboBox<>();
        this.comboBox.setOnAction(this);
        comboBox.getItems().addAll(
                "Advance and Remember",
                "Advance Conversation",
                "Change Reputation",
                "Open Trade",
                "Pay and Advance",
                "Remember from Chat"
        );

        Label label = new Label("Actions");

        this.hbox.getChildren().addAll(label, comboBox);
    }


    @Override
    public HBox getComponent() {
        return this.hbox;
    }

    @Override
    public void handle(ActionEvent event) {
        String action = this.comboBox.getSelectionModel().getSelectedItem();

        // Remove prexisting custom components if there are any
        ArrayList<Node> removalCandidates = new ArrayList<>();
        for (Node child : this.hbox.getChildren()) {
            if (child.getId() != null) {
                boolean isCustomGUIAction = child.getId().equals(AdvanceAndRemember.ACTION_STRING) ||
                        child.getId().equals(PayAndAdvance.ACTION_STRING) ||
                        child.getId().equals(RememberFromChat.ACTION_STRING);

                if (isCustomGUIAction) {
                    removalCandidates.add(child);
                }
            }
        }

        this.hbox.getChildren().removeAll(removalCandidates);

        // Add custom action control
        switch (action) {
            case "Advance and Remember":
                this.hbox.getChildren().add(AdvanceAndRemember.getGUIComponent());
                break;
            case "Pay and Advance":
                this.hbox.getChildren().add(PayAndAdvance.getGUIComponent());
                break;
            case "Remember from Chat":
                this.hbox.getChildren().add(RememberFromChat.getGUIComponent());
                break;
        }

    }
}
