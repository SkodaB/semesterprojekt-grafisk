package com.example.demo.domain;
import java.util.Map;
import java.util.HashMap;

public class Main {

    static World world = new World();
    static Inventory inventory = new Inventory(5);
    static Player player = new Player("name",0);
    static Shop shop = new Shop();
    static Context context = new Context(world.getEntry(),player,shop,inventory,world);
    static Registry registry = new Registry(context);

    private static void initRegistry(){
        registry.register("collect", new CommandCollect());
    }

    public static Context getContext(){
        return context;
    }

    public static String game(){
        initRegistry();
        return world.spaceFxml.get(context.getCurrent());
    }
    public static boolean walk(String direction){
        return context.transition(direction);
    }
    public static boolean collect(){
         return true;
    }
    public static boolean commandExecute(String name,String parameters[]){
        if(registry.getCommand(name)==null){
            return false;
        }else{
            return registry.getCommand(name).execute(context, parameters);
        }
    }
}
