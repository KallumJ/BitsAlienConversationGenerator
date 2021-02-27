package gui.components.buttons;

import gui.components.IComponent;
import gui.components.NodeGUIComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import static gui.GUI.NODES_BOX;

/**
 * A class to model an AddNodeButton in the GUI
 */
public class AddNodeButton implements EventHandler<ActionEvent>, IComponent<Button> {
    private final Button button;

    /**
     * Constructs an AddNodeButton with the appropriate label and event handler
     */
    public AddNodeButton() {
        this.button = new Button("+");
        this.button.setOnAction(this);
    }

    /**
     * A method to be called when an Add Node Button is clicked
     *
     * @param event the invoking method
     */
    @Override
    public void handle(ActionEvent event) {
        NODES_BOX.addNode(new NodeGUIComponent().getComponent());
    }

    /**
     * Returns the Button
     *
     * @return Button, the button
     */
    @Override
    public Button getComponent() {
        return this.button;
    }
}
