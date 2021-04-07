package gui.components.buttons;

import actions.*;
import conversationElements.Conversation;
import conversationElements.ConvoNode;
import conversationElements.Response;
import gui.GUI;
import gui.components.IComponent;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class to model a button that builds the conversation currently modelled in the GUI
 */
public class BuildConversationButton implements IComponent<Button>, EventHandler<ActionEvent> {
    private final Button buildConvoButton;

    /**
     * Constructs a BuildConversationButton object
     */
    public BuildConversationButton() {
        this.buildConvoButton = new Button("Build Conversation");
        this.buildConvoButton.setOnAction(this);
    }

    /**
     * Returns the button
     *
     * @return Button, the button
     */
    @Override
    public Button getComponent() {
        return this.buildConvoButton;
    }

    /**
     * A method to be called when the Build Conversation button is pressed
     *
     * @param event ActionEvent, the invoking event
     */
    @Override
    public void handle(ActionEvent event) {
        Conversation conversationObject = new Conversation();

        ArrayList<TitledPane> nodesOnScreen = getNodesOnScreen();

        // For every node component on screen
        for (TitledPane nodeGUIComponent : nodesOnScreen) {
            // Find the current node components corresponding ConvoNode
            int currentNodeId = Integer.parseInt(nodeGUIComponent.getText().replaceAll("Node ", ""));
            ConvoNode currentConvoNode = GUI.NODE_MAP.get(currentNodeId);

            // Declare information required for each node
            ArrayList<String> nodeTexts = new ArrayList<>();
            ArrayList<Response> nodeResponses = new ArrayList<>();

            // Drilldown to relevant GUI component
            VBox nodeContainer = (VBox) nodeGUIComponent.getContent();
            ObservableList<Node> nodeComponents = nodeContainer.getChildren();

            // For all the components that make up a node component
            nodeComponents.forEach(node -> {
                // If the current component is a text component
                if (node.getId() != null) {
                    if (node.getId().equals("Node text")) {
                        nodeTexts.add(getNodeText(node));
                        // If the current component is a response component
                    } else if (node.getId().contains("Response")) {

                        // Find current response
                        int currentResponseId = Integer.parseInt(node.getId().replaceAll("Response ", ""));
                        Response currentResponse = null;

                        for (Response response : GUI.RESPONSE_LIST) {
                            if (response.getResponseId() == currentResponseId) {
                                currentResponse = response;
                                break;
                            }
                        }

                        currentResponse.setText(getResponseText(node));
                        currentResponse.setAction(getAction(node));

                        nodeResponses.add(currentResponse);
                    }
                }
            });

            currentConvoNode.setNodeTexts(nodeTexts);
            currentConvoNode.setResponseList(nodeResponses);
            conversationObject.addNode(currentConvoNode);
        }

        saveToFile(conversationObject.getJsonString());
    }

    private void saveToFile(String jsonString) {
        try {
            PrintWriter printWriter = new PrintWriter("./output/outputJson" +
                    ThreadLocalRandom.current().nextInt(1000) +
                    ".json");

            printWriter.print(jsonString);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private IAction getAction(Node node) {
        HBox actionComboBoxContainer = getActionComboBoxContainer(node);
        VBox extras;

        try {
            extras = (VBox) actionComboBoxContainer.getChildren().get(2);
        } catch (IndexOutOfBoundsException ex) {
            extras = null;
        }

        ComboBox<String> actionComboBox = (ComboBox<String>) actionComboBoxContainer.getChildren().get(1);

        String selectedAction = actionComboBox.getSelectionModel().getSelectedItem();

        IAction action = null;
        switch (selectedAction) {
            case "Advance and Remember":
                if (extras != null) {
                    String key = "";
                    String value = "";
                    for (Node extra : extras.getChildren()) {
                        if (extra.getId().equals("Key")) {
                            key = getKeyFromNode(extra);
                        } else if (extra.getId().equals("Value")) {
                            value = getValueFromNode(extra);
                        }
                    }

                    action = new AdvanceAndRemember(key, value);
                }
                break;
            case "Advance Conversation":
                action = new AdvanceConversation();
                break;
            case "Change Reputation":
                action = new ChangeReputation();
                break;
            case "Open Trade":
                action = new OpenTrade();
                break;
            case "Pay and Advance":
                if (extras != null) {
                    String item = "";
                    for (Node extra : extras.getChildren()) {
                        if (extra.getId().equals("Item")) {
                            item = getItemFromNode(extra);
                        }
                    }

                    action = new PayAndAdvance(item);
                }
                break;
            case "Remember from Chat":

                if (extras != null) {
                    String key = "";
                    for (Node extra : extras.getChildren()) {
                        if (extra.getId().equals("Key")) {
                            key = getKeyFromNode(extra);
                        }
                    }

                    action = new RememberFromChat(key);
                }
                break;
        }

        return action;
    }

    private ArrayList<TitledPane> getNodesOnScreen() {
        // Drilldown through GUI levels to relevant component
        ScrollPane scrollPane = (ScrollPane) GUI.layout.getChildren().get(1);
        TilePane nodesContainer = (TilePane) scrollPane.getContent();

        // Create list of all nodes on screen
        ArrayList<TitledPane> nodesOnScreen = new ArrayList<>();
        for (Node node : nodesContainer.getChildren()) {
            nodesOnScreen.add((TitledPane) node);
        }

        return nodesOnScreen;
    }

    private String getNodeText(Node node) {
        HBox hbox = (HBox) node;
        TextField textfield = (TextField) hbox.getChildren().get(1);

        return textfield.getText();
    }

    private String getResponseText(Node node) {
        VBox vbox = (VBox) node;

        HBox responseTextHbox = (HBox) vbox.getChildren().get(1);
        TextField responseTextField = (TextField) responseTextHbox.getChildren().get(1);

        return responseTextField.getText();
    }

    private HBox getActionComboBoxContainer(Node node) {
        VBox vbox = (VBox) node;

        return (HBox) vbox.getChildren().get(2);

    }

    private String getKeyFromNode(Node node) {
        HBox keyBox = (HBox) node;
        ObservableList<Node> keyComponents = keyBox.getChildren();

        TextField keyTextField = (TextField) keyComponents.get(1);
        return keyTextField.getText();
    }

    private String getValueFromNode(Node node) {
        HBox valueBox = (HBox) node;
        ObservableList<Node> valueComponents = valueBox.getChildren();

        TextField valueTextField = (TextField) valueComponents.get(1);
        return valueTextField.getText();
    }

    private String getItemFromNode(Node node) {
        HBox itemBox = (HBox) node;

        ObservableList<Node> itemComponents = itemBox.getChildren();
        TextField itemTextField = (TextField) itemComponents.get(1);

        return itemTextField.getText();
    }
}
