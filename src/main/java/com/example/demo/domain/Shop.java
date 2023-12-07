package com.example.demo.domain;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
    
    public ArrayList<Item> shopItems = new ArrayList<Item>();

    public ArrayList<Item> getShopItems(){
        return shopItems;
    }

    public boolean shopHasItem(){return !shopItems.isEmpty();}

    public void addItem(Item item){
        shopItems.add(item);
    }

    public int checkHowMany(Items itemName){
        String itemLookingFor = itemName.name();
        int Items = 0;
            for (int j = 0; j < shopItems.size(); j++) {
                if (Objects.equals(itemLookingFor, shopItems.get(j).getName())) {
                    Items++;
                }
            }
        return Items;
    }
    public double checkPrice(Items itemname){
        String itemLookingFor = itemname.name();
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(itemLookingFor, shopItems.get(i).getName())) {
                return shopItems.get(i).getPrice();
            }
        }
        return 0;
    }

    public void removeItem(Items itemWantingToRemove){
        String itemName = itemWantingToRemove.name();
        for (int i = 0; i < shopItems.size(); i++) {
            if (Objects.equals(itemName, shopItems.get(i).getName())) {
                shopItems.remove(i);
                break;
            }
        }
    }

    public boolean buyItem(Items itemWantingTobuy){
        String itemName = itemWantingTobuy.name();
        double balance = Main.getContext().getPlayer().getPoints();
        if(Main.getContext().getShop().checkHowMany(itemWantingTobuy)==0){
            return false;
        }else if(Main.getContext().getShop().checkPrice(itemWantingTobuy)>balance){
            return false;
        }else{
            for (int i = 0; i < Main.getContext().getShop().shopItems.size(); i++) {
                if (Objects.equals(itemName, Main.getContext().getShop().shopItems.get(i).getName())) {
                    if(Main.getContext().getInventory().getInventoryContents().size()==Main.getContext().getInventory().getMaxCapacity()){
                        return false;
                    }
                    Main.getContext().getPlayer().subtractPoints(Main.getContext().getShop().checkPrice(itemWantingTobuy));
                    Main.getContext().getInventory().addItem(Main.getContext().getShop().shopItems.get(i));
                    Main.getContext().getShop().removeItem(itemWantingTobuy);
                    break;
                }
            }
            return true;
        }
    }



}
