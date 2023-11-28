package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("World Of water!");
        stage.setScene(scene);
        Image pic1 = new Image("/ENTRY PIC.png");
        stage.getIcons().add(pic1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}