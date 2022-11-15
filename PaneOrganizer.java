import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.animation.*;
import javafx.util.*;

public class PaneOrganizer {
    private BorderPane root;
    private Cartoonmover main;
    private Label label;

    public PaneOrganizer() {
        this.root = new BorderPane(); // setup borderpane
        this.setupBottom();
        this.setupCenter();
        this.setupTop();
        this.setupTimeline();
    }

    private void setupTop() {
        HBox top = new HBox();
        label = new Label();
        top.getChildren().add(label);
        this.root.setTop(top);
    }

    private void setupCenter() {
        Pane center = new Pane();
        root.setCenter(center);
        main = new Cartoonmover(center);
        new Bamboo(center);
        center.setFocusTraversable(true);
        center.setOnKeyPressed(KeyEvent -> handleKeyPress(KeyEvent));
    }

    private void setupBottom() {
        HBox bottom = new HBox();
        Button quit = new Button("Quit");
        bottom.getChildren().addAll(quit);
        this.root.setBottom(bottom);
        quit.setOnAction((ActionEvent e) -> System.exit(0));
        bottom.setFocusTraversable(false);
        quit.setFocusTraversable(false);
    }

    private void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(0.0333333333),
                (ActionEvent e) -> this.main.geCartoon().move()); // event handler
        KeyFrame kf2 = new KeyFrame(Duration.seconds(0.0333333333),
                (ActionEvent e) -> this.updateLabel()); // event handler
        Timeline timeline = new Timeline(kf, kf2);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void updateLabel() {
        double Distance = Math.sqrt(
                Math.pow(Math.abs(this.main.geCartoon().getCenterX() - Constants.X_OFFSET), 2) + Math.pow(195, 2));
        label.setText("Distance from Bamboo: " + String.valueOf((int) Distance) + " pixels");
    }

    public BorderPane getRoot() {
        return root;
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        if (keyPressed == KeyCode.SPACE) {
            main.colorChanger();
        }
        e.consume();
    }
}
