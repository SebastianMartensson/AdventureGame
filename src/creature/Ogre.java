package creature;

import controller.Dice;

import java.security.SecureRandom;

import static controller.Sound.playSound;

public class Ogre extends Monster {
    SecureRandom screamRand = new SecureRandom();

    //Creature.Ogre monster class

//    HP: 100
//    initiative: +1
//    Armor class: 11
//    hit +6 (attack bonus)
//    Great club: damage: 2d8 + 4
//    xp: 450

    public Ogre(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative, xP, monsterDesc);
    }


    public int getAttackDmg() {
        int totalDmg = super.getAttackDmg() + Dice.getTwoD8();
        return totalDmg;
    }

    public void getSpeakStart() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/ogre/ogre_start1.wav");
                break;
            case 2:
                playSound("sounds/ogre/ogre_start2.wav");
                break;
        }
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/ogre/ogre_pain1.wav");
                break;
            case 2:
                playSound("sounds/ogre/ogre_pain2.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/ogre/ogre_attack1.wav");
                break;
            case 2:
                playSound("sounds/ogre/ogre_attack2.wav");
                break;
            case 3:
                playSound("sounds/ogre/ogre_attack3.wav");
                break;
        }
    }

    public void getDeathScream() {
        playSound("sounds/ogre/ogre_death.wav");
    }

    public void getMiss(Hero hero, Monster monster) {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/ogre/ogre_miss3.wav");
                System.out.println(hero.getName() + " dodge the " + monster.getName() + "'s incoming attack. It´s a miss!");
                break;
            case 2:
                playSound("sounds/ogre/ogre_miss1.wav");
                System.out.println("The attack miss!");
                break;
            case 3:
                playSound("sounds/ogre/ogre_miss2.wav");
                System.out.println("But miss " + hero.getName() + "!");
                break;
        }
    }

    public void getHitSound() {
        playSound("sounds/ogre/ogre_hit1.wav");
    }
}
