package com.example.demo.domain;

public class Main {

    static World world = new World();
    static Inventory inventory = new Inventory(4);
    static Player player = new Player("name",0);
    static Shop shop = new Shop();
    static Context context = new Context(world.getEntry(),player,shop,inventory,world);
    static Registry registry = new Registry(context);

    private static void initRegistry(){
        registry.register("collect", new CommandCollect());
        registry.register("clean", new CommandClean());
        registry.register("pour", new CommandPour());
        registry.register("drop", new CommandDrop());
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
    public static Message commandExecute(String name,Message parameters[]){
        if(registry.getCommand(name)==null){
            return Message.COMMAND_ERROR;
        }else{
            return registry.getCommand(name).execute(context, parameters);
        }
    }
}
