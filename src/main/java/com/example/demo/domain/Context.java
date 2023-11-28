package com.example.demo.domain;
import java.util.Map;
import java.util.HashMap;

class Context {
  Space current;
  boolean done = false;
  Player player;
  Shop shop;
  Inventory inventory;

  Context(Space space, Player playerIn, Shop shopIn, Inventory inventoryIn) {
    current = space;
    player = playerIn;
    shop = shopIn;
    inventory = inventoryIn;
    this.spaceNames.put(space.getName(),space);
  }
  
  public Map<String,Space> spaceNames = new HashMap<>();

  public Inventory getInventory() {
    return inventory;
  }

  public Player getPlayer() {
    return player;
  }

  public Space getCurrent() {
    return current;
  }

  public Shop getShop() {
    return shop;
  }


  public void makeDone() {
    done = true;
  }

  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done){
    this.done = done;
  }

  public void transition(String name){
    if(isNext()){
        
    }
  }
}
