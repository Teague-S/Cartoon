import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.QuadCurve;

public class Cartoon {
    private Ellipse face;
    private Circle pupilLeft;
    private Circle pupilRight;
    private Ellipse eyeLeft;
    private Ellipse eyeRight;
    private Ellipse nose;
    private QuadCurve mouth;
    private Ellipse earLeft;
    private Ellipse earRight;
    private boolean mR = true;

    public Cartoon(Pane myPane) {
        this.setUpFace();
        this.setUpEyes();
        this.setUpPupils();
        this.setUpNose();
        this.mouth = new QuadCurve(Constants.MOUTH_RIGHT_X,
                Constants.MOUTH_Y, Constants.X_OFFSET,
                Constants.MOUTH_MIDDLE_HEIGHT, Constants.MOUTH_LEFT_X, Constants.MOUTH_Y);
        this.setupEars();
        this.setXLoc(Constants.X_OFFSET);
        this.setYLoc(Constants.Y_OFFSET);
        myPane.getChildren().addAll(this.earLeft, this.earRight, this.face, this.eyeLeft, this.eyeRight, this.pupilLeft,
                this.pupilRight, this.nose, this.mouth);
    }

    public void move() {
        if (this.face.getCenterX() == Constants.APP_WIDTH) {
            mR = false;
        } else if (this.face.getCenterX() == 0) {
            mR = true;
        }
        if (mR == true) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    public Circle getPupilLeft() {
        return pupilLeft;
    }

    public Circle getPupilRight() {
        return pupilRight;
    }

    public double getCenterX() {
        return face.getCenterX();
    }

    public void moveUp() {
        this.setYLoc(this.face.getCenterY() + Constants.DISTANCE_Y);
    }

    public void moveDown() {
        this.setYLoc(this.face.getCenterY() - Constants.DISTANCE_Y);
    }

    public void moveRight() {
        this.setXLoc(this.face.getCenterX() + Constants.DISTANCE_X);
    }

    public void moveLeft() {
        this.setXLoc(this.face.getCenterX() - Constants.DISTANCE_X);
    }

    private void setYLoc(double y) {
        this.face.setCenterY(y);
        this.pupilLeft.setCenterY(y);
        this.pupilRight.setCenterY(y);
        this.eyeLeft.setCenterY(y);
        this.eyeRight.setCenterY(y);
        this.nose.setCenterY(y);
        this.setUpMouth(this.mouth.getStartX(), y + Constants.MOUTH_Y_OFFSET, this.mouth.getControlX(),
                y + Constants.MOUTH_MID_Y_OFFSET, this.mouth.getEndX());
        this.earLeft.setCenterY(y - Constants.EAR_Y_OFFSET);
        this.earRight.setCenterY(y - Constants.EAR_Y_OFFSET);
    }

    private void setXLoc(double x) {
        this.face.setCenterX(x);
        this.pupilLeft.setCenterX(x + Constants.PUPIL_X_OFFSET);
        this.pupilRight.setCenterX(x - Constants.PUPIL_X_OFFSET);
        this.eyeLeft.setCenterX(x + Constants.EYE_X_OFFSET);
        this.eyeRight.setCenterX(x - Constants.EYE_X_OFFSET);
        this.nose.setCenterX(x);
        this.setUpMouth(x + Constants.MOUTH_X_OFFSET, this.mouth.getStartY(), x, this.mouth.getControlY(),
                x - Constants.MOUTH_X_OFFSET);
        this.earLeft.setCenterX(x - Constants.EAR_X_OFFSET);
        this.earRight.setCenterX(x + Constants.EAR_X_OFFSET);
    }

    private void setupEars() {
        this.earLeft = new Ellipse(Constants.EYE_WIDTH, Constants.EAR_HEIGHT);
        this.earLeft.setFill(javafx.scene.paint.Color.BLACK);
        this.earLeft.setRotate(Constants.EAR_ANGLE * -1);
        this.earRight = new Ellipse(Constants.EYE_WIDTH, Constants.EAR_HEIGHT);
        this.earRight.setFill(javafx.scene.paint.Color.BLACK);
        this.earRight.setRotate(Constants.EAR_ANGLE);
    }

    private void setUpMouth(double RX, double mouthY, double XMID, double YMID, double LX) {
        this.mouth.setStartX(RX);
        this.mouth.setStartY(mouthY);
        this.mouth.setControlX(XMID);
        this.mouth.setControlY(YMID);
        this.mouth.setEndX(LX);
        this.mouth.setEndY(mouthY);
        this.mouth.setFill(javafx.scene.paint.Color.BLACK);
    }

    private void setUpNose() {
        this.nose = new Ellipse(Constants.NOSE_WIDTH, Constants.NOSE_HEIGHT);
        this.nose.setFill(javafx.scene.paint.Color.BLACK);
    }

    private void setUpEyes() {
        this.eyeLeft = new Ellipse(Constants.EYE_WIDTH, Constants.EYE_HEIGHT);
        this.eyeLeft.setFill(javafx.scene.paint.Color.BLACK);
        this.eyeLeft.setRotate(Constants.EYE_ANGLE * -1);
        this.eyeRight = new Ellipse(Constants.EYE_WIDTH, Constants.EYE_HEIGHT);
        this.eyeRight.setFill(javafx.scene.paint.Color.BLACK);
        this.eyeRight.setRotate(Constants.EYE_ANGLE);
    }

    private void setUpPupils() {
        this.pupilLeft = new Circle(Constants.PUPIL_RADIUS);
        this.pupilLeft.setFill(javafx.scene.paint.Color.WHITE);
        this.pupilRight = new Circle(Constants.PUPIL_RADIUS);
        this.pupilRight.setFill(javafx.scene.paint.Color.WHITE);
    }

    private void setUpFace() {
        this.face = new Ellipse(100, 85);
        this.face.setFill(javafx.scene.paint.Color.WHITE);
        this.face.setStroke(Color.BLACK);
    }
}
