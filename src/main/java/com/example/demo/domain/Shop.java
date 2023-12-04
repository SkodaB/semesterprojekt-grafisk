package com.example.demo.domain;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
    
    public ArrayList<Item> shopItems = new ArrayList<Item>();

    public ArrayList<Item> getShopItems(){
        return shopItems;
    }

    public boolean shopHasItem(){return !shopItems.isEmpty();}

    public void addItem(Item item){
        shopItems.add(item);
    }

    public int checkHowMany(String itemLookingFor){
        int Items = 0;
            for (int j = 0; j < shopItems.size(); j++) {
                if (Objects.equals(itemLookingFor, shopItems.get(j).getName())) {
                    Items++;
                }
            }
        return Items;
    }
    public double checkPrice(String itemLookingFor){
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(itemLookingFor, shopItems.get(i).getName())) {
                return shopItems.get(i).getPrice();
            }
        }
        return 0;
    }

    public void removeItem(String itemName){
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(itemName, shopItems.get(i).getName())) {
                shopItems.remove(i);
                break;
            }
        }
    }

    public boolean buyItem(String itemName){
        double balance = Main.getContext().getPlayer().getPoints();
        if(Main.getContext().getShop().checkHowMany(itemName)==0){
            return false;
        }else if(Main.getContext().getShop().checkPrice(itemName)>balance){
            return false;
        }else{
            for (int i = 0; i < Main.getContext().getShop().shopItems.size(); i++) {
                if (Objects.equals(itemName, Main.getContext().getShop().shopItems.get(i).getName())) {
                    Main.getContext().getPlayer().subtractPoints(Main.getContext().getShop().checkPrice(itemName));
                    Main.getContext().getInventory().addItem(Main.getContext().getShop().shopItems.get(i));
                    Main.getContext().getShop().removeItem(itemName);
                    break;
                }
            }
            return true;
        }
    }



}
