package game;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Random;

public class GameThread extends Thread{
    private Thread gameThread;
    private Pane gamePane;

    public GameThread(Pane gamePane){
        this.gamePane = gamePane;
        gameThread = new Thread(() -> {
            try{
                while (!gameThread.isInterrupted()) {
                    Platform.runLater(this::addEgg);

                    Thread.sleep(4000);
                }
            }catch (InterruptedException ignore){
            }
        });
    }

    public void start(){
        gameThread.start();
    }

    public void stopThread(){gameThread.interrupt();}

    public void addEgg(){
        ImageView test = new ImageView("file:images/Egg.png");
        gamePane.getChildren().add(test);

        Random r = new Random();
        int pom = r.nextInt(100);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(test);
        pathTransition.setDuration(Duration.seconds(3));

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), test);
        rotateTransition.setFromAngle(0);

        Path path = new Path();

        switch (pom % 4){
            case 0 ->{
                //lewy gorny rog
                path.getElements().add(new MoveTo(20,90));
                path.getElements().add(new LineTo(110,120));

                pathTransition.setPath(path);
                rotateTransition.setToAngle(720);
            }
            case 1 -> {
                //prawy gorny rog
                path.getElements().add(new MoveTo(450,90));
                path.getElements().add(new LineTo(380,120));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(-720);
            }
            case 2 -> {
                //lewy dolny rog
                path.getElements().add(new MoveTo(20,150));
                path.getElements().add(new LineTo(110,200));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(720);
            }
            case 3 -> {
                //prawy dolny rog
                path.getElements().add(new MoveTo(450,150));
                path.getElements().add(new LineTo(380,200));
                pathTransition.setPath(path);
                rotateTransition.setToAngle(-720);
            }
        }

        rotateTransition.play();
        pathTransition.play();

    }
}
