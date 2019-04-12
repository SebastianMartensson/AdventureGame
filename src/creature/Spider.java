package creature;

import java.security.SecureRandom;

import static controller.Sound.playSound;

public class Spider extends Monster {
    SecureRandom screamRand = new SecureRandom();

    //Creature.Spider monster class

//    HP: 7
//    initiative: +6
//    Armor class: 4
//    hit +4 (attack bonus)
//    Bite: damage: 2
//    xp: 15

    public Spider(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative, xP, monsterDesc);
    }

    public int getAttackDmg() {
        int totalDmg = super.getAttackDmg();
        return totalDmg;
    }

    public void getSpeakStart() {
        playSound("sounds/spider/spider_start.wav");
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/spider/spider_pain1.wav");
                break;
            case 2:
                playSound("sounds/spider/spider_pain2.wav");
                break;
            case 3:
                playSound("sounds/spider/spider_pain3.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        playSound("sounds/spider/spider_attack.wav");
    }

    public void getDeathScream() {
        playSound("sounds/spider/spider_death.wav");
    }

    public void getMiss(Hero hero, Monster monster) {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/spider/spider_miss.wav");
                System.out.println(hero.getName() + " dodge the " + monster.getName() + "'s incoming bite. It´s a miss!");
                break;
            case 2:
                playSound("sounds/spider/spider_miss.wav");
                System.out.println("The attack miss!");
                break;
            case 3:
                playSound("sounds/spider/spider_miss.wav");
                System.out.println("But miss " + hero.getName() + "!");
                break;
        }
    }

    public void getHitSound() {
        int scream = 1 + screamRand.nextInt(2);
        switch (scream) {
            case 1:
                playSound("sounds/spider/spider_hit1.wav");
                break;
            case 2:
                playSound("sounds/spider/spider_hit2.wav");

        }
    }
}

