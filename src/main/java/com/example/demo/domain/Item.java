package com.example.demo.domain;

public abstract class Item {
    
    Item(String name, double price, double capacity){
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.setProgress(false, false, false, false);
    }

    private String name;

    private double price;

    private double capacity;

    //determines whether item is filled with water aswell as filtered, so an item which is progress = [true,false,false,fase] would be full of water but not filtered, and progress = [true,true,true,false] would be full of water and filtered twice.
    private boolean[] progress;

    public void setProgress(boolean isFull,boolean roughFiltered, boolean fineFiltered, boolean coalFiltered){
        this.progress = new boolean[]{isFull,roughFiltered,fineFiltered,coalFiltered};
    }

    public boolean[] getProgress(){
        return this.progress;
    }

    public String getName(){
        return name;
    }
    public Double getPrice(){return price;}

    @Override
    public String toString(){
        String cf = "";
        String rf = "";
        String ff = "";
        if(progress[1]){
            rf = ": Is rough filtered. ";
        }
        if(progress[2]){
            ff = " Is fine filtered. ";
        }
        if(progress[3]){
            cf = " Is coal filtered. ";
        }
        return name + rf + ff + cf;
    }

    public double getCapacity(){
        return capacity;
    }
}


