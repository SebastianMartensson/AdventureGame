package controller.combat_logic;

import controller.Dice;
import controller.HeroLevel;
import controller.Player;
import creature.*;

import static controller.combat_logic.GameOver.gameOver;
import static controller.combat_logic.MonsterAttack.monsterCombat;
import static controller.combat_logic.PlayerAttack.*;
/*
This is the main combat that calls all other function in the combat logic.
*/


public class Combat {

    public static int flee;

    //The Main battle
    public static void startCombat(Player player, Monster monster) {
        flee = 1;
        int battleRounds = 1;
        int monsterInitiativeRoll, heroInitiativeRoll, critInitiativeRoll;
        int oldGuard = player.getHero().getArmorClass();  // Guard algorithm
        monster.setCurrHealthPoint(monster.getFullHealthPoint());

        do {
            heroInitiativeRoll = Dice.getD20() + player.getHero().getInitiative();      //Players Initiative Roll
            monsterInitiativeRoll = Dice.getD20() + monster.getInitiative(); //Monsters Initiative Roll
        } while (heroInitiativeRoll == monsterInitiativeRoll);
        critInitiativeRoll = heroInitiativeRoll - player.getHero().getInitiative();
        //playSoundBattleScore("sounds/BattleScore.wav");
        System.out.println();
        System.out.println(monster.getMonsterDesc());
        while (true) {         //Loop main Battle
            // When Hero Starts
            if (heroInitiativeRoll > monsterInitiativeRoll || critInitiativeRoll == 20) {
                System.out.println();
                System.out.println(monster.getName() + " have not notice your present yet. " + player.getHero().getName() + " decides to...");
                do {
                    if (player.getHero().getArmorClass() == oldGuard + 5) {
                        player.getHero().setArmorClass(oldGuard);
                    }
                    pause();
                    playerAttack(player, monster, battleRounds);
                    if (monster.getCurrHealthPoint() <= 0) {
                        monsterDead(player.getHero(), monster);
                        break; // Ends Combat with Player win!
                    }
                    if (flee == 2) {
                        break; // Ends Combat with player running!
                    }
                    pause();                        //Space between attacks
                    System.out.println();           //Space between attacks
                    monsterCombat(player.getHero(), monster);
                    if (player.getHero().getCurrHealthPoint() <= 0) {
                        gameOver(player.getHero(), monster);
                        break;
                    }
                    battleRounds++;
                } while (true);
                break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------//
                // When Enemy Starts
            } else {
                System.out.println();
                System.out.println("You are taken by surprise by the monsters fast action!");
                System.out.println(monster.getName() + " attacks before you are able to draw your weapon!");
                monster.getSpeakStart();
                pause();
                pause();
                do {
                    System.out.println();       //Space between attacks
                    monsterCombat(player.getHero(), monster);
                    if (player.getHero().getCurrHealthPoint() <= 0) {
                        gameOver(player.getHero(), monster);
                        break;
                    }
                    if (player.getHero().getArmorClass() == oldGuard + 5) {
                        player.getHero().setArmorClass(oldGuard);
                    }
                    pause();
                    playerAttack(player, monster, battleRounds);
                    if (monster.getCurrHealthPoint() <= 0) {
                        monsterDead(player.getHero(), monster);
                        break; // Ends Combat with player win!
                    }
                    if (flee == 2) {
                        break; // Ends Combat with player running!
                    }
                    battleRounds++;
                } while (true);
                break;
            }
        }  // END Main battle loop
    }

    //  When monster dies, gets XP from monster, start HeroLevel.class if hero will go up in level.
    private static void monsterDead(Hero hero, Monster monster) {
        System.out.println();
        monster.getDeathScream(); // monster death scream
        pause();
        System.out.println(monster.getName() + " falls dead to the floor!");
        System.out.println(hero.getName() + " has gained " + monster.getXP() + " experience points");
        System.out.println();
        hero.setHeroXP(hero.getHeroXP() + monster.getXP());
        pause();
        pause();
        HeroLevel.LevelUp(hero, hero.getHeroXP());
        pause();

    }

    public static void pause() {
        try {
            Thread.sleep(400);          // Slow down between attacks
        } catch (Exception ex) {
            System.out.println("bug in pause method");
        }
    }
}


