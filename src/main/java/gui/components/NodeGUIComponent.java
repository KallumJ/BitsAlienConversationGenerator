package gui.components;

import conversationElements.Node;
import gui.GUI;
import gui.IComponent;
import gui.components.buttons.AddNodeTextButton;
import gui.components.buttons.AddResponsesButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class to model a conversation node as a GUI component
 */
public class NodeGUIComponent implements IComponent<TitledPane> {
    private final TitledPane titledPane;
    private final Node node;

    /**
     * Constructs a NodeGUIComponent Object
     */
    public NodeGUIComponent() {
        this.node = new Node();
        this.titledPane = setupTitledPane();
        this.titledPane.setPadding(new Insets(30));

        GUI.NODE_MAP.put(this.getNode().getId(), this.node);
    }

    /**
     * Configure the Titled Pane with the appropriate properties
     *
     * @return TitledPane, the configured TitledPane
     */
    private TitledPane setupTitledPane() {
        // Configure Titled Pane properties
        TitledPane titledPane = new TitledPane();
        titledPane.setText("Node " + node.getId());
        titledPane.setCollapsible(false);
        titledPane.setPadding(new Insets(10));

        // Set up Titled Pane content
        HBox nodeHeader = new NodeHeader().getComponent();
        Button nodeTextButton  = new AddNodeTextButton().getComponent();
        Button addResponsesButton = new AddResponsesButton().getComponent();

        // Add to titled pane
        VBox vbox = new VBox(10);
        vbox.setId("Node " + node.getId());
        vbox.getChildren().addAll(nodeHeader, nodeTextButton, addResponsesButton);

        titledPane.setContent(vbox);

        return titledPane;
    }

    /**
     * Returns the TitledPane
     *
     * @return TitledPane, the titled pane
     */
    @Override
    public TitledPane getComponent() {
        return this.titledPane;
    }

    public Node getNode() {
        return node;
    }
}
