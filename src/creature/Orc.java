package creature;

import controller.Dice;

import java.security.SecureRandom;

import static controller.Sound.playSound;

public class Orc extends Monster {

    SecureRandom screamRand = new SecureRandom();

    //Creature.Orc monster class

//    HP: 20
//    initiative: +2
//    Armor class: 13
//    hit +5 (attack bonus)
//    axe: damage: 1d12 + 3
//    xp: 100

    public Orc(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative, xP, monsterDesc);
    }

    public int getAttackDmg() {
        int totalDmg = super.getAttackDmg() + Dice.getD12();
        return totalDmg;
    }

    public void getSpeakStart() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/orc/orc_die.wav");
                break;
            case 2:
                playSound("sounds/orc/orc_roar.wav");
                break;
            case 3:
                playSound("sounds/orc/orc_laugh.wav");
                break;
        }
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/orc/orc_pain1.wav");
                break;
            case 2:
                playSound("sounds/orc/orc_pain2.wav");
                break;
            case 3:
                playSound("sounds/orc/orc_pain3.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/orc/orc_attack1.wav");
                break;
            case 2:
                playSound("sounds/orc/orc_attack2.wav");
                break;
        }
    }

    public void getDeathScream() {
        playSound("sounds/orc/orc_death.wav");
    }

    public void getMiss(Hero hero, Monster monster) {
        int scream = 1 + screamRand.nextInt(6);
        switch (scream) {
            case 1:
                playSound("sounds/miss1.wav");
                System.out.println(hero.getName() + " dodge the " + monster.getName() + "'s incoming attack. It´s a miss!");
                break;
            case 2:
                playSound("sounds/miss2.wav");
                System.out.println("The attack miss!");
                break;
            case 3:
                playSound("sounds/missparry.wav");
                System.out.println(hero.getName() + " is able to parry the " + monster.getName() + "'s incoming attack. It´s a miss!");
                break;
            case 4:
                playSound("sounds/miss3.wav");
                System.out.println("But miss the " + hero.getName() + "!");
                break;
            case 5:
                playSound("sounds/missparry2.wav");
                System.out.println(hero.getName() + " is able to parry the " + monster.getName() + "'s incoming attack. It´s a miss!");
                break;
            case 6:
                playSound("sounds/missparry3.wav");
                System.out.println(hero.getName() + " is able to parry the " + monster.getName() + "'s incoming attack. It´s a miss!");
                break;
        }
    }

    public void getHitSound() {
        int scream = 1 + screamRand.nextInt(4);
        switch (scream) {
            case 1:
                playSound("sounds/hit1.wav");
                break;
            case 2:
                playSound("sounds/hit2.wav");
                break;
            case 3:
                playSound("sounds/hit3.wav");
                break;
            case 4:
                playSound("sounds/hit4.wav");
                break;
        }
    }

}
