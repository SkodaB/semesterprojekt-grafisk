package com.example.demo.domain;

import java.util.ArrayList;
public class CommandCollect implements Command{

    public String execute(Context context,String parameters[]){
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if(context.getCurrent().getWaterAmount()<=0){
            return "noWaterInCave";
        }else if(inventory.size()==0){
            return "noItems";
        }else{
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==false){
                    inventory.get(i).setProgress(true, false, false, false);
                }
            }
            return "successCollect";
        }
    }

}
