package gui.components;

import gui.GUI;
import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;

public class NodeChoiceDialog implements IComponent<ChoiceDialog<String>> {
    private final ChoiceDialog<String> choiceDialog;

    public NodeChoiceDialog() {

        ArrayList<String> nodeIds = new ArrayList<>();
        for (Integer id : GUI.NODE_MAP.keySet()) {
            nodeIds.add(String.valueOf(id));
        }

        this.choiceDialog = new ChoiceDialog<>(nodeIds.get(0), nodeIds);
        this.choiceDialog.setTitle("Node Selection");
        this.choiceDialog.setHeaderText("Choose a node: ");
    }

    @Override
    public ChoiceDialog<String> getComponent() {
        return this.choiceDialog;
    }

}
