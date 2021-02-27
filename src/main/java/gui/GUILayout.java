package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * A class to model the layout of the GUI
 */
public class GUILayout {
    public final VBox layout;

    /**
     * Constructs a GUILayout object
     */
    public GUILayout() {
        this.layout = new VBox();

        this.layout.setAlignment(Pos.TOP_LEFT);
        this.layout.setPadding(new Insets(20));
    }

    /**
     * Returns the layout in the form of a VBox
     * @return VBox, the layout
     */
    public VBox getLayout() {
        return this.layout;
    }
}
