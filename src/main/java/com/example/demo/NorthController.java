package com.example.demo;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;

public class NorthController  {
    @FXML private ImageView northImageView;
    @FXML Button goSouth;
    @FXML Image sCavePic = new Image (getClass().getResourceAsStream("South-Cave.png"));
    public void displayImage(){
        northImageView.setImage(sCavePic);
    }






}
