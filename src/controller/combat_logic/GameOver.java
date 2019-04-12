package controller.combat_logic;

import creature.Hero;
import creature.Monster;

import java.security.SecureRandom;

import static controller.Sound.playSound;
import static controller.State.StartMenu;
import static controller.combat_logic.Combat.pause;

public class GameOver {
    public static void gameOver(Hero hero, Monster monster) {
        String message = "GAME OVER!";
        char[] chars = message.toCharArray();
        SecureRandom deathRand = new SecureRandom();

        int death = 1 + deathRand.nextInt(4);
        switch (death) {
            case 1:
                System.out.println();
                playSound("sounds/death1.wav");
                System.out.println(hero.getName() + " falls dead to the floor!");
                break;
            case 2:
                System.out.println();
                playSound("sounds/death2_crushhead.wav");
                System.out.println(monster.getName() + " crush the " + hero.getName() + "'s head falling dead to the ground.");
                break;
            case 3:
                System.out.println();
                playSound("sounds/death3_neckstab.wav");
                System.out.println(monster.getName() + " strike the " + hero.getName() + "s throat and suffocates from his blood.");
                break;
            case 4:
                System.out.println();
                playSound("sounds/death4.wav");
                System.out.println(hero.getName() + " falls wounded to the floor! " + monster.getName() + " strikes a last strike in the head!");
                break;
        }
        pause();
        pause();
        pause();
        pause();
        playSound("sounds/gameover.wav");
        try {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                Thread.sleep(400);          // Prints game over slow.
            }
            System.out.println();
            System.out.println();
        } catch (Exception ex) {
            System.out.println("bug");
        }
    }
}
