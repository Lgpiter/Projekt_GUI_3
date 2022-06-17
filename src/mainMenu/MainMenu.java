package mainMenu;

import game.Game;
import highScore.HighScores;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainMenu extends Pane {
    Stage primaryStage;
    public MainMenu(Stage primaryStage){
        this.primaryStage = primaryStage;
        setPrefSize(1024,614);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/gameGraffic.png",1024, 614, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setX((screenBounds.getWidth() - 1024) / 2);
        primaryStage.setY((screenBounds.getHeight() - 614) / 2);

        addButtons();

        Pane viewPane = new Pane();
        showViewPane(viewPane);
        getChildren().add(viewPane);

    }

    public void addButtons(){
        MainMenuButton buttonA = new MainMenuButton();
        getChildren().add(buttonA);
        buttonA.setLocation(860,70);
        buttonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.setScene(new Scene(new Game(primaryStage),1024,614));
            }
        });

        MainMenuButton buttonB = new MainMenuButton();
        getChildren().add(buttonB);
        buttonB.setLocation(860,140);
        buttonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.setScene(new Scene(new HighScores(primaryStage),1024,614));
            }
        });

        MainMenuButton buttonC = new MainMenuButton();
        getChildren().add(buttonC);
        buttonC.setLocation(860,210);
        buttonC.setOnMouseClicked(mouseEvent -> primaryStage.close());
    }

    public void showViewPane(Pane viewPane){
        viewPane.setPrefSize(490,320);
        viewPane.setLayoutX(267);
        viewPane.setLayoutY(147);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/MainMenu.png",490, 320, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        viewPane.setBackground(new Background(myBackground));

    }
}
