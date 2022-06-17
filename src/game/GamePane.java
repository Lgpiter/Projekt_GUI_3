package game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GamePane extends Pane {
    private Label scoreLabel = new Label("0");
    private Label healthsLabel = new Label("4");
    private Label timeLabel = new Label("00:00");

    private int mousePosition = 1;

    private Timer timer = new Timer(timeLabel);
    private GameThread gameThread = new GameThread(this);

    private ImageView leftMouse = new ImageView("file:images/mouseLeft.png");
    private ImageView rightMouse = new ImageView("file:images/mouseRight.png");
    private ImageView hands;


    public GamePane(){
        setPrefSize(490,320);
        setLayoutX(267);
        setLayoutY(147);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/Background.png",490, 320, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));


        Label pom1 = new Label("Score: ");
        getChildren().add(pom1);
        pom1.setLayoutX(50);
        getChildren().add(scoreLabel);
        scoreLabel.setLayoutX(100);

        moveLeftUp();

        getChildren().add(timeLabel);
        timeLabel.setLayoutX(230);

        Label pom3 = new Label("Healths: ");
        getChildren().add(pom3);
        pom3.setLayoutX(350);
        getChildren().add(healthsLabel);
        healthsLabel.setLayoutX(400);

        timer.startThred();
        gameThread.start();
    }

    public Timer getTimer() {
        return timer;
    }

    public GameThread getGameThread() {
        return gameThread;
    }

    public void moveRightUp(){
        getChildren().remove(rightMouse);
        getChildren().remove(leftMouse);
        getChildren().remove(hands);

        hands = new ImageView("file:images/rightHands.png");
        hands.setFitWidth(80);
        hands.setFitHeight(80);
        getChildren().add(hands);
        hands.setLayoutX(320);
        hands.setLayoutY(110);

        rightMouse.setFitHeight(300);
        rightMouse.setFitWidth(75);
        getChildren().add(rightMouse);


        rightMouse.setLayoutX(270);
        rightMouse.setLayoutY(30);
    }

    public void moveLeftUp(){
        getChildren().remove(rightMouse);
        getChildren().remove(leftMouse);
        getChildren().remove(hands);

        hands = new ImageView("file:images/leftHands.png");
        hands.setFitWidth(80);
        hands.setFitHeight(80);
        getChildren().add(hands);
        hands.setLayoutX(110);
        hands.setLayoutY(110);

        leftMouse.setFitHeight(300);
        leftMouse.setFitWidth(75);
        getChildren().add(leftMouse);


        leftMouse.setLayoutX(160);
        leftMouse.setLayoutY(30);
    }

    public void moveRightDown(){
        getChildren().remove(rightMouse);
        getChildren().remove(leftMouse);
        getChildren().remove(hands);

        hands = new ImageView("file:images/rightDownHands.png");
        hands.setFitWidth(80);
        hands.setFitHeight(80);
        getChildren().add(hands);
        hands.setLayoutX(320);
        hands.setLayoutY(170);

        rightMouse.setFitHeight(300);
        rightMouse.setFitWidth(75);
        getChildren().add(rightMouse);


        rightMouse.setLayoutX(270);
        rightMouse.setLayoutY(30);
    }

    public void moveLeftDown(){
        getChildren().remove(rightMouse);
        getChildren().remove(leftMouse);
        getChildren().remove(hands);

        hands = new ImageView("file:images/leftHandsDown.png");
        hands.setFitWidth(80);
        hands.setFitHeight(80);
        getChildren().add(hands);
        hands.setLayoutX(110);
        hands.setLayoutY(170);

        leftMouse.setFitHeight(300);
        leftMouse.setFitWidth(75);
        getChildren().add(leftMouse);


        leftMouse.setLayoutX(160);
        leftMouse.setLayoutY(30);
    }

    public void setMousePosition(int mousePosition) {
        this.mousePosition = mousePosition;
    }

    public int getMousePosition() {
        return mousePosition;
    }

    public String getScore() {
        return scoreLabel.getText();
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public String getHealts(){
        return healthsLabel.getText();
    }
    public Label getHealthsLabel() {
        return healthsLabel;
    }
}
