import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Bamboo {
    private Rectangle stem;
    private Rectangle dash0;
    private Rectangle dash1;
    private Rectangle dash2;

    public Bamboo(Pane myPane) {
        this.setupStem();
        this.setupDashes();
        myPane.getChildren().addAll(stem, dash0, dash1, dash2);
    }

    private void setupDashes() {
        this.dash0 = new Rectangle(Constants.BAMBOO_WIDTH, Constants.DASH_HEIGHT);
        this.dash1 = new Rectangle(Constants.BAMBOO_WIDTH, Constants.DASH_HEIGHT);
        this.dash2 = new Rectangle(Constants.BAMBOO_WIDTH, Constants.DASH_HEIGHT);
        this.dash0.setFill(javafx.scene.paint.Color.BLACK);
        this.dash1.setFill(javafx.scene.paint.Color.BLACK);
        this.dash2.setFill(javafx.scene.paint.Color.BLACK);
        this.dash0.setX(Constants.X_OFFSET);
        this.dash1.setX(Constants.X_OFFSET);
        this.dash2.setX(Constants.X_OFFSET);
        this.dash0.setY(Constants.Y_OFFSET + 170);
        this.dash1.setY(Constants.Y_OFFSET + 195);
        this.dash2.setY(Constants.Y_OFFSET + 220);
    }

    private void setupStem() {
        this.stem = new Rectangle(Constants.BAMBOO_WIDTH, Constants.BAMBOO_HEIGHT);
        this.stem.setFill(javafx.scene.paint.Color.GREEN);
        this.stem.setX(Constants.X_OFFSET);
        this.stem.setY(Constants.Y_OFFSET + 150);
    }
}
