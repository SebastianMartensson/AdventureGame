package item.weapon.axe;

import controller.Dice;
import controller.Player;

public class BattleAxe extends Axe {

    private Dice dice;

    public BattleAxe(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    //rowling dice for damage on BattleAxe
    @Override
    public int getWeapDmg() {
        return Dice.getD8();
    }

    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}
