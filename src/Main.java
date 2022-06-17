import game.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.MainMenu;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenu test = new MainMenu(primaryStage);

        primaryStage.setScene(new Scene(test,1024,614));
        primaryStage.setTitle("Mickey Mouse");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
