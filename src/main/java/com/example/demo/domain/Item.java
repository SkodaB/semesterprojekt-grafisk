package com.example.demo.domain;

public abstract class Item {
    
    Item(String name, double price, double capacity){
        this.name = name;
        this.price = price;
        this.capacity = capacity;
    }

    private String name;

    private double price;

    private double capacity;

}
