package gui.components;

import gui.GUI;
import gui.IComponent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;

/**
 * A class to model a grid to hold the Nodes in the conversation
 */
public class NodesBox implements IComponent<ScrollPane> {

    private final TilePane tilePane;

    /**
     * Constructs the NodesBox object
     */
    public NodesBox() {
        this.tilePane = new TilePane();
        this.tilePane.setAlignment(Pos.CENTER);
        this.tilePane.setId("nodesContainer");
    }

    /**
     * A method to add a node to the grid
     *
     * @param node NodeGUIComponent
     */
    public void addNode(Node node) {
        tilePane.getChildren().add(node);
    }

    /**
     * Returns the grid
     *
     * @return TilePane, the grid
     */
    @Override
    public ScrollPane getComponent() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(tilePane);
        return scrollPane;
    }

    public void removeNode(TitledPane component, Integer nodeId) {
        this.tilePane.getChildren().remove(component);
        GUI.NODE_MAP.remove(nodeId);
    }
}
