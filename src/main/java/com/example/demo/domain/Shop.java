package com.example.demo.domain;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
    
    public static ArrayList<Item> shopItems = new ArrayList<Item>();

    public ArrayList<Item> getShopItems(){
        return shopItems;
    }

    public static boolean shopHasItem(){return !shopItems.isEmpty();}

    public static void addItem(Item item){
        shopItems.add(item);
    }

    public static int checkHowMany(String itemLookingFor){
        int Items = 0;
            for (int j = 0; j < shopItems.size(); j++) {
                if (Objects.equals(itemLookingFor, shopItems.get(j).getName())) {
                    Items++;
                }
            }
        return Items;
    }
    public static double checkPrice(String itemLookingFor){
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(itemLookingFor, shopItems.get(i).getName())) {
                return shopItems.get(i).getPrice();
            }
        }
        return 0;
    }

    public static void removeItem(String item){
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(item, shopItems.get(i).getName())) {
                shopItems.remove(i);
                break;
            }
        }
    }

    public static boolean buyItem(String itemName,Item item, Player player){
        double balance = player.getPoints();
        if(Shop.checkHowMany(itemName)==0){
            return false;
        }else if(checkPrice(itemName)>balance){
            return false;
        }else{
            Main.getContext().getInventory().addItem(item);
            player.subtractPoints(checkPrice(itemName));
            return true;
        }
    }



}
