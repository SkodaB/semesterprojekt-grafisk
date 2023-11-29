package com.example.demo.domain;
import java.util.ArrayList;

public class Inventory {
    
    Inventory(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    private int maxCapacity;

    private int itemCountInInventory = 0;

    private ArrayList<Item> inventory;

//    public boolean collectWater(){
//
//    }
//
//    public boolean pourWater(){
//
//    }

    public boolean removeItem(Item item){
        if(containsItem(inventory, item)){
            inventory.remove(item);
            return true;
        }else{
            return false;
        }
    }

    public boolean addItem(Item item){
        if(itemCountInInventory <=4){
            inventory.add(item);
            return true;
        }else{
            return false;
        }
    }

    public boolean containsItem(ArrayList<Item> items,Item item){
        for (int i = 0;i < items.size();i++){
            if(items.get(i).getName().equals(item.getName())){
                return true;
            }
        }
        return false;
    }
}
