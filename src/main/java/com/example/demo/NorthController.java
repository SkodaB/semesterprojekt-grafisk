package com.example.demo;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;

public class NorthController  {
    @FXML private ImageView northImageView;
    @FXML Button myButton;
    @FXML private Image nCavePic = new Image ("northcave.png");
    public void displayImage(){
        northImageView.setImage(nCavePic);
    }






}
