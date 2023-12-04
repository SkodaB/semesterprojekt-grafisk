package com.example.demo.domain;

import java.util.ArrayList;

public class CommandClean implements Command{
    @Override
    public boolean execute(Context context, String Parameters[]) {
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if (context.getCurrent().name == "Rough filter") {
                if (inventory.size() == 0) {
                    System.out.println("You have no items, purchase items and fill them with water before cleaning.");
                }
                for (int i = 0; i < inventory.size(); i++) {
                    if(inventory.get(i).getProgress()[0]==false){
                        System.out.println("You have no water in item " + inventory.get(i).getItemName());
                        return false;
                    }
                    if (inventory.get(i).getProgress()[1] == false) {
                        inventory.get(i).setProgress(true, true, false, false);
                        System.out.println("Water filtered successfully for item " + inventory.get(i).getItemName());
                        context.getPlayer().addPoints(10);
                        System.out.println("10 points awarded!");
                    } else {
                        System.out.println("Water has already been through the rough filter for item " + inventory.get(i).getItemName());
                    }
                }
        }
        else if (context.getCurrent().name == "Fine filtering") {
            if(inventory.size()==0){
                System.out.println("You have no items, purchase items and fill them with water before cleaning.");
            }
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true && inventory.get(i).getProgress()[1]==true){
                    if(inventory.get(i).getProgress()[2]==true){
                        System.out.println("Item has already been through the fine filter for item " + inventory.get(i).getItemName());
                    }else{
                        inventory.get(i).setProgress(true, true, true, false);(1, true);
                        System.out.println("Water filtered successfully for item " + inventory.get(i).getItemName());
                        context.getPlayer().addPoints(10);
                        System.out.println("10 points awarded!");
                    }
                }else{
                    System.out.println("Water not filtered properly, or there is no water at all in item " + inventory.get(i).getItemName());
                }
            }
        } else if (context.getCurrent().name == "Active Coal Filter") {
            if(inventory.size()==0){
                System.out.println("You have no items, purchase items and fill them with water before cleaning.");
            }
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getFiltered()[1]==true && inventory.get(i).getFiltered()[0]==true && inventory.get(i).getIsFull()==true){
                    if(inventory.get(i).getFiltered()[2]==true){
                        System.out.println("Item has already been through the active coal filter for item " + inventory.get(i).getItemName());
                    }else{
                        inventory.get(i).setFiltered(2,true);
                        System.out.println("Water filtered successfully for item " + inventory.get(i).getItemName());
                        context.getPlayer().setPoints(context.getPlayer().getPoints() + 10);
                        System.out.println("10 points awarded!");
                    }
                }else{
                    System.out.println("Water not filtered properly, or there is no water at all in item " + inventory.get(i).getItemName());
                }
            }
        } else {
            System.out.println("You can't clean your water here. Try in the filtering rooms");

        }
    }
}

