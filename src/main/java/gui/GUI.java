package gui;

import conversationElements.Node;
import conversationElements.Response;
import gui.components.NodesBox;
import gui.components.buttons.AddNodeButton;
import gui.components.buttons.BuildConversationButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class to model and display a GUI to build a conversation using JavaFX
 */
public class GUI extends Application {
    private static final String STAGE_TITLE = "Alien Conversation Builder";
    private static final int WINDOW_WIDTH = 1900;
    private static final int WINDOW_HEIGHT = 1500;

    public static final HBox WINDOW_BOX = new HBox(10);
    public static final NodesBox NODES_BOX = new NodesBox();
    public static final HashMap<Integer, Node> NODE_MAP = new HashMap<>();
    public static final ArrayList<Response> RESPONSE_LIST = new ArrayList<>();

    // Starts the gui
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(STAGE_TITLE);

        Button addNodeButton = new AddNodeButton().getComponent();
        Button buildConvoButton = new BuildConversationButton().getComponent();

        WINDOW_BOX.getChildren().addAll(addNodeButton, buildConvoButton);

        VBox layout = new GUILayout().getLayout();
        layout.getChildren().addAll(WINDOW_BOX, NODES_BOX.getComponent());

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);

        Scene scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
