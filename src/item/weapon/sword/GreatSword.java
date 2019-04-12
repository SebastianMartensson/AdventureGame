package item.weapon.sword;

import controller.Dice;
import controller.Player;

public class GreatSword extends Sword {

    private Dice dice;

    public GreatSword(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);

    }

    //rowling dice for damage on GreatSword
    @Override
    public int getWeapDmg() {
        return Dice.getTwoD6();
    }
    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}
