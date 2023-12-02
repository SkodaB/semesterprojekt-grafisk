package com.example.demo.domain;

import java.util.ArrayList;
public class CommandCollect implements Command{

    public boolean execute(Context context,String parameters[]){
        System.out.println("test");
        ArrayList<Item> inventory = context.getInventory().getInventoryContents();
        if(context.getCurrent().getWaterAmount()<=0){
            return false;
        }else if(context.getCurrent().getName()!="Entry cave" ||
                 context.getCurrent().getName()!="Western cave" ||
                 context.getCurrent().getName()!="Eastern cave" ||
                 context.getCurrent().getName()!="Northern cave" ){
                    return false;
                 }
        else if(inventory.size()==0){
            return false;
        }else{
            for (int i = 0;i<inventory.size();i++){
                if(inventory.get(i).getProgress()[0]){
                    inventory.get(i).setProgress(true, false, false, false);
                }
            }
            return true;
        }
    }

}
