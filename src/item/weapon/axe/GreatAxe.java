package item.weapon.axe;

import controller.Dice;
import controller.Player;

public class GreatAxe extends Axe {

    private Dice dice;

    public GreatAxe(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    //rowling dice for damage on GreatAxe
    @Override
    public int getWeapDmg() {
        return Dice.getD12();
    }

    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}
