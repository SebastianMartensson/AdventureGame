package creature;

import java.io.Serializable;

public abstract class Creature implements Serializable {

    private String name;            //Name
    private int currHealthPoint;    // current HP life of the Creature.Creature
    private int fullHealthPoint;    // Full HP
    private int armorClass;         // Creatures armor (AC)
    private int attackDmg;          // Damage the creature can give.
    private int hitChance;          // The creature chance to hit it´s target.
    private int initiative;         // The creature initiative starting combat.

    public Creature(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative) {
        this.name = name;
        this.fullHealthPoint = healthPoint;
        this.armorClass = armorClass;
        this.attackDmg = attackDmg;
        this.hitChance = hitChance;
        this.initiative = initiative;

    }

    public String getName() {
        return name;
    }

    public int getCurrHealthPoint() {
        return currHealthPoint;
    }

    public void setCurrHealthPoint(int currHealthPoint) {
        this.currHealthPoint = currHealthPoint;
    }

    public int getFullHealthPoint() {
        return fullHealthPoint;
    }

    public void setFullHealthPoint(int fullHealthPoint) {
        this.fullHealthPoint = fullHealthPoint;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public int getHitChance() {
        return hitChance;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getInitiative() {
        return initiative;
    }
}
