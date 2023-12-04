package com.example.demo.domain;

import java.util.ArrayList;

public class CommandPour implements Command{

    @Override
    public String execute(Context context, String parameters[]){

        Space area = context.getCurrent();
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        double amount = 0;
        if(inventory.size()==0){
            return "noItems";
        }
        else{
            for(int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==true&&inventory.get(i).getProgress()[1]==true&&inventory.get(i).getProgress()[2]==true&&inventory.get(i).getProgress()[3]==true){
                    amount = inventory.get(i).getCapacity();
                    area.addWater(amount);
                    if(area.getWaterAmount()>=300){
                        context.setDone(true);
                        return "gameCompleted";
                    }
                    inventory.get(i).setProgress(false, false, false, false);
                    return "pourSuccess";
                    context.getPlayer().setPoints(context.getPlayer().getPoints()+100);
                }else if(inventory.get(i).getIsFull()==true){
                    inventory.get(i).setFiltered(0, false);
                    inventory.get(i).setFiltered(1, false);
                    inventory.get(i).setFiltered(2, false);
                    inventory.get(i).fill(false);
                    System.out.println("You poured dirty water into the water reservoir from item " +
                    inventory.get(i).getItemName() + " causing it all to go bad. 25 points deducted.");
                    context.getPlayer().setPoints(context.getPlayer().getPoints()-25); //Bad behaviour
                    context.getCurrent().setWaterAmount(0);
                }else{
                    System.out.println("No water in item: " + inventory.get(i).getItemName());
                }
            }
        }
        

    }

}