package game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GamePane extends Pane {
    Label score = new Label("000");
    Label healths = new Label("4");
    Label time = new Label("00:00");
    public GamePane(){
        setPrefSize(490,320);
        setLayoutX(267);
        setLayoutY(147);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/gameTemplate.png",490, 320, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));

        getChildren().add(score);

        getChildren().add(time);
        time.setLayoutX(230);
        getChildren().add(healths);
        healths.setLayoutX(400);
    }
}
