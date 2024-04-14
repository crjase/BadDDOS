package me.jason.badddos;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;




// Main Application Class
public class Application extends javafx.application.Application {




    @Override
    public void start(Stage stage) throws IOException {

        // Entry Scene: named Home
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("fxml/home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        String css = this.getClass().getResource("css/home-style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Bad DDOS");
        stage.setScene(scene);
        // stage.initStyle(StageStyle.UNDECORATED);
        //stage.setResizable(false);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }
}