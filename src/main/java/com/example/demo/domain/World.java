package com.example.demo.domain;

import java.util.HashMap;
import java.util.Map;

class World {
  Space entry;
  public Map<Space,String> spaceFxml = new HashMap<>();
  World () {
    Space entry    = new Space("Entry","there isn't much to see here",0);
    this.spaceFxml.put(entry, "entry");
    Space shop     = new Space("Shop", "here you can purchase new tools",0);
    this.spaceFxml.put(shop, "shop");
    Space water_reservoir = new Space("Water Reservoir", "here you can store clean water",0);
    this.spaceFxml.put(water_reservoir, "wr");
    Space entry_cave = new Space("Entry cave", "here you can collect water",1000);
    this.spaceFxml.put(entry_cave, "southcave");
    Space west_cave = new Space("Western cave", "here you can collect water",1000);
    this.spaceFxml.put(west_cave, "westcave");
    Space east_cave = new Space("Eastern cave", "here you can collect water",1000);
    this.spaceFxml.put(east_cave, "eastcave");
    Space north_cave = new Space("Northern cave", "here you can collect water",1000);
    this.spaceFxml.put(north_cave, "northcave");
    Space rough_filter = new Space("Rough filter", "here you can filter water using the rough filter",0);
    this.spaceFxml.put(rough_filter, "roughfilter");
    Space fine_filter = new Space("Fine filtering", "here you can filter water using the fine filter",0);
    this.spaceFxml.put(fine_filter, "finefilter");
    Space active_coal_filter = new Space("Active Coal Filter", "here you can filter water using the active coal filter",0);
    this.spaceFxml.put(active_coal_filter, "activecoal");
    
    //Entry exits
    entry.addEdge("north", entry_cave);
    entry.addEdge("south", rough_filter);
    entry.addEdge("east", water_reservoir);
    entry.addEdge("west", shop);

    //South cave exits
    entry_cave.addEdge("north", north_cave);
    entry_cave.addEdge("south", entry);

    //North cave exits
    north_cave.addEdge("east", east_cave);
    north_cave.addEdge("south", entry_cave);
    north_cave.addEdge("west", west_cave);

    //East cave exits
    east_cave.addEdge("west", north_cave);

    //West cave exits
    west_cave.addEdge("east", north_cave);

    //Shop exits
    shop.addEdge("east", entry);

    //Water reservoir exits
    water_reservoir.addEdge("west", entry);

    //rough filter exits
    rough_filter.addEdge("north", entry);
    rough_filter.addEdge("south", fine_filter);

    //fine filter exits
    fine_filter.addEdge("north", rough_filter);
    fine_filter.addEdge("south",active_coal_filter);

    //active coal filter exits
    active_coal_filter.addEdge("north", fine_filter);
    
    //add info
    Space.addInfo("Achieving SDG 6.3 would contribute to the overall well-being of communities by ensuring access to clean water and reduce water-related diseases");
    Space.addInfo("SDG 6.6 is about protecting/pestoring water-related ecosystems.");
    Space.addInfo("SDG 6.3's goal is To improve water quality by reducing pollution, eliminating dumping and minimizing release of hazardous chemicals and materials");
  

    this.entry = entry;

  }
  
  Space getEntry () {
    return entry;
  }
}

