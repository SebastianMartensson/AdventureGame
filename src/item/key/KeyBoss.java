package item.key;

import controller.Player;
import item.Item;

public class KeyBoss extends Key {
    private boolean abilityToUnlock;

    public KeyBoss(String name, boolean abilityToUnlock) {
        super(name);
        this.abilityToUnlock = abilityToUnlock;
    }

    @Override
    public void useItem(Player player){
        //This method might not be needed
    }
}
