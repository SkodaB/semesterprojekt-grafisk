package com.example.demo.domain;

public class Player {

    Player(String name, double points){
        this.name = name;
        this.points = points;
    }

    private String name;

    private double points;

    private double water;

    public void addPoints(double amount){
        this.points += amount;
    }

    public void subtractPoints(double amount){
        this.points -=amount;
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
}