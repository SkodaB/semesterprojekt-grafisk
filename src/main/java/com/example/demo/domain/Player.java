package com.example.demo.domain;

public class Player {

    Player(String name, double points){
        this.name = name;
        this.points = points;
    }

    private String name;

    private static double points;

    private double water;

    public static void addPoints(double amount){
        points += amount;
    }

    public static void subtractPoints(double amount){
        points -=amount;
    }

    public void resetPoints(){
        this.points = 0;
    }

    public void addWater(double amount){
        this.water += amount;
    }

    public void subtractWater(double amount){
        this.water -= amount;
    }

    public void resetWater(double amount){
        this.water = 0;
    }

    public static double getPoints(){
        return points;
    }


}
