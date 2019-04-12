package creature;

import item.shield.Shield;
import item.weapon.Weapon;

public class Rogue extends Hero {

    //Creature.Rouge Hero class

    public Rogue(String name, int healthPoint, int armorClass, int baseArmorClass, int attackDmg, int baseAttackDmg, int hitChance, int initiative, int level, int heroXP, int posY, int posX, Weapon currentWeapon, Shield currentShield) {
        super(name, healthPoint, armorClass, baseArmorClass, attackDmg, baseAttackDmg, hitChance, initiative, level, heroXP, posY, posX, currentWeapon, currentShield);
    }

    public int getAttackDmg() {
        int totalDmg = getBaseAttackDmg() + getCurrentWeapon().getWeapDmg();
        return totalDmg;
    }

    public int getArmorClass() {
        int totalAC = getBaseArmorClass() + getCurrentShield().getShieldAC();
        return totalAC;
    }
}