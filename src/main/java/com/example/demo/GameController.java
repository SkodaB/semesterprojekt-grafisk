package com.example.demo;

import com.example.demo.domain.*;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.application.Platform;


import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.HashMap;

public class GameController implements Initializable{

    static Map<String,String> responseMsg = new HashMap<>();



    @FXML
    private ListView<Item> inventory;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<Item> items = context.getInventory().getInventoryContents();
        for (int i = 0;i<items.size();i++){
            inventory.getItems().add(items.get(i));
        }
        responseMsg.put("noWaterInItem","You have no water in one item.");
        responseMsg.put("roughFilterSuccess","Water filtered successfully for one item.");
        responseMsg.put("alreadyFiltered","Water has already been through this filter for one item.");
        responseMsg.put("noItems","You have no items in your inventory. Consider going to the shop.");
        responseMsg.put("noWaterInCave","There's no water in this cave.");
        responseMsg.put("locationNotElligible","You cannot collect water here.");
        responseMsg.put("successCollect","You have successfully collected water.");
        responseMsg.put("alreadyFull","One item is already full.");
        responseMsg.put("fineFilterSuccess","One item was finely filtered successfully");
        responseMsg.put("notFilteredOrNoWater","One item is either not filtered properly or there is no water in it at all.");
        responseMsg.put("coalFilterSuccess","Successfully coal filtered for one item.");
        responseMsg.put("wrongLocationn","Wrong location.");
        responseMsg.put("gameCompleted","gameCompleted");

    }

    Context context = Main.getContext();

    @FXML
    private Label welcomeText;
    @FXML
    private Pane shop;
    @FXML
    private Pane shopWarning;
    @FXML
    private Label BucketPrice;
    @FXML
    private Label WheelbarrowPrice;
    @FXML
    private Label FiretruckPrice;
    @FXML
    private Label BucketQuantity;
    @FXML
    private Label WheelbarrowQuantity;
    @FXML
    private Label FiretruckQuantity;
    @FXML
    private Label shopWarningText;

    @FXML
    private Label endScore;

//    @FXML
//    public void toEntry(ActionEvent event){
//        try{
//            GameApplication.loadScene("hello-view.fxml");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }

    @FXML
    public void endApp(){
        Platform.exit();
    }

    public void endGame(){
        try{
            GameApplication.loadScene("endgame.fxml");
            endScore.setText(Double.toString(Main.getContext().getPlayer().getPoints()));
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public void interpreter(String response){
        alerter(responseMsg.get(response));
    }

    public void alerter(String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HUR HUR HUR HUR");
        alert.setContentText(msg);
        if (alert.showAndWait().get() == ButtonType.OK){
            alert.close();
        }
    }

    @FXML
    public void updateInventory(ActionEvent event){
        try{    
            ArrayList<Item> items = Main.getContext().getInventory().getInventoryContents();
            inventory.getItems().clear();
            for(int i = 0;i<items.size();i++){
                inventory.getItems().add(items.get(i));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void collect(ActionEvent event){
        try{
            String response = Main.commandExecute("collect", null);
            interpreter(response);
            updateInventory(event);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void filter(ActionEvent event){
        try {
            String response = Main.commandExecute("clean", null);
            interpreter(response);
            updateInventory(event);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void pour(ActionEvent event){
        try {
            String response = Main.commandExecute("pour", null);
            if(response.equals("gameCompleted")){
                endGame();
            }else{
                interpreter(response);
                updateInventory(event);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void moveNorth(ActionEvent event){
        try{
            if(Main.walk("north")){
            GameApplication.loadScene(Main.game()+".fxml");
            }else{
                wrongDirection(event);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void moveSouth(ActionEvent event){
        try{
            if(Main.walk("south")){
            GameApplication.loadScene(Main.game()+".fxml");
            }else{
                wrongDirection(event);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void moveEast(ActionEvent event){
        try{
            if(Main.walk("east")){
            GameApplication.loadScene(Main.game()+".fxml");
            }else{
                wrongDirection(event);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void moveWest(ActionEvent event){
        try{
            if(Main.walk("west")){
            GameApplication.loadScene(Main.game()+".fxml");
            }else{
                wrongDirection(event);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void toNorthCave(ActionEvent event){
        try{
            GameApplication.loadScene("northcave.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toSouthCave(ActionEvent event){
        try{
            GameApplication.loadScene("southcave.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toEntrance(ActionEvent event){
        try{
            GameApplication.loadScene("entry.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toWestCave(ActionEvent event){
        try{
            GameApplication.loadScene("westcave.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toEastCave(ActionEvent event){
        try{
            GameApplication.loadScene("eastcave.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toShop(ActionEvent event){
        try{
            GameApplication.loadScene("shop.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toWR(ActionEvent event){
        try{
            GameApplication.loadScene("wr.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toRoughFilter(ActionEvent event){
        try{
            GameApplication.loadScene("roughfilter.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toFineFilter(ActionEvent event){
        try{
            GameApplication.loadScene("finefilter.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void toActiveCoal(ActionEvent event){
        try{
            GameApplication.loadScene("activecoal.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //En command til at sige du kan ikke gå den her vej
    public void wrongDirection (ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HUR HUR HUR HUR");
        alert.setContentText("Click 'OK'");
        if (alert.showAndWait().get() == ButtonType.OK){
            alert.close();
        }
    }

    private boolean clicked = true;


    @FXML
    public void OpenShop() {
        try {
            if (!Shop.shopHasItem()){
                shopWarning.setVisible(true);
            }
            else if (clicked && Shop.shopHasItem()) {
                shop.setVisible(true);
                realodShop();
                clicked =false;
            } else {
                shop.setVisible(false);
                shopWarning.setVisible(false);
                clicked = true;
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void buyFromShop(Event e){
        try {
            String buttonPressed = ((Button)e.getSource()).getId();
            if (Shop.checkHowMany(buttonPressed) == 0){
                shopWarning.setVisible(true);
                shopWarningText. setText("There ar no more "+ buttonPressed.toLowerCase() + "'s left");
            }else {
                shopWarning.setVisible(false);
                Shop.removeItem(buttonPressed);
                realodShop();
            }
        }catch (Exception n){
            System.out.println(n);
        }

    }


    public void realodShop(){
        try {
            if (!Shop.shopHasItem()){
                shopWarning.setVisible(true);
                shopWarningText. setText("The shop owner has no items left");
                shop.setVisible(false);
            }else {
                BucketQuantity.setText("Quantity: "+ Shop.checkHowMany("Bucket"));
                WheelbarrowQuantity.setText("Quantity: "+Shop.checkHowMany("Wheelbarrow"));
                FiretruckQuantity.setText("Quantity: "+Shop.checkHowMany("Firetruck"));
                BucketPrice.setText("Price: "+ Shop.checkPrice("Bucket"));
                WheelbarrowPrice.setText("Price: "+Shop.checkPrice("Wheelbarrow"));
                FiretruckPrice.setText("Price: "+Shop.checkPrice("Firetruck"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

}