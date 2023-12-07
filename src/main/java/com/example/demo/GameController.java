package com.example.demo;

import com.example.demo.domain.*;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.HashMap;

public class GameController implements Initializable{

    static Map<Message,String> responseMsg = new HashMap<>();



    @FXML
    private ListView<Item> inventory;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        ArrayList<Item> items = context.getInventory().getInventoryContents();
        for (int i = 0;i<items.size();i++){
            inventory.getItems().add(items.get(i));
        }

        responseMsg.put(Message.NO_ITEMS,"You have no items in your inventory. Consider going to the shop.");
        responseMsg.put(Message.NO_WATER,"There's no water in this cave.");
        responseMsg.put(Message.WRONG_LOCATION,"Wrong location.");
        responseMsg.put(Message.GAME_COMPLETED,"gameCompleted");
        responseMsg.put(Message.GONE_BAD,"You poured dirty water into the resivour!");
        responseMsg.put(Message.DROP_SUCCESS,"Successfully dropped item");
        responseMsg.put(Message.BUCKET,"You dropped your a bucket.");
        responseMsg.put(Message.FIRETRUCK,"You dropped your a firetruck.");
        responseMsg.put(Message.WHEELBARROW,"You dropped your a wheelbarrow.");
        responseMsg.put(Message.HANDS,"Hands aren't droppable.");
        responseMsg.put(Message.NO_ITEMS_SELECTED,"No items selected.");
        responseMsg.put(Message.COMMAND_ERROR, "Something went wrong.");

