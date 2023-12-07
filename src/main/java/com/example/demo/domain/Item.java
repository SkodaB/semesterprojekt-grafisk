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
        return name + " - Full: " + progress[0] +" RoughF: "+ progress[1] + " FineF: "+progress[2] + " CoalF: "+ progress[3];
    }

    public double getCapacity(){
        return capacity;
    }
}


