package controller.combat_logic;

import controller.Menu;
import controller.Player;
import controller.input_handling.HandleInput;
import creature.Monster;
import creature.Ogre;

import java.security.SecureRandom;
import java.util.Scanner;

import static controller.Sound.playSound;
import static controller.combat_logic.HeroStrike.playerStrike;

public class PlayerAttack {

    //Player Battle menu
    public static void playerAttack(Player player, Monster monster, int battleRounds) {
        Scanner heroAction = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        String choice;

        while (loop) {
            attackMenu(player, monster, battleRounds);
            System.out.print(">> ");
            choice = HandleInput.checkInput(heroAction.nextLine(), true);
            switch (choice) {
                case "1":
                    System.out.println();               // Insert many spaces here if you want to hide.
                    playerStrike(player, monster, choice);
                    loop = false;
                    break;
                case "2":
                    playerStrike(player, monster, choice);
                    loop = false;
                    break;
                case "3":
                    playerStrike(player, monster, choice);
                    loop = false;
                    break;
                case "4":
                    playSound("sounds/guard.wav");
                    System.out.println(player.getHero().getName() + " take a defensive stance and taunt the " + monster.getName() + "!");
                    player.getHero().setArmorClass(player.getHero().getArmorClass() + 5);
                    loop = false;
                    break;
                case "5":
                    combatInventory(player);
                    break;
                case "6":
                    System.out.println("Do you want to Run? (Y/N): ");
                    System.out.print(">> ");
                    if (input.nextLine().equalsIgnoreCase("Y")) {
                        flee(monster);
                        loop = false;
                    }
                    break;
            }
        }
    }

    //Run from Battle
    private static void flee(Monster monster) {
        SecureRandom rand = new SecureRandom();
        System.out.println();
        if (monster instanceof Ogre) {
            System.out.println("You can´t run!, "+monster.getName() + " attacks you!");
            Combat.flee = 1;
        }
        // < 25% true
        else if (rand.nextInt(100) < 25) {
            System.out.println("Trying to escape, the "+monster.getName() + " attacks you!");
            Combat.flee = 1;
        }else{
            System.out.println("You safely escaped from the "+ monster.getName() + "!");
            Combat.flee = 2;
        }
    }

    private static void combatInventory(Player player){
        Scanner heroAction = new Scanner(System.in);
        Menu.openInventory(player);
        System.out.println("* 1) Use item");
        System.out.println("* 2) Back to menu");
        System.out.print(">> ");
        int action = heroAction.nextInt();
        switch (action) {
            case 1:
                System.out.println("* Which item would you like to use?");
                System.out.print(">> ");
                action = heroAction.nextInt();
                player.getHero().getInventory().getItem(action, player);
                break;
            case 2:
                break;
        }
    }

    private static void attackMenu(Player player, Monster monster, int battleRounds) {
        System.out.println();
        System.out.println("***************************************************");
        System.out.print("* " + player.getHero().getName() + ": " + player.getHero().getCurrHealthPoint() + "/" + player.getHero().getFullHealthPoint() + " HP * ");
        System.out.println(monster.getName() + ": " + monster.getCurrHealthPoint() + "/" + monster.getFullHealthPoint() + " HP");
        System.out.println("***************************************************");
        System.out.println("* " + player.getHero().getName() + " Lv: " + player.getHero().getLevel() + "   *   Battle round: " + battleRounds + "   ");
        System.out.println("***************************************************");
        System.out.println("* 1) Attack:  Normal strike              ");
        System.out.println("* 2) Attack:  Fast strike                ");
        System.out.println("* 3) Attack:  Power strike               ");
        System.out.println("* 4) Defence: Guard                      ");
        System.out.println("* 5) item                                ");
        System.out.println("* 6) Run                                 ");
        System.out.println("***************************************************");
        System.out.println();
    }

}
