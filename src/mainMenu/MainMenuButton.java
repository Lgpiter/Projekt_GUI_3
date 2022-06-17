package mainMenu;

import javafx.scene.control.Button;

public class MainMenuButton extends Button {
    public MainMenuButton(){
        setPrefSize(60,30);
        setBackground(null);
    }

    public void setLocation(int x, int y){
        setLayoutX(x);
        setLayoutY(y);
    }
}
