import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        Label label = new Label("Hello in Mickey Mouse game");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100,50);

        Button highScores = new Button("High Scores");
        highScores.setPrefSize(100,50);

        Button exit = new Button("Exit");
        exit.setPrefSize(100,50);

        root.getChildren().add(label);


        VBox vbox = new VBox(newGame,highScores,exit);
        vbox.setSpacing(50);
        vbox.setAlignment(Pos.CENTER);


        //changing background of our Vbox
        BackgroundImage myBackground = new BackgroundImage(new Image("D:\\Projekt_GUI_3\\images\\menuBackground.jpg",500,500, false,true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(myBackground));



        Scene scene = new Scene(vbox, 500,500);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Mickey Mouse");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