        reloadPoints();
        reloadWaterCount();
        reloadInventoryGraphics();
        displayInfo(null);

    }

    Context context = Main.getContext();

    @FXML
    private ImageView waterView0;

    @FXML
    private ImageView waterView1;

    @FXML
    private ImageView waterView2;

    @FXML
    private ImageView waterView3;

    @FXML
    private Label waterCount;

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
    private Label Points;
    @FXML
    private Button openShop;
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

    public void interpreter(Message response){
        alerter(responseMsg.get(response));
    }

    public void alerter(String msg){
        if (msg == null){
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HUR HUR HUR HUR");
        alert.setContentText(msg);
        if (alert.showAndWait().get() == ButtonType.OK){
            alert.close();
        }
    }

    public void reloadInventoryGraphics(){
        ArrayList<Item> items = Main.getContext().getInventory().getInventoryContents();
        if(items.size()==0){
            return;
        }
        for (int i = 0;i<items.size();i++){
            ImageView iv = waterView0;
            String newImageURL = "";
            Image newImage;
            switch(i){
                case 0:
                    iv = waterView0;
                    break;
                case 1:
                    iv = waterView1;
                    break;
                case 2:
                    iv = waterView2;
                    break;
                case 3:
                    iv = waterView3;
                    break;
                default:
                    System.out.println("dev: inventory exceeds 4 items, change if needed");
                    break;
            }
            if(items.get(i).getName()=="Hands"){
                if(items.get(i).getProgress()[0]==true){
                    newImageURL = "FullHands.png";
                }else{
                    newImageURL = "EmptyHands.png";
                }
            }else if(items.get(i).getName()=="Bucket"){
                if(items.get(i).getProgress()[0]==true){
                    newImageURL = "Bucket.png";
                }else{
                    newImageURL = "EmptyBucket.png";
                }
            }else if(items.get(i).getName()=="Wheelbarrow"){
                if(items.get(i).getProgress()[0]==true){
                    newImageURL = "FullWheelBarrow.png";
                }else{
                    newImageURL = "Wheelbarrow .png";
                }
            }else if(items.get(i).getName()=="Firetruck"){
                if(items.get(i).getProgress()[0]==true){
                    newImageURL = "FullFiretruck.png";
                }else{
                    newImageURL = "Firetruck.png";
                }
            }
            try {
                newImage = new Image(getClass().getResource(newImageURL).toExternalForm());
                iv.setImage(newImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void updateInventory(ActionEvent event){
        try{
            reloadInventoryGraphics();
            reloadPoints();
            reloadWaterCount();
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
    public void displayInfo(ActionEvent event){
        try {
            alerter(Space.giveInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void collect(ActionEvent event){
        try{
            Message response = Main.commandExecute("collect", null);
            interpreter(response);
            updateInventory(event);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void filter(ActionEvent event){
        try {
            Message response = Main.commandExecute("clean", null);
            interpreter(response);
            updateInventory(event);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void pour(ActionEvent event){
        try {
            Message response = Main.commandExecute("pour", null);
            if(response == Message.GAME_COMPLETED){
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
    public void drop(ActionEvent event){
        try {
            Message response;
            Item itemSelected = inventory.getSelectionModel().getSelectedItem();
            if(itemSelected instanceof Firetruck){
                response = Main.commandExecute("drop", (new Message[]{Message.FIRETRUCK}));
            }else if(itemSelected instanceof Wheelbarrow){
                response = Main.commandExecute("drop", (new Message[]{Message.WHEELBARROW}));
            }else if(itemSelected instanceof Bucket){
                response = Main.commandExecute("drop", (new Message[]{Message.BUCKET}));
            }else if(itemSelected instanceof Hands){
                response = Main.commandExecute("drop", (new Message[]{Message.HANDS}));
            }else if(itemSelected == null){
                response = Message.NO_ITEMS_SELECTED;
            }else{
                response = Message.COMMAND_ERROR;
            }
            interpreter(response);
            updateInventory(event);
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
        alert.setTitle("Wrong direction :(");
        alert.setContentText("Click 'OK'");
        if (alert.showAndWait().get() == ButtonType.OK){
            alert.close();
        }
    }

    private boolean clickedShop = true;


    @FXML
    public void OpenShop() {
        try {
            if (!Main.getContext().getShop().shopHasItem()){
                shopWarning.setVisible(true);
            }
            else if (clickedShop && Main.getContext().getShop().shopHasItem()) {
                openShop.setText("Close Shop");
                shop.setVisible(true);
                realodShop();
                clickedShop =false;
            } else {
                openShop.setText("Open Shop");
                shop.setVisible(false);
                shopWarning.setVisible(false);
                clickedShop = true;
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void buyFromShop(Event e ){
        try {
            ActionEvent event = null;

            String buttonPressed = ((Button)e.getSource()).getId();
            Items buttonPressedenum = Items.valueOf(buttonPressed);
            if (Main.getContext().getShop().checkHowMany(buttonPressedenum) == 0){
                shopWarning.setVisible(true);
                shopWarningText. setText("There ar no more "+ buttonPressed.toLowerCase() + "'s left");
            }else {
                shopWarning.setVisible(false);
                if (Main.getContext().getShop().buyItem(buttonPressedenum)){
                    realodShop();
                    reloadPoints();
                    updateInventory(event);
                }else {
                    shopWarning.setVisible(true);
                    shopWarningText. setText("You don't have enough points or you have reached maximum inventory capacity of " + Main.getContext().getInventory().getMaxCapacity());
                }
            }
        }catch (Exception n){
            System.out.println(n);
        }

    }

    public void reloadPoints(){
        try {
            Points.setText("Points: "+Main.getContext().getPlayer().getPoints());
            if(this.endScore!=null){
                endScore.setText(""+Main.getContext().getPlayer().getPoints());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void realodShop(){
        try {
            if (!Main.getContext().getShop().shopHasItem()){
                shopWarning.setVisible(true);
                shopWarningText. setText("The shop owner has no items left");
                shop.setVisible(false);
            }else {
                BucketQuantity.setText("Quantity: "+ Main.getContext().getShop().checkHowMany(Items.Bucket));
                WheelbarrowQuantity.setText("Quantity: "+Main.getContext().getShop().checkHowMany(Items.Wheelbarrow));
                FiretruckQuantity.setText("Quantity: "+Main.getContext().getShop().checkHowMany(Items.Firetruck));
                BucketPrice.setText("Price: "+ Main.getContext().getShop().checkPrice(Items.Bucket));
                WheelbarrowPrice.setText("Price: "+Main.getContext().getShop().checkPrice(Items.Wheelbarrow));
                FiretruckPrice.setText("Price: "+Main.getContext().getShop().checkPrice(Items.Firetruck));
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    
    public void reloadWaterCount(){
        waterCount.setText(""+Main.getContext().getCurrent().getWaterAmount());
    }

    public void wrongChoice (ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Nope that is not correct :(");
        alert.setContentText("Try again by clicking 'OK'");
        if (alert.showAndWait().get() == ButtonType.OK){
            alert.close();
        }
    }
    public void rightChoice1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Yay that is correct! :)");
        alert.setContentText("Head to the next question by clicking 'Ok'");


        if (alert.showAndWait().get() == ButtonType.OK) {
            alert.close();

            try {
                GameApplication.loadScene("theend2.fxml");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void rightChoice2(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Yay that is correct! :)");
        alert.setContentText("Head to the next question by clicking 'Ok'");


        if (alert.showAndWait().get() == ButtonType.OK) {
            alert.close();

            try {
                GameApplication.loadScene("theend3.fxml");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void rightChoice3(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Yay that is correct! :)");
        alert.setContentText("Head to the next question by clicking 'Ok'");


        if (alert.showAndWait().get() == ButtonType.OK) {
            alert.close();

            try {
                GameApplication.loadScene("theend4.fxml");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void rightChoice4(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Yay that is correct! :)");
        alert.setContentText("Head to the next question by clicking 'Ok'");


        if (alert.showAndWait().get() == ButtonType.OK) {
            alert.close();
            Platform.exit();
        }
    }

    public void endGame(){
        try{
            GameApplication.loadScene("theend1.fxml");
        }catch(Exception e){
            System.out.println(e);
        }
    }





    @FXML
    private Pane tutorial;
    @FXML
    private Label tutorialtextGUI;
    private int i = 0;
    private String[] helpText = {"Hi and welcome to the World of water, my name is Bob.", "You "};

    public void help(){
        i = 0;
        tutorialtextGUI.setText(helpText[i]);
        i++;
        tutorial.setVisible(true);
    }
    public void next(){
        if (i != helpText.length){
            tutorialtextGUI.setText(helpText[i]);
            i++;
        }else {
            tutorial.setVisible(false);
        }

    }
}