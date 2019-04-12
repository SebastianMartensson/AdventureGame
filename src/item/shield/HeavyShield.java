package item.shield;

import controller.Player;

public class HeavyShield extends Shield {

    public HeavyShield(String name, int hit, int initiative, int armorClass) {
        super(name, hit, initiative, armorClass);

    }


    @Override
    public int getShieldAC() {
        return getArmorClass();
    }

    @Override
    public void useItem(Player player){
        player.getHero().setCurrentShield(this);
    }
}
