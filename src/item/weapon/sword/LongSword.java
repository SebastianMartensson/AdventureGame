package item.weapon.sword;

import controller.Dice;
import controller.Player;

public class LongSword extends Sword {

    private Dice dice;

    public LongSword(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    //rowling dice for damage on LongSword
    @Override
    public int getWeapDmg() {
        return Dice.getD8();
    }

    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}

