package gui.components;

import gui.IComponent;
import gui.components.buttons.RemoveNodeButton;
import javafx.scene.layout.HBox;

public class NodeHeader implements IComponent<HBox> {
    private final HBox hbox;

    public NodeHeader() {
        this.hbox = new HBox(5);
        this.hbox.getChildren().addAll(new RemoveNodeButton().getComponent());
    }

    @Override
    public HBox getComponent() {
        return hbox;
    }
}
