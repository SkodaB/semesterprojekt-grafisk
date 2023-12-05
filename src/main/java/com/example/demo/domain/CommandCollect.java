package com.example.demo.domain;

import java.util.ArrayList;
public class CommandCollect implements Command{

    public Message execute(Context context,Message parameters[]){
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if(context.getCurrent().getWaterAmount()<=0){
            return Message.NO_WATER;
        }else if(inventory.size()==0){
            return Message.NO_ITEMS;
        }else{
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]==false && (context.getCurrent().getWaterAmount()-inventory.get(i).getCapacity())>=0){
                    inventory.get(i).setProgress(true, false, false, false);
                    context.getCurrent().removeWater(inventory.get(i).getCapacity());
                }
            }
            return null;
        }
    }

}
