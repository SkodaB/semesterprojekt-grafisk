package com.example.demo.domain;
import java.util.ArrayList;
public class Shop {
    
    private ArrayList<Item> shopItems = new ArrayList<Item>();

    public ArrayList<Item> getShopItems(){
        return shopItems;
    }

    public void addItem(Item item){
        shopItems.add(item);
    }

    public void removeItem(Item item){
        shopItems.remove(item);
    }



}
