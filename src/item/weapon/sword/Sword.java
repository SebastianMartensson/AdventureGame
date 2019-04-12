package item.weapon.sword;

import controller.Player;
import item.weapon.Weapon;

public class Sword extends Weapon {

    public Sword(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    @Override
    public int getWeapDmg() {
        return 0;
    }

    @Override
    public void useItem(Player player) {
        
    }


}
