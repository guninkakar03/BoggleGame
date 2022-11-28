//package views;
//
//import boggle.BoggleGame;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.control.*;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class BoggleView {
//
//    BoggleGame game; //reference to game
//    Stage stage;
//
//    // Label to display current word that player has created
//    Label currWordLabel = new Label("");
//
//    /**
//     * Constructor
//     *
//     * @param game reference to Boggle game
//     * @param stage application stage
//     */
//
//    public BoggleView(BoggleGame game, Stage stage) {
//        this.game = game;
//        this.stage = stage;
//        initUI();
//    }
//
//    /**
//     * Initialize interface of the boggle game
//     */
//    private void initUI() {
//        this.stage.setTitle("boggle.edu");
//
//        // Set properties of current word label
//        currWordLabel.setId("CurrentWordLabel");
//
//        currWordLabel.setText("");
//        currWordLabel.setFont(new Font(20));
//        currWordLabel.setStyle("-fx-text-fill: #e8e6e3");
//    }
//}