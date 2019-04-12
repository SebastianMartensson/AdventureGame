package item.weapon.sword;

import controller.Dice;
import controller.Player;

public class ShortSword extends Sword {

    private Dice dice;

    public ShortSword(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    //rowling dice for damage on ShortSword
    @Override
    public int getWeapDmg() {
        return Dice.getD6();
    }

    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}
