package controller;

import creature.Hero;

import java.io.Serializable;

import static controller.Sound.playSound;

public class HeroLevel implements Serializable {

    public static void LevelUp(Hero hero, int xp) {
        // Level 1
        if (xp >= 100 && hero.getLevel() == 1) {
            hero.setFullHealthPoint(hero.getFullHealthPoint() + 10);
            hero.setCurrHealthPoint(hero.getFullHealthPoint());
        setNewStats(hero);
        } else if (xp >= 300 && hero.getLevel() == 2) {
            // Level 2
            hero.setFullHealthPoint(hero.getFullHealthPoint() + 15);
            hero.setCurrHealthPoint(hero.getFullHealthPoint());
            setNewStats(hero);
        } else if (xp >= 600 && hero.getLevel() == 3) {
            // Level 3
            hero.setFullHealthPoint(hero.getFullHealthPoint() + 20);
            hero.setCurrHealthPoint(hero.getFullHealthPoint());
            setNewStats(hero);
        } else if (xp >= 1000 && hero.getLevel() == 4) {
            // Level 4
            hero.setFullHealthPoint(hero.getFullHealthPoint() + 25);
            hero.setCurrHealthPoint(hero.getFullHealthPoint());
            setNewStats(hero);
        } else if (xp >= 2000 && hero.getLevel() == 5) {
            // Level 5
            hero.setFullHealthPoint(hero.getFullHealthPoint() + 30);
            hero.setCurrHealthPoint(hero.getFullHealthPoint());
            setNewStats(hero);
        }
    }
    // Set new stats
    private static void setNewStats(Hero hero) {
        playSound("sounds/level_up.wav");
        hero.setLevel(hero.getLevel() + 1);
        hero.setBaseAttackDmg(hero.getBaseAttackDmg() + 1);
        hero.setHitChance(hero.getHitChance() + 1);
        hero.setBaseArmorClass(hero.getBaseArmorClass() + 1);
        printNewStats(hero);
    }
    // Printing new stats
    private static void printNewStats(Hero hero) {
        System.out.println("***************************************************");
        System.out.println("* " + hero.getName() + " has gained a new level!");
        System.out.println("*");
        System.out.println("* Level increase to " + hero.getLevel() + ".");
        System.out.println("* Health increase to " + hero.getFullHealthPoint() + "HP");
        System.out.println("* Attack damage increase to " + hero.getBaseAttackDmg() + ".");
        System.out.println("* Hit chance increase to " + hero.getHitChance() + ".");
        System.out.println("* Armor Class increase to " + hero.getBaseArmorClass() + ".");
        System.out.println("***************************************************");
    }
}
