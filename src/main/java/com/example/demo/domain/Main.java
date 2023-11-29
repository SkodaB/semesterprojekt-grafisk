package com.example.demo.domain;

public class Main {

    static World world = new World();
    static Inventory inventory = new Inventory(5);
    static Player player = new Player("name",0);
    static Shop shop = new Shop();
    static Context context = new Context(world.getEntry(),player,shop,inventory);


    public static void main(String args[]){
        startGame();
    }

    private static void startGame(){
        while(!context.isDone()){
            
        }
    }
}
