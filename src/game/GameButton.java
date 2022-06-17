package game;


import javafx.scene.control.Button;

public class GameButton extends Button {
    GameButton(){
        setPrefSize(85,85);
        setBackground(null);
    }

    public void setPosition(int x, int y){
        setLayoutX(x);
        setLayoutY(y);
    }
}
