package com.example.demo.domain;

import java.util.ArrayList;

public class CommandClean implements Command{
    @Override
    public String execute(Context context, String Parameters[]) {
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if (context.getCurrent().name == "Rough filter") {
                for (int i = 0; i < inventory.size(); i++) {
                    if(inventory.get(i).getProgress()[0]==false){
                        return "noWaterInItem";
                    }
                    if (inventory.get(i).getProgress()[1] == false) {
                        inventory.get(i).setProgress(true, true, false, false);
                        context.getPlayer().addPoints(10);
                        return "roughFilterSuccess";
                    } else {
                        return "alreadyFiltered";
                    }
                }
                return "noItems";
        }
        else if (context.getCurrent().name == "Fine filtering") {
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true && inventory.get(i).getProgress()[1]==true){
                    if(inventory.get(i).getProgress()[2]==true){
                        return "alreadyFiltered";
                    }else{
                        inventory.get(i).setProgress(true, true, true, false);
                        context.getPlayer().addPoints(10);
                        return "fineFilterSuccess";
                    }
                }else{
                    return "notFilteredOrNoWater";
                }

            }
            return "noItems";
        } else if (context.getCurrent().name == "Active Coal Filter") {
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true && inventory.get(i).getProgress()[1]==true && inventory.get(i).getProgress()[2]==true){
                    if(inventory.get(i).getProgress()[2]==true){
                        return "alreadyFiltered";
                    }else{
                        inventory.get(i).setProgress(true, true, true, true);
                        context.getPlayer().addPoints(10);
                        return "coalFilterSuccess";
                    }
                }else{
                    return "notFilteredOrNoWater";
                }
            }
            return "noItems";
        } else {
            return "wrongLocation";

        }
    }
}

