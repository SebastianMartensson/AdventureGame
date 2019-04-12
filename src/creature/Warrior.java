package creature;

import item.shield.Shield;
import item.weapon.Weapon;

public class Warrior extends Hero {

    //Creature.Warrior Hero class

    public Warrior(String name, int healthPoint, int armorClass, int baseArmorClass, int attackDmg, int baseAttackDmg, int hitChance, int initiative, int level, int heroXP, int posY, int posX, Weapon currentWeapon, Shield currentShield) {
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