package com.example.demo.domain;

import java.util.Set;
import java.util.ArrayList;
import java.util.Random;

public class Space extends Node {

  static Random random = new Random();

  private static ArrayList<String> info = new ArrayList<>();

  Space (String name, String description,int waterAmount) {
    super(name, description,waterAmount);
  }

  public static void addInfo(String information){
    info.add(information);
  }

  public static String giveInfo(){
    if(random.nextDouble()>0.75 && info.size()!=0){
      String i = info.get(0);
      info.remove(0);
      return i;
    }else{
      return null;
    }
  }

  public double removeWater(double amount){
    water -= amount;
    return water;
  }
  public void addWater(double amount){
    water += amount;
  }

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
