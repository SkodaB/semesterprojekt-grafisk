package com.example.demo.domain;
import java.util.HashMap;
import java.util.Map;

class Registry {
  Context context;
  Map<String, Command> commands = new HashMap<String, Command>();
  
  Registry (Context context) {
    this.context = context;
  }
  
  public void register (String name, Command command) {
    commands.put(name, command);
  }
  

  
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
  }
  
}
