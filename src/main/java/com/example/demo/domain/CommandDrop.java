package com.example.demo.domain;

import java.util.Scanner;

//Bruger drop method fra Inventory klassen.
public class CommandDrop implements Command {

//    CommandDrop() {
//        description = "Used to drop items.";
//    }
    @Override
    public Message execute(Context context, Message parameters[]) {
        Item itemLookingFor;
        if(parameters[0]==null){
            return Message.NO_ITEMS_SELECTED;
        }else {
            switch(parameters[0]){
                case BUCKET:
                    itemLookingFor = new Bucket();
                    break;
                case WHEELBARROW:
                    itemLookingFor = new Wheelbarrow();
                    break;
                case FIRETRUCK:
                    itemLookingFor = new Firetruck();
                    break;
                case HANDS:
                    return Message.HANDS;
                default:
                    return Message.COMMAND_ERROR;
            }
            for(int i = 0; i<context.getInventory().getInventoryContents().size();i++){
                if(context.getInventory().getInventoryContents().get(i) instanceof Bucket && itemLookingFor instanceof Bucket){
                    context.getInventory().getInventoryContents().remove(context.getInventory().getInventoryContents().get(i));
                    return Message.BUCKET;
                }else if(context.getInventory().getInventoryContents().get(i) instanceof Firetruck && itemLookingFor instanceof Firetruck){
                    context.getInventory().getInventoryContents().remove(context.getInventory().getInventoryContents().get(i));
                    return Message.FIRETRUCK;
                }else if(context.getInventory().getInventoryContents().get(i) instanceof Wheelbarrow && itemLookingFor instanceof Wheelbarrow){
                    context.getInventory().getInventoryContents().remove(context.getInventory().getInventoryContents().get(i));
                    return Message.WHEELBARROW;
                }
            }
            return Message.COMMAND_ERROR;
        }
    }
}