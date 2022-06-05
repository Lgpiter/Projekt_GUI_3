package mainMenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MainMenu extends VBox {
    public MainMenu(){
        Label label = new Label("Hello in Mickey Mouse game");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100,50);

        Button highScores = new Button("High Scores");
        highScores.setPrefSize(100,50);

        Button exit = new Button("Exit");
        exit.setPrefSize(100,50);
        exit.setOnAction(actionEvent -> System.exit(0));

        getChildren().addAll(label,newGame,highScores,exit);

        setSpacing(50);
        setAlignment(Pos.CENTER);

        BackgroundImage myBackground = new BackgroundImage(new Image("D:\\Projekt_GUI_3\\images\\menuBackground.jpg",500, 500, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));
    }
}
