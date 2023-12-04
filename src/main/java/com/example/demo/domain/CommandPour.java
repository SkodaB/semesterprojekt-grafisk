package com.example.demo.domain;

import java.util.ArrayList;

public class CommandPour implements Command{

    @Override
    public String execute(Context context, String parameters[]){

        Space area = context.getCurrent();
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        double amount = 0;
            for(int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true&&inventory.get(i).getProgress()[1]==true&&inventory.get(i).getProgress()[2]==true&&inventory.get(i).getProgress()[3]==true){
                    amount = inventory.get(i).getCapacity();
                    area.addWater(amount);
                    if(area.getWaterAmount()>=300){
                        context.setDone(true);
                        return "gameCompleted";
                    }
                    inventory.get(i).setProgress(false, false, false, false);
                    context.getPlayer().addPoints(100);
                    return "pourSuccess";
                }else if(inventory.get(i).getProgress()[0]==true){
                    inventory.get(i).setProgress(false, false, false, false);
                    context.getPlayer().subtractPoints(25);
                    context.getCurrent().setWaterAmount(0);
                    return "waterGoneBad";
                }else{
                    return "noWaterInItem";
                }
            }
        return "noItems";
        

    }

}