package item;

import controller.Player;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void useItem(Player player){
        
    }
}
