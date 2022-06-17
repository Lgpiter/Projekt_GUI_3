package game;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mainMenu.MainMenu;

public class Game extends Pane {
    GamePane gamePane = new GamePane();
    Stage primaryStage;

    public Game(Stage primaryStage){
        this.primaryStage = primaryStage;

        setPrefSize(1024,614);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/gameGraffic.png",1024, 614, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setX((screenBounds.getWidth() - 1024) / 2);
        primaryStage.setY((screenBounds.getHeight() - 614) / 2);

        addButtons();

        getChildren().add(gamePane);

        setShortCut();
    }

    public void addButtons(){
        GameButton leftUp = new GameButton();
        getChildren().add(leftUp);
        leftUp.setPosition(70,370);
        leftUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gamePane.moveLeft();
            }
        });

        GameButton leftDown = new GameButton();
        getChildren().add(leftDown);
        leftDown.setPosition(70,480);
        leftDown.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Lewy dolny");
            }
        });

        GameButton RightUp = new GameButton();
        getChildren().add(RightUp);
        RightUp.setPosition(860,370);
        RightUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gamePane.moveRight();
            }
        });

        GameButton RightDown = new GameButton();
        getChildren().add(RightDown);
        RightDown.setPosition(860,480);
        RightDown.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Prawy dolny");
            }
        });
    }

    public void spawnEgg(){

    }

    public void setShortCut(){
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCombination myCombination = KeyCombination.keyCombination("CTRL+SHIFT+Q");
                if(myCombination.match(keyEvent))
                    exitGame();
            }
        });
    }

    public void exitGame(){
        gamePane.getTimer().stopThread();
        primaryStage.setScene(new Scene(new MainMenu(primaryStage),1024,614));
    }
}
