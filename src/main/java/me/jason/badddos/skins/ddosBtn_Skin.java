package me.jason.badddos.skins;

import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;




public class ddosBtn_Skin extends ButtonSkin {

    public ddosBtn_Skin(Button button) {
        super(button);

        // Initial button styles
        button.setStyle("-fx-background-color: black; -fx-text-fill: red;");

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: red; -fx-text-fill: black;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: black; -fx-text-fill: red;"));
    }
}