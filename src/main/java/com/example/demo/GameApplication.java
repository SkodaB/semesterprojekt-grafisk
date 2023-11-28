package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    public static Stage theStage;

    @Override
    public void start(Stage stage) throws IOException {
        theStage = stage;
        //FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("World Of water!");
        //stage.setScene(scene);
        loadScene("hello-view.fxml");
        //Image pic1 = new Image("src\\main\\resources\\com\\example\\demo\\ENTRY PIC.png");
        //stage.getIcons().add(pic1);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadScene(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(),320,240);
        theStage.setTitle("Worlder of water!");
        theStage.setScene(scene);
        theStage.show();
    }
}