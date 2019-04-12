package item.weapon;

import controller.Player;
import item.Item;

public abstract class Weapon extends Item {

   private int hit;
   private int initiative;
   private int armorClass;
   private boolean useWithShield;

    public Weapon(String name, int hit, int initiative, int armorClass, boolean useWithShield) {
        super(name);
        this.hit = hit;
        this.initiative = initiative;
        this.armorClass = armorClass;
        this.useWithShield = useWithShield;
    }

    public abstract int getWeapDmg();

    public void setUseWithShield(boolean useWithShield) {
        this.useWithShield = useWithShield;
    }

    public boolean getUseWithShield() {
        return useWithShield;
    }

    public int getHit() {
        return hit;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public boolean isUseWithShield() {
        return useWithShield;
    }

    @Override
    public void useItem(Player player){
        
    }
}
