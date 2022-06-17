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

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores extends Pane {
    Stage primaryStage;

    private static ArrayList<Player> players = new ArrayList<>();

    public HighScores(Stage primaryStage){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("highscores.bin"))){
            players = (ArrayList<Player>)inputStream.readObject();
            Collections.sort(players);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

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
        File file = new File("highscores.bin");

        if(file.exists()) {
            try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("highscores.bin"))){
                players = (ArrayList<Player>)inputStream.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
            file.delete();
        }

        players.add(p);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
            outputStream.writeObject(players);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
