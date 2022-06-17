package game;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Timer extends Thread{
    private int counter_seconds = 0;
    private int counter_minutes = 0;
    private Thread time;

    public Timer(Label label){
        time = new Thread(() -> {
            try{
                while (!time.isInterrupted()) {
                    counter_seconds++;

                    if(counter_seconds == 60) {
                        counter_minutes++;
                        counter_seconds = 0;
                    }
                    String minutes = Integer.toString(counter_minutes);
                    String seconds = Integer.toString(counter_seconds);

                    if(counter_minutes < 10) {
                        if (counter_seconds < 10) {
                            Platform.runLater(() -> {
                                label.setText("0" + minutes + ":0" + seconds);
                            });
                        }
                        else {
                            Platform.runLater(() -> {
                                label.setText("0" + minutes + ":" + seconds);
                            });
                        }
                    }
                    else{
                        if (counter_seconds < 10) {
                            Platform.runLater(() -> {
                                label.setText(minutes + ":0" + seconds);
                            });
                        }
                        else {
                            Platform.runLater(() -> {
                                label.setText(minutes + ":" + seconds);
                            });
                        }
                    }
                    Thread.sleep(1000);
                }
            }catch (InterruptedException ignore){
         }
        }
        );
        time.start();
    }

    public void stopThread(){
        time.interrupt();
    }
}
