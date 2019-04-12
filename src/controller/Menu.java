package controller;

import controller.world.World;

import java.io.Serializable;

public class Menu implements Serializable {
    private static int numberOfCharacters = 53;

    //Prints a menu when the game starts
    public static void startMenu() {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* 1) Create new player");
        System.out.println("* 2) Login existing player");
        System.out.println("* 3) Settings");
        System.out.println("* 4) View High score");
        System.out.println("* 5) Help");
        System.out.println("* 9) Quit");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    //Prints the start menu when entering the game
    public static void mainMenu() {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* 1) New Game");
        System.out.println("* 2) Load Game");
        System.out.println("* 3) Settings");
        System.out.println("* 4) Help");
        System.out.println("* 9) Log out");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    //Prints the start menu when entering the game
    public static void inGameMenu() {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* 1) Save Game");
        System.out.println("* 2) Load Game");
        System.out.println("* 3) Settings");
        System.out.println("* 4) Help");
        System.out.println("* 5) Back to game");
        System.out.println("* 9) Main menu");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    //Prints the navigation menu each time the player enters the adventure state
    public static void navigateMenu(Player player, int gameTurn) {

        System.out.println(printCharacters(numberOfCharacters, false));
        System.out.println("* " + player.getName() + ": " + player.getHero().getCurrHealthPoint() + "/" + player.getHero().getFullHealthPoint()
                + " HP * Lv: " + player.getHero().getLevel() + " * " + "Moves: " + gameTurn + " * " + "Score: " + player.getScore());
        System.out.println(printCharacters(numberOfCharacters, false));
        System.out.println("* " + Program.keybind.getNorthKey() + ") = North");
        System.out.println("* " + Program.keybind.getSouthKey() + ") = South");
        System.out.println("* " + Program.keybind.getWestKey() + ") = West");
        System.out.println("* " + Program.keybind.getEastKey() + ") = East");
        System.out.println("* " + Program.keybind.getOpenInventory() + ") = Open Inventory");
        System.out.println("* " + Program.keybind.getOpenHeroStatus() + ") = Open Hero Stats");
        System.out.println("* " + Program.keybind.getOpenMap() + ") = Open Map");
        System.out.println("* " + Program.keybind.getOpenMenu() + ") = Open Menu");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    //Prints a settings menu
    public static void settings() {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* 1) Change keybindings");
        System.out.println("* 2) Show error log");
        System.out.println("* 9) Go back");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    public static void aboutMenu() {
        System.out.println(printCharacters(50, false));
        System.out.println("* 1) About");
        System.out.println("* 2) Help");
        System.out.println("* 3) Credits");
        System.out.println("* 9) Go back");
        System.out.println(printCharacters(50, false));
    }

    //Prints the menu for changing key binds
    public void changeKeyBindings() {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* 1) Change north keybind (" + Program.keybind.getNorthKey() + ")");
        System.out.println("* 2) Change south keybind (" + Program.keybind.getSouthKey() + ")");
        System.out.println("* 3) Change west keybind (" + Program.keybind.getWestKey() + ")");
        System.out.println("* 4) Change east keybind (" + Program.keybind.getEastKey() + ")");
        System.out.println("* 5) Change Open Inventory keybind (" + Program.keybind.getOpenInventory() + ")");
        System.out.println("* 9) Go back");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    public static void incorrectInput() {
        System.out.println("* Incorrect selection");
    }

    public static void inventoryFull() {
        System.out.println("* Inventory is full");
    }

    public static void directionHasNoDoor() {
        System.out.println("* You can not walk in that direction");
    }

    //Prints the normal map with the player only visible
    public static void openMap(World world, Player player) {
        String leftWrap, rightWrap;
        String roomStatus;

        System.out.println();
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                }
                if (world.getWorld()[y][x].isVisited() && (player.getHero().getPosY() != y && player.getHero().getPosX() != x)) {
                    //TODO Make this appear when the room has been visisted
                    roomStatus = "----";
                }
                if ((player.getHero().getPosY() == y && player.getHero().getPosX() == x)) {
                    roomStatus = "Hero";
                } else {
                    roomStatus = "";
                }
                System.out.printf("%s%-4s%s", leftWrap, roomStatus, rightWrap);
            }
            System.out.println();
        }
    }

    //Prints a development world map with the player and monsters only
    public static void openPlayerAndMonsterMap(World world, Player player) {
        String leftWrap, rightWrap;
        String blankSpace = " ";
        String roomStatus;

        System.out.println();
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                }
                if (world.getWorld()[y][x].isVisited() && (player.getHero().getPosY() != y && player.getHero().getPosX() != x)) {
                    roomStatus = "----";
                }
                if ((player.getHero().getPosY() == y && player.getHero().getPosX() == x)) {
                    roomStatus = "Hero";
                } else {
                    roomStatus = "";
                }
                System.out.printf("%s%-6s%s", leftWrap, roomStatus, rightWrap);
            }
            System.out.println();
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                    if (world.getMonsters()[y][x] != null) {
                        System.out.printf("%s%-6s%s", leftWrap, world.getMonsters()[y][x].getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-6s%s", leftWrap, blankSpace, rightWrap);
                    }
                }
            }
            System.out.println();
        }
    }

    //Prints a development world map where everything is visible
    public static void openDevelopmentMap(World world, Player player) {
        String leftWrap, rightWrap;
        String blankSpace = " ";
        printHyphens();
        System.out.println();
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                }
                if (x == world.getWorld().length - 1) {
                    System.out.printf("%s%-19s%s", leftWrap, world.getWorld()[y][x].getName(), rightWrap);
                } else {
                    System.out.printf("%s%-19s%s | ", leftWrap, world.getWorld()[y][x].getName(), rightWrap);
                }
            }
            System.out.println();
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                    if (x == world.getWorld().length - 1) {
                        System.out.printf("%s%-19s%s", leftWrap, player.getHero().getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s | ", leftWrap, player.getHero().getName(), rightWrap);
                    }
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                    if (x == world.getWorld().length - 1) {
                        System.out.printf("%s%-19s%s", leftWrap, blankSpace, rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s | ", leftWrap, blankSpace, rightWrap);
                    }
                }
            }
            System.out.println();
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                }
                if (x == world.getWorld().length - 1) {
                    if (world.getMonsters()[y][x] != null) {
                        System.out.printf("%s%-19s%s", leftWrap, world.getMonsters()[y][x].getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s", leftWrap, blankSpace, rightWrap);
                    }
                } else {
                    if (world.getMonsters()[y][x] != null) {
                        System.out.printf("%s%-19s%s | ", leftWrap, world.getMonsters()[y][x].getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s | ", leftWrap, blankSpace, rightWrap);
                    }
                }
            }
            System.out.println();
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "*";
                    rightWrap = "*";
                } else {
                    leftWrap = "[";
                    rightWrap = "]";
                }
                if (x == world.getWorld().length - 1) {
                    if (world.getWorld()[y][x].isHasItem()) {
                        System.out.printf("%s%-19s%s", leftWrap, world.getWorld()[y][x].getItem().getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s", leftWrap, blankSpace, rightWrap);
                    }
                } else {
                    if (world.getWorld()[y][x].isHasItem()) {
                        System.out.printf("%s%-19s%s | ", leftWrap, world.getWorld()[y][x].getItem().getName(), rightWrap);
                    } else {
                        System.out.printf("%s%-19s%s | ", leftWrap, blankSpace, rightWrap);
                    }
                }
            }
            System.out.println();
            printHyphens();
            System.out.println();
        }
        //TODO send the World objects String[] array to this method and print it in a neat way
    }

    //Print the FOG Map
    public static void openFogMap(World world, Player player) {
        String leftWrap, rightWrap;
        String blankSpace = " ";
        for (int x = 0; x < world.getWorld().length; x++) {
            System.out.print("------------");
        }
        System.out.println();
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (y == player.getHero().getPosY() && x == player.getHero().getPosX()) {
                    leftWrap = "[*";
                    rightWrap = "*]";
                } else {
                    leftWrap = "[ ";
                    rightWrap = " ]";
                }
                if (x == world.getWorld().length - 1) {
                    System.out.printf("%s%-7s %s", leftWrap, blankSpace, rightWrap);
                } else {
                    System.out.printf("%s%-7s%s|", leftWrap, blankSpace, rightWrap);
                }
            }
            System.out.println();
            for (int x = 0; x < world.getWorld().length; x++) {
                System.out.print("------------");
            }
            System.out.println();
        }
    }

    //Opens the inventory
    public static void openInventory(Player player) {
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        System.out.println("* " + player.getHero().getName() + "'s backpack inventory.");
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
        for (int i = 0; i < player.getHero().getInventory().getInventoryList().length; i++) {
            if (player.getHero().getInventory().getInventoryList()[i] == null) {
                System.out.println("* [" + (i + 1) + "]" + "Empty slot");
            } else {
                System.out.println("* [" + (i + 1) + "]" + player.getHero().getInventory().getInventoryList()[i].getName());
            }
        }
        System.out.print(printCharacters(numberOfCharacters, false) + "\n");
    }

    // Open Hero Stats
    public static void openHeroStatus(Player player) {
        System.out.println(printCharacters(numberOfCharacters, false));
        System.out.println("* Level: " + player.getHero().getLevel() + ".");
        System.out.println("* Health: " + player.getHero().getFullHealthPoint() + "HP");
        System.out.println("* Attack damage: " + player.getHero().getAttackDmg() + ".");
        System.out.println("* Hit chance: " + player.getHero().getHitChance() + ".");
        System.out.println("* Armor Class: " + player.getHero().getArmorClass() + ".");
        System.out.println(printCharacters(numberOfCharacters, false));
    }

    // Print this every time saved game is pressed
    public static void savedGame(Player player) {
        System.out.println();
        System.out.println(printCharacters(numberOfCharacters, false));
        System.out.println("\t\tSaved game for player " + player.getName());
        System.out.println(printCharacters(numberOfCharacters, false));
        System.out.println();
    }


    //Print new line
    public static void printNewLines(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println();
        }
    }

    //Print stars or white spaces
    public static String printCharacters(int numberOfCharacters, boolean printWhiteSpace) {
        StringBuilder character = new StringBuilder("");
        character.append("*");
        if (printWhiteSpace) {
            for (int i = 0; i < numberOfCharacters; i++) {
                character.append(" ");
            }
        } else {
            for (int i = 0; i < numberOfCharacters; i++) {
                character.append("*");
            }
        }
        return String.valueOf(character.toString());
    }

    public static void intro() {
        String message = "Welcome to THE DARK CAVES OF RAFELL ABYSS";
        char[] chars = message.toCharArray();
        System.out.println();
        try {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                Thread.sleep(50);
            }
            System.out.println();
            System.out.println();
        } catch (Exception ex) {
            System.out.println("bug");
        }
    }

    public static void gameIntro() {
        System.out.println("Entering the dark dungeon from the outside, blinding your vision in the dark.\n" +
                "You lit your lantern to get a clear view of direction.\n" +
                "The same moment you hear the roof start to crumble and huge stones fall down and blocking the entry.\n" +
                "With the only knowable entry blocked there is only one way to go.\n" +
                "Forward into the howling sounds of monsters and danger.");
        System.out.println();
        try {
            Thread.sleep(2000);          // Slow down between attacks
        } catch (Exception ex) {
            System.out.println("bug in pause method");
        }

    }
    
    private static void printHyphens(){
        for (int x = 0; x < 213; x++) {
            System.out.print("-");
        }
    }
}