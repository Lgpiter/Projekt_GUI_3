import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.MainMenu;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenu main = new MainMenu();

        primaryStage.setScene(new Scene(main,500,500));
        primaryStage.setTitle("Mickey Mouse");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
