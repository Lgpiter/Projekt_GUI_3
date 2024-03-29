package game;

import highScore.HighScores;
import highScore.Player;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainMenu.MainMenu;

import java.util.Random;

public class GameThread extends Thread{
    private Thread gameThread;
    private final GamePane gamePane;

    public GameThread(GamePane gamePane, Stage primaryStage){
        this.gamePane = gamePane;
        gameThread = new Thread(() -> {
                while (!gameThread.isInterrupted()) {
                    if (!continuePlaying()){
                        Platform.runLater(() -> {
                            TextInputDialog text = new TextInputDialog();
                            text.setHeaderText("GAME OVER YOUR SCORE: " + gamePane.getScore());
                            text.setContentText("Write your nickname");
                            text.show();

                            text.setOnCloseRequest(dialogEvent -> {
                                Player p = new Player(text.getResult(), Integer.parseInt(gamePane.getScore()));
                                HighScores.addPlayer(p);
                            });

                            primaryStage.setScene(new Scene(new MainMenu(primaryStage),1024,614));

                        });
                        break;
                    }
                    Platform.runLater(this::addEgg);

                    try {
                        sleep(4000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }

        });
    }

    public void start(){
        gameThread.start();
    }

    public void stopThread(){gameThread.interrupt();}

    public void addEgg(){
        ImageView egg = new ImageView("file:images/Egg.png");
        gamePane.getChildren().add(egg);

        Random r = new Random();
        int pom = r.nextInt(4);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(egg);
        pathTransition.setDuration(Duration.seconds(3));

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), egg);
        rotateTransition.setFromAngle(0);

        Path path = new Path();

        switch (pom % 4){
            case 0 ->{
                //lewy gorny rog
                path.getElements().add(new MoveTo(20,90));
                path.getElements().add(new LineTo(130,130));

                pathTransition.setPath(path);
                rotateTransition.setToAngle(720);

                pathTransition.setOnFinished(actionEvent -> {
                    if(gamePane.getMousePosition() == 1){
                        int pom1 = Integer.parseInt(gamePane.getScore());
                        pom1++;
                        String text = "" + pom1;
                        gamePane.getScoreLabel().setText(text);
                        gamePane.getChildren().remove(egg);
                    }
                    else{
                        int pom1 = Integer.parseInt(gamePane.getHealths());
                        pom1--;
                        String text = "" + pom1;
                        gamePane.getHealthsLabel().setText(text);

                        fallingDownAnimation(130,130,egg);
                    }
                });
            }
            case 1 -> {
                //prawy gorny rog
                path.getElements().add(new MoveTo(450,90));
                path.getElements().add(new LineTo(380,130));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(-720);

                pathTransition.setOnFinished(actionEvent -> {
                    if(gamePane.getMousePosition() == 3){
                        int pom12 = Integer.parseInt(gamePane.getScore());
                        pom12++;
                        String text = "" + pom12;
                        gamePane.getScoreLabel().setText(text);
                        gamePane.getChildren().remove(egg);
                    }
                    else{
                        int pom12 = Integer.parseInt(gamePane.getHealths());
                        pom12--;
                        String text = "" + pom12;
                        gamePane.getHealthsLabel().setText(text);
                        fallingDownAnimation(380,130,egg);
                    }
                });
            }
            case 2 -> {
                //lewy dolny rog
                path.getElements().add(new MoveTo(20,150));
                path.getElements().add(new LineTo(130,210));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(720);

                pathTransition.setOnFinished(actionEvent -> {
                    if(gamePane.getMousePosition() == 2){
                        int pom13 = Integer.parseInt(gamePane.getScore());
                        pom13++;
                        String text = "" + pom13;
                        gamePane.getScoreLabel().setText(text);
                        gamePane.getChildren().remove(egg);
                    }
                    else{
                        int pom13 = Integer.parseInt(gamePane.getHealths());
                        pom13--;
                        String text = "" + pom13;
                        gamePane.getHealthsLabel().setText(text);
                        fallingDownAnimation(130,210,egg);
                    }
                });
            }
            case 3 -> {
                //prawy dolny rog
                path.getElements().add(new MoveTo(450,150));
                path.getElements().add(new LineTo(380,210));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(-720);

                pathTransition.setOnFinished(actionEvent -> {
                    if(gamePane.getMousePosition() == 4){
                        int pom14 = Integer.parseInt(gamePane.getScore());
                        pom14++;
                        String text = "" + pom14;
                        gamePane.getScoreLabel().setText(text);
                        gamePane.getChildren().remove(egg);
                    }
                    else{
                        int pom14 = Integer.parseInt(gamePane.getHealths());
                        pom14--;
                        String text = "" + pom14;
                        gamePane.getHealthsLabel().setText(text);
                        fallingDownAnimation(380,210,egg);
                    }
                });
            }
        }

        rotateTransition.play();
        pathTransition.play();
    }

    public void fallingDownAnimation(int x, int y, ImageView egg){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(egg);
        pathTransition.setDuration(Duration.seconds(3));

        Path path = new Path();
        path.getElements().add(new MoveTo(x,y));
        path.getElements().add(new LineTo(x,gamePane.getHeight() - 30));

        pathTransition.setPath(path);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), egg);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(720);

        pathTransition.play();
        rotateTransition.play();

        pathTransition.setOnFinished(actionEvent -> {
            egg.setImage(new Image("file:images/brokenEgg.png"));
            egg.setFitHeight(50);
            egg.setFitWidth(50);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),egg);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();

        });
    }

    public boolean continuePlaying(){
        int healths = Integer.parseInt(gamePane.getHealths());
        if(healths <= 0) {
            gamePane.getTimer().stopThread();
            return false;
        }
        return true;
    }

}
