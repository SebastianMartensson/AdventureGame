package item.weapon.club;

import controller.Player;
import item.weapon.Weapon;

public class Mace extends Weapon {

    public Mace(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
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
