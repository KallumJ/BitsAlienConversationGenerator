package gui.components;

import gui.IComponent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * A class to model a GUI Text Field
 */
public class GUITextField implements IComponent<HBox> {
    private final HBox hbox;

    /**
     * Constructs a GUITextField object
     * @param labelText The text to label the textbox with
     */
    public GUITextField(String labelText) {
        this.hbox = new HBox();

        // Configures a HBox with text field and label
        TextField textField = new TextField();
        Label label = new Label(labelText);
        label.setLabelFor(textField);
        label.setPadding(new Insets(5));

        hbox.getChildren().addAll(label, textField);

    }

    /**
     * Return the text field
     * @return HBox, text field and label
     */
    @Override
    public HBox getComponent() {
        return this.hbox;
    }

}
