package com.example.demo.domain;

import java.util.ArrayList;

public class CommandPour implements Command{

    @Override
    public String execute(Context context, String parameters[]){

        boolean waterGoneBad = false;
        boolean gameCompleted = false;
        Space area = context.getCurrent();
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        double amount = 0;
            if(inventory.size()==0){
                return "noItems";
            }
            for(int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true&&inventory.get(i).getProgress()[1]==true&&inventory.get(i).getProgress()[2]==true&&inventory.get(i).getProgress()[3]==true){
                    amount = inventory.get(i).getCapacity();
                    area.addWater(amount);
                    if(area.getWaterAmount()>=1000){
                        context.setDone(true);
                        gameCompleted = true;
                    }
                    inventory.get(i).setProgress(false, false, false, false);
                    context.getPlayer().addPoints(100);
                }else if(inventory.get(i).getProgress()[0]==true){
                    inventory.get(i).setProgress(false, false, false, false);
                    context.getPlayer().subtractPoints(25);
                    context.getCurrent().setWaterAmount(0);
                    waterGoneBad = true;
                }
            }
            if (waterGoneBad == true){
                return "waterGoneBad";
            }else if(gameCompleted == true){
                return "gameCompleted";
            }
            return "pourSuccess";
    }

}