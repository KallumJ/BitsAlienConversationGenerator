package gui.components;

import conversationElements.Response;
import gui.components.buttons.AddNodeLinkButton;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ResponseGUIComponent implements IComponent<VBox> {
    private final VBox vbox;
    private Response response;

    private static final String CSS_STYLING = "-fx-border-color: gray;\n" +
            "-fx-border-insets: 10;\n" +
            "-fx-border-width: 3;\n" +
            "-fx-border-style: solid;\n";

    public ResponseGUIComponent() {
        this.response = new Response();

        this.vbox = new VBox(5);
        this.vbox.setPadding(new Insets(5));
        this.vbox.setStyle(CSS_STYLING);
        this.vbox.setId("Response " + response.getResponseId());

        HBox responseText = new GUITextField("Response text").getComponent();
        HBox responseActionComboBox = new ResponsesComboBox().getComponent();
        HBox addNextNode = new AddNodeLinkButton().getComponent();
        this.vbox.getChildren().addAll(addNextNode, responseText, responseActionComboBox);
    }

    @Override
    public VBox getComponent() {
        return this.vbox;
    }

    public Response getResponse() {
        return response;
    }
}
