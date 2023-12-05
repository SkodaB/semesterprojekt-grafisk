/*package com.example.demo.domain;

import java.util.Scanner;

//Bruger drop method fra Inventory klassen.
public class CommandDrop implements Command {

//    CommandDrop() {
//        description = "Used to drop items.";
//    }
    @Override
    public String execute(Context context, String parameters[]) {
        Inventory inventory = context.getInventory();
        int maxDropSize = inventory.getInventoryContents().size();

        // if (parameters.length < 2) {} <--- Idriis Schizo rambling

        if (maxDropSize == 0) { //Logic for drop Command
            return "noItems";
        } else {
            System.out.println("Drop one item, type number to pick item from list displayed: ");
            for (int i = 0; i < maxDropSize; i++) {
                System.out.print(" - ");
                System.out.println(inventory.getInventoryContents().get(i).getItemName());
            }
        }

        try {
            System.out.print("> ");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();

            boolean bigger = choice >= 0;
            boolean smaller = choice <= 3;
            boolean gg = choice <= maxDropSize;

            if (bigger == false || smaller == false || gg == false) {
                System.out.println("Not a valid choice");
            } else if (bigger == true && smaller == true && gg == true) {
                choice--;
                inventory.getInventoryContents().remove(choice);
                System.out.println("Item in inventory has been removed");
            }

        } catch (Exception e) {
            System.out.println("Not a valid input");
            // System.out.println(e);
        }
        return "dropSuccess";

    }

}*/
