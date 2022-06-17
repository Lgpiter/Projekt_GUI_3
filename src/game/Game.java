package game;


import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game extends Pane {
    public Game(Stage primaryStage){
        setPrefSize(1024,614);
        BackgroundImage myBackground = new BackgroundImage(new Image("D:\\Projekt_GUI_3\\images\\gameGraffic.png",1024, 614, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setX((screenBounds.getWidth() - 1024) / 2);
        primaryStage.setY((screenBounds.getHeight() - 614) / 2);

        addButtons();

        GamePane pane = new GamePane();
        getChildren().add(pane);
    }

    public void addButtons(){
        GameButton leftUp = new GameButton();
        getChildren().add(leftUp);
        leftUp.setPosition(70,370);
        leftUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Lewy gorny");
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
                System.out.println("Prawy gorny");
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
}
