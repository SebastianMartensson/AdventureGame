package item.key;

import controller.Player;
import item.Item;

public class KeyRoom extends Key {
    private boolean abilityToUnlock; //TODO associate with package.room.Door with "boolean isLocked"

    public KeyRoom(String name, boolean abilityToUnlock) {
        super(name);
        this.abilityToUnlock = abilityToUnlock;
    }

    @Override
    public void useItem(Player player){
        //This method might not be needed
    }
}
