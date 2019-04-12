package inventory;

import controller.Menu;
import controller.Player;
import controller.input_handling.Log;
import item.Item;
import item.potion.Potion;
import item.treasure.Treasure;

import java.io.Serializable;

public class Inventory implements Serializable {
    private final Item[] inventory;

    public Inventory() {
        this.inventory = new Item[10];
    }

    //Use an inventory item. This is true for treasure chests as well.
    private void useInventoryItem(Player player, int index) {
        //Adjust index input
        index = index - 1;
        //Use the object to call its corresponding method
        inventory[index].useItem(player);
    }

    //Get item according to player input index and return it
    public Item getItem(int index, Player player) {
        Item item = null;
        try {
            if (index > 0 && index < 11) {
                item = inventory[index - 1];
                useInventoryItem(player, index);
                // If use potion remove it.
                if (item instanceof Potion) {
                    removeItem(index);
                }
            } else {
                System.out.println("* You need to enter a number between 1 and 10.");
            }
        } catch (IndexOutOfBoundsException ex) {
            Log.addError(String.valueOf(ex));
        }
        return item;
    }

    //Add an item on the next index equal to null else print inventory is full
    public void addItems(Item item, Player player) {
        if (item instanceof Treasure) {
            item.useItem(player);
        } else {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    try {
                        inventory[i] = item;
                    } catch (IndexOutOfBoundsException ex) {
                        Log.addError(String.valueOf(ex));
                    }
                    break;
                } else if (inventory[i] != null && i == (inventory.length - 1)) {
                    Menu.inventoryFull();
                }
            }
        }
    }

    //Set an item to null according to player input index
    public void removeItem(int index) {
        try {
            if (index > 0 && index < 11) {
                inventory[index - 1] = null;
            } else {
                System.out.println("* You need to enter a number between 1 and 10.");
            }
        } catch (IndexOutOfBoundsException ex) {
            Log.addError(String.valueOf(ex));
        }


    }

    public Item[] getInventoryList() {
        return inventory;
    }
}


