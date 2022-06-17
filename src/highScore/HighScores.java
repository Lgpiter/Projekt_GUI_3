package highScore;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mainMenu.MainMenu;
import mainMenu.MainMenuButton;

import java.util.ArrayList;

public class HighScores extends Pane {
    Stage primaryStage;

    private static ArrayList<Player> players = new ArrayList<>();

    public HighScores(Stage primaryStage){
        this.primaryStage = primaryStage;
        setPrefSize(1024,614);
        BackgroundImage myBackground = new BackgroundImage(new Image("file:images/gameGraffic.png",1024, 614, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(myBackground));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setX((screenBounds.getWidth() - 1024) / 2);
        primaryStage.setY((screenBounds.getHeight() - 614) / 2);

        addButtons();


        ListView<Player> viewPane = new ListView<>();
        showViewPane(viewPane);
        getChildren().add(viewPane);

        /*
        showViewPane(viewPane);
        getChildren().add(viewPane);

         */

    }

    public void addButtons(){
        MainMenuButton buttonA = new MainMenuButton();
        getChildren().add(buttonA);
        buttonA.setLocation(860,70);
        buttonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.setScene(new Scene(new MainMenu(primaryStage),1024,614));
            }
        });
    }

    public void showViewPane(ListView viewPane){
        viewPane.setPrefSize(490,320);
        viewPane.setLayoutX(267);
        viewPane.setLayoutY(147);

        viewPane.setItems(FXCollections.observableArrayList(players));

    }

    public static void addPlayer(Player p){
        players.add(p);
    }
}
