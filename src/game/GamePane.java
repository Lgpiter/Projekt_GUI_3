package game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.layout.*;

public class GamePane extends Pane {
    private Label score = new Label("000");
    private Label healths = new Label("4");
    private Label timeLabel = new Label("00:00");

    private Timer timer = new Timer(timeLabel);


    public GamePane(){
        setPrefSize(490,320);
        setLayoutX(267);
        setLayoutY(147);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/Background.png",490, 320, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));

        getChildren().add(score);

        getChildren().add(timeLabel);
        timeLabel.setLayoutX(230);
        getChildren().add(healths);
        healths.setLayoutX(400);

    }

    public Timer getTimer() {
        return timer;
    }
}
