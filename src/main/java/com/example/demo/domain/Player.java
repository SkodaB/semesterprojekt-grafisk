package com.example.demo.domain;

public class Player {

    Player(String name, double points){
        this.name = name;
        this.points = points;
    }

    private String name;

    private double points;

    public void addPoints(double amount){
        this.points += amount;
    }

    public void subtractPoints(double amount){
        this.points -=amount;
    }

    public void resetPoints(){
        this.points = 0;
    }
}
