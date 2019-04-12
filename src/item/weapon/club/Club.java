package item.weapon.club;


import controller.Dice;
import controller.Player;

public class Club extends Mace {

    public Club(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name, hit, initiative, armorClass, useWithShield);
    }

    //rowling dice for damage on Club
    @Override
    public int getWeapDmg() {
        return Dice.getD4();
    }

    @Override
    public void useItem(Player player) {
        player.getHero().setCurrentWeapon(this);
    }
}
