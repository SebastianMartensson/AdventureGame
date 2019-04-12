package creature;

import controller.Dice;

import java.security.SecureRandom;

import static controller.Sound.playSound;


public class Ghoul extends Monster {

    private SecureRandom screamRand = new SecureRandom();
    //Creature.Ghoul monster class

//    HP: 30
//    initiative: +0
//    Armor class: 12
//    hit +2 (attack bonus)
//    Bite: damage: 2d4 + 2
//    xp: 200

    public Ghoul(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative, xP, monsterDesc);
    }

    //Monster attack
    public int getAttackDmg() {
        int totalDmg = super.getAttackDmg() + Dice.getTwoD4();
        return totalDmg;
    }

    public void getSpeakStart() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/ghoul/ghoul_speak1.wav");
                break;
            case 2:
                playSound("sounds/ghoul/ghoul_speak2.wav");
                break;
            case 3:
                playSound("sounds/ghoul/ghoul_speak3.wav");
                break;
        }
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(4);
        switch (scream) {
            case 1:
                playSound("sounds/ghoul/ghoul_pain1.wav");
                break;
            case 2:
                playSound("sounds/ghoul/ghoul_pain2.wav");
                break;
            case 3:
                playSound("sounds/ghoul/ghoul_pain3.wav");
                break;
            case 4:
                playSound("sounds/ghoul/ghoul_pain4.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/ghoul/ghoul_attack1.wav");
                break;
            case 2:
                playSound("sounds/ghoul/ghoul_attack2.wav");
                break;
        }
    }

    public void getDeathScream() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/ghoul/ghoul_death1.wav");
                break;
            case 2:
                playSound("sounds/ghoul/ghoul_death2.wav");
                break;
            case 3:
                playSound("sounds/ghoul/ghoul_death3.wav");
                break;
        }
    }

    public void getMiss(Hero hero, Monster monster) {
        int scream = 1 + screamRand.nextInt(3);
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
                playSound("sounds/miss3.wav");
                System.out.println("But miss " + hero.getName() + "!");
                break;
        }
    }

    public void getHitSound() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/hit1.wav");
                break;
            case 2:
                playSound("sounds/hit3.wav");
                break;
        }
    }
}
