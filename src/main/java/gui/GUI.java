package gui;

import gui.components.AddNodeButton;
import gui.components.BuildConversationButton;
import gui.components.NodesBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A class to model and display a GUI to build a conversation using JavaFX
 */
public class GUI extends Application {
    private static final String STAGE_TITLE = "Alien Conversation Builder";
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1200;

    public static final HBox WINDOW_BOX = new HBox(10);
    public static final NodesBox NODES_BOX = new NodesBox();

    // Starts the gui
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(STAGE_TITLE);

        Button addNodeButton = new AddNodeButton().getComponent();
        Button buildConvoButton = new BuildConversationButton().getComponent();

        WINDOW_BOX.getChildren().addAll(addNodeButton, buildConvoButton);

        VBox layout = new GUILayout().getLayout();
        layout.getChildren().addAll(WINDOW_BOX, NODES_BOX.getComponent());

        Scene scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
