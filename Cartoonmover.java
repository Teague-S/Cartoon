import javafx.scene.layout.Pane;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.util.*;

public class Cartoonmover {
    private boolean on = false;
    private int count = 0;
    private KeyFrame kf;
    private Timeline timeline;
    private Cartoon cartoon;

    public Cartoonmover(Pane cartoonPane) {
        this.cartoon = new Cartoon(cartoonPane);
        this.setupEyesFrame();
    }

    public Cartoon geCartoon() {
        return cartoon;
    }

    private void setupEyesFrame() {
        kf = new KeyFrame(Duration.seconds(0.5),
                (ActionEvent e) -> colSwap());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void colSwap() {
        if (count % 6 == 0) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.RED);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.RED);
        } else if (count % 6 == 1) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.ORANGE);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.ORANGE);
        } else if (count % 6 == 2) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.YELLOW);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.YELLOW);
        } else if (count % 6 == 3) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.GREEN);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.GREEN);
        } else if (count % 6 == 4) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.BLUE);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.BLUE);
        } else if (count % 6 == 5) {
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.VIOLET);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.VIOLET);
        }
        count++;
    }

    public void colorChanger() {
        if (!on) {
            this.timeline.play();
            on = true;
        } else {
            on = false;
            this.timeline.stop();
            this.cartoon.getPupilLeft().setFill(javafx.scene.paint.Color.WHITE);
            this.cartoon.getPupilRight().setFill(javafx.scene.paint.Color.WHITE);
        }
    }
}
