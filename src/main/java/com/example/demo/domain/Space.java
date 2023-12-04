package com.example.demo.domain;

import java.util.Set;

class Space extends Node {


  Space (String name, String description,int waterAmount) {
    super(name, description,waterAmount);
  }

  public double removeWater(double amount){
    water -= amount;
    return water;
  }
  public void addWater(double amount)[
    water += amount;
  ]

  public int getWaterAmount() {
    return water;
  }
  
  public void setWaterAmount(int amount){
    water = amount;
  }

  public boolean drainWater(int amount){
    if(water>=amount){
      water=water-amount;
      System.out.println("Water collected successfully - " + water + " liters left.");
      return true;
    }else{
      return false;
    }

  }
  public void welcome () {
    System.out.println("You are now at " + name + " " + description);
    if(water>0){
      System.out.println("Liters of water : " + water);
    }

    //display information about verdensmål

    
    if (name.contains("Northern")) {
      System.out.println("2.2 billion people lack access to clean water.");
    }
    Set<String> exits = edges.keySet();
    System.out.println("Current exits are:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    
      }
    if (name.contains("Eastern")) {
      System.out.println("3.5 billion people lack safely managed sanitation.");
    }
    if (name.contains("Western")) {
      System.out.println("By 2030 the united nations seek to achieve universal acces to safe and affordable drinking water.");
    }

  }
  
  public void goodbye () {
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
