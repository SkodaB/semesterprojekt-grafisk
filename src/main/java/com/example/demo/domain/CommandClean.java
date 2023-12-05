package com.example.demo.domain;

import java.util.ArrayList;

public class CommandClean implements Command{
    @Override
    public String execute(Context context, String Parameters[]) {
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if(inventory.size()==0){
            return "noItems";
        }
        if (context.getCurrent().name == "Rough filter") {
                for (int i = 0; i < inventory.size(); i++) {
                    if (inventory.get(i).getProgress()[0] == true && inventory.get(i).getProgress()[1]==false) {
                        inventory.get(i).setProgress(true, true, false, false);
                        context.getPlayer().addPoints((inventory.get(i).getCapacity()*0.05));
                    }
                }
                return "filterSuccess";
        }
        else if (context.getCurrent().name == "Fine filtering") {
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true && inventory.get(i).getProgress()[1]==true && inventory.get(i).getProgress()[2]==false){
                    inventory.get(i).setProgress(true, true, true, false);
                    context.getPlayer().addPoints((inventory.get(i).getCapacity()*0.05));
                }
            }
            return "filterSuccess";
        } else if (context.getCurrent().name == "Active Coal Filter") {
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true && inventory.get(i).getProgress()[1]==true && inventory.get(i).getProgress()[2]==true && inventory.get(i).getProgress()[3]==false){
                    
                    inventory.get(i).setProgress(true, true, true, true);
                    context.getPlayer().addPoints((inventory.get(i).getCapacity()*0.05));
                }
            }
            return "filterSuccess";
        } else {
            return "wrongLocation";

        }
    }

}

