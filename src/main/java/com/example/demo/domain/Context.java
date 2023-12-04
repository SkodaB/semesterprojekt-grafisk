package com.example.demo.domain;

public class Context {
  Space current;
  boolean done = false;
  Player player;
  Shop shop;
  Inventory inventory;
  World world;

  Context(Space node, Player playerIn, Shop shopIn, Inventory inventoryIn, World worldIn) {
    current = node;
    player = playerIn;
    shop = shopIn;
    inventory = inventoryIn;
    world = worldIn;
    //initialize items in inventory
    inventory.addItem(new Hands());
    //initialize items in shop
    shop.addItem(new Wheelbarrow());
    shop.addItem(new Wheelbarrow());
    shop.addItem(new Bucket());
    shop.addItem(new Bucket());
    shop.addItem(new Bucket());
    shop.addItem(new Bucket());
    shop.addItem(new Firetruck());
    shop.addItem(new Firetruck());
    shop.addItem(new Firetruck());
    shop.addItem(new Firetruck());
  }

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

  public boolean transition(String direction) {
    Space next = current.followEdge(direction);
    if (next == null) {
      return false;
    } else {
      //current.goodbye();
      current = next;
      return true;
      //current.welcome();
    }
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
}
