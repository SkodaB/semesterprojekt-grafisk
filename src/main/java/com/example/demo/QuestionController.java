package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class QuestionController {
    @FXML private Label qLabel;
    @FXML
    private RadioButton rb1, rb2;

    public void showQuestions(){
        qLabel.setText("What can you do to contribute to the achievement of UNs Goal 6,'\n' with focus on the sub-goal 6.6 and 6.3?");
        if(rb1.isSelected()){
            //viser om hvis det er rigtig eller ej
        }
        else if(rb2.isSelected()){
            //viser om hvis det er rigtig eller ej
        }




    }


}
