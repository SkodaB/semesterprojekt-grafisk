package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Eow dig!");
    }

    @FXML
    public void toEntry() {
        try {
            GameApplication.loadScene("hello-view.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void toSouthCave(ActionEvent event) {
        try {
            GameApplication.loadScene("southcave.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void toNorthCave(ActionEvent event) {
        try {
            GameApplication.loadScene("NorthCave.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void toEastCave(ActionEvent event) {
        try {
            GameApplication.loadScene("EastCave.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void toWestCave(ActionEvent event) {
        try {
            GameApplication.loadScene("WestCave.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}