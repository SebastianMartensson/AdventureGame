package creature;

import controller.Dice;

import java.security.SecureRandom;

import static controller.Sound.playSound;

public class Goblin extends Monster {

    SecureRandom screamRand = new SecureRandom();
    //Creature.Goblin monster class

//    HP: 10
//    Armor class: 10
//    initiative: +3
//    hit +4 (attack bonus)
//    Short sword: damage: 1d6 + 2
//    xp: 50

    public Goblin(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative, xP, monsterDesc);
    }

    //Monster attack
    public int getAttackDmg() {
        int totalDmg = super.getAttackDmg() + Dice.getD6();
        return totalDmg;
    }

    public void getSpeakStart() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/goblin/goblin_guts.wav");
                break;
            case 2:
                playSound("sounds/goblin/goblin_hurt.wav");
                break;
            case 3:
                playSound("sounds/goblin/goblin_laugh.wav");
                break;
        }
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(4);
        switch (scream) {
            case 1:
                playSound("sounds/goblin/goblinpain1.wav");
                break;
            case 2:
                playSound("sounds/goblin/goblinpain2.wav");
                break;
            case 3:
                playSound("sounds/goblin/goblinpain3.wav");
                break;
            case 4:
                playSound("sounds/goblin/goblinpain4.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        playSound("sounds/goblin/goblin_attack.wav");
    }

    public void getDeathScream() {
        playSound("sounds/goblin/goblin_death.wav");
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
                System.out.println("But miss " + hero.getName() + "!");
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
        int scream = 1 + screamRand.nextInt(7);
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
            case 5:
                playSound("sounds/stabhit1.wav");
                break;
            case 6:
                playSound("sounds/stabhit2.wav");
                break;
            case 7:
                playSound("sounds/stabhit3.wav");
                break;
        }
    }

}
