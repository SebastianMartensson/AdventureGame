package item.shield;

import controller.Player;
import item.Item;

public abstract class Shield extends Item {

    private int hit;
    private int initiative;
    private int armorClass;

    public Shield(String name, int hit, int initiative, int armorClass){
        super(name);
        this.hit = hit;
        this.initiative = initiative;
        this.armorClass = armorClass;
    }

    public abstract int getShieldAC();

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    @Override
    public void useItem(Player player){
        
    }

}