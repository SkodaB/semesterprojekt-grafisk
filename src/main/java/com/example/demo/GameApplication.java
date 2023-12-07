package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.demo.domain.Main;

public class GameApplication extends Application {

    public static Stage theStage;

    @Override
    public void start(Stage stage) throws IOException {
        theStage = stage;
        loadScene(Main.game()+".fxml");
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadScene(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        theStage.setTitle("World of water!");
        theStage.setScene(scene);
        theStage.show();
    }
}