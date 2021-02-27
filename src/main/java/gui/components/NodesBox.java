package gui.components;

import gui.IComponent;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * A class to model a grid to hold the Nodes in the conversation
 */
public class NodesBox implements IComponent<GridPane> {

    private final GridPane gridPane;

    private int row = 0;
    private int column = 0;

    /**
     * Constructs the NodesBox object
     */
    public NodesBox() {
        this.gridPane = new GridPane();
    }

    /**
     * A method to add a node to the grid
     * @param node NodeGUIComponent
     */
    public void addNode(Node node) {
        gridPane.add(node, column, row);

        // Rollover the current index of the grid when reaching the end
        column++;
        if (column == 4) {
            row++;
            column = 0;
        }

    }

    /**
     * Returns the grid
     * @return GridPane, the grid
     */
    @Override
    public GridPane getComponent() {
        return this.gridPane;
    }
}
