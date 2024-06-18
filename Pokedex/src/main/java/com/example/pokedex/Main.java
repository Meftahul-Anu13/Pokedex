package com.example.pokedex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root  = FXMLLoader.load(getClass().getResource("Pokedex_list.fxml"));
        primaryStage.setTitle("Pokedex");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
