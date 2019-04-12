package controller;

import controller.combat_logic.Combat;
import controller.file_handling.Load;
import controller.file_handling.Login;
import controller.file_handling.Save;
import controller.file_handling.SavedGame;
import controller.input_handling.HandleInput;
import controller.monster_logic.MonsterLogic;
import controller.world.Keybind;
import controller.world.World;
import creature.*;
import item.shield.EmptyShieldHand;
import item.treasure.Treasure;
import item.weapon.club.Club;

import java.io.Serializable;
import java.util.Scanner;

import static controller.Sound.playSound;
import static controller.State.*;
import static controller.combat_logic.Combat.startCombat;


public class Program implements Serializable {
    public Scanner gameInput = new Scanner(System.in);
    public static Keybind keybind;
    private Menu menu;
    private World world;
    private State currentState;
    private Player player;
    private SavedGame savedGame;
    private MonsterLogic monsterLogic;
    private boolean running;
    private boolean quit = false;
    private String choice = "";
    private int gameTurn = 0;
    private int monsterKills = 0;
    private String loggedInPlayer;

    public static void main(String[] args) {
        Program game = new Program();
        //Start program here
        //Run the game
        game.run();
    }

    private void run() {
        menu = new Menu();
        keybind = new Keybind();
        //Runs the game introduction
        Menu.intro();
        currentState = StartMenu;
        while (!quit) {
            switch (currentState) {
                case StartMenu:
                    startMenu();
                    break;
                case MainMenu:
                    mainMenu();
                    break;
                case InGameMenu:
                    inGameMenu();
                    break;
                case NewPlayer:
                    //Starts a new game
                    createNewPlayer();
                    currentState = MainMenu;
                    break;
                case LoginPlayer:
                    loginPlayer();
                    break;
                case SaveGame:
                    if (player != null && world != null && currentState != null && monsterLogic != null) {
                        Save.saveGame(player, world, currentState, monsterLogic);
                        Menu.savedGame(player);
                    }
                    currentState = Adventuring;
                    break;
                case LoadGame:
                    savedGame = Load.loadGameFromFile(loggedInPlayer);
                    if (savedGame != null) {
                        world = savedGame.getWorld();
                        player = savedGame.getPlayer();
                        monsterLogic = savedGame.getMonsterLogic();
                        currentState = Adventuring;
                    } else {
                        System.out.println("Could not load game");
                        System.out.println();
                        currentState = StartMenu;
                    }
                    break;
                case LoadingGame:
                    //Create new world with the player as parameter
                    world = new World(player);
                    monsterLogic = new MonsterLogic();
                    Menu.gameIntro();
                    currentState = Adventuring;
                    break;
                case Adventuring:
                    Menu.navigateMenu(player, gameTurn);
                    //Take movement input and move the hero on the map
                    if (heroAction(HandleInput.checkInput(gameInput.nextLine(), false), player)) {
                        //Display the room description
                        gameTurn++;
                        roomDesc();
                        playerVsMonsterCheck();
                        // Move monsters Spider and Goblin each time the player has moved
                        monsterLogic.monsterMovement(player, world, this);
                    }
                    //Menu.openMap(world, player);
                    //Menu.openDevelopmentMap(world, player);
                    //Menu.openPlayerAndMonsterMap(world, player);
                    break;
                case Fighting:
                    startCombat(player, world.getMonsters()[player.getHero().getPosY()][player.getHero().getPosX()]);
                    if (Combat.flee == 2) {
                    } else {
                        // If hero dies
                        if (player.getHero().getCurrHealthPoint() <= 0) {
                            System.out.println("Press C to continue...");
                            choice = HandleInput.checkInput(gameInput.nextLine(), false);
                            if (choice.toLowerCase().matches("[c]")) {
                                resetCurrentGame();
                                currentState = StartMenu;
                                break;
                            }
                        }
                        // Kills the monster and delete from the world.
                        monsterKills++;
                        itemCheck();
                        if (world.getMonsters()[player.getHero().getPosY()][player.getHero().getPosX()] instanceof Ogre) {
                            EndGame.endGame(monsterKills, player, gameTurn);
                            System.out.println("Press C to continue...");
                            choice = HandleInput.checkInput(gameInput.nextLine(), false);
                            if (choice.toLowerCase().matches("[c]")) {
                                resetCurrentGame();
                                currentState = StartMenu;
                                break;
                            }
                        }

                        world.getMonsters()[player.getHero().getPosY()][player.getHero().getPosX()] = null; // Kills the monster and delete from the world.

                    }
                    currentState = Adventuring;

                    break;
                case LogOut:
                    do {
                        System.out.println("Are you sure you want to log out? Y/N");
                        choice = HandleInput.checkInput(gameInput.nextLine(), false);
                        switch (choice.toLowerCase()) {
                            case "y":
                                player = null;
                                running = false;
                                break;
                            case "n":
                                currentState = MainMenu;
                                running = false;
                                break;
                            default:
                                Menu.incorrectInput();
                                running = true;
                                break;
                        }
                    } while (running);
                    currentState = StartMenu;
                    break;
                case Quit:
                    do {
                        System.out.println("Are you sure you want to quit? Y/N");
                        choice = HandleInput.checkInput(gameInput.nextLine(), false);
                        switch (choice.toLowerCase()) {
                            case "y":
                                quit = true;
                                running = false;
                                break;
                            case "n":
                                currentState = StartMenu;
                                running = false;
                                break;
                            default:
                                Menu.incorrectInput();
                                running = true;
                                break;
                        }
                    } while (running);
            }
        }
    }

    /*------------------Player interaction------------------*/

    //The method is initially called and a menu is displayed to the user
    private void startMenu() {
        do {
            Menu.startMenu();
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    currentState = NewPlayer;
                    running = false;
                    break;
                case "2":
                    currentState = LoginPlayer;
                    running = false;
                    break;
                case "3":
                    settings();
                    running = false;
                    break;
                case "4":
                    EndGame.viewHighScore();
                    System.out.println("Press Enter to  continue..");
                    gameInput.nextLine();
                    break;
                case "5":
                    aboutMenu();
                    running = false;
                    break;
                case "9":
                    currentState = Quit;
                    running = false;
                    break;
                default:
                    Menu.incorrectInput();
                    running = true;
                    break;

            }
        } while (running);
    }

    //Main menu. This menu is shown after a new player has been created, a player has successfully logged in,
    // or when a game is successfully loaded.
    private void mainMenu() {
        do {
            Menu.mainMenu();
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    if (checkIfPlayerIsReady()) {
                        createNewHero(player);
                    } else {
                        System.out.println("Could not create a new game. Create a new player or login");
                        currentState = StartMenu;
                    }
                    running = false;
                    break;
                case "2":
                    //Load game
                    currentState = LoadGame;
                    running = false;
                    break;
                case "3":
                    //Settings 
                    settings();
                    running = false;
                    break;
                case "4":
                    aboutMenu();
                    running = false;
                    break;
                case "9":
                    //Log out
                    currentState = LogOut;
                    running = false;
                    break;
                default:
                    System.out.println("That is not a valid option");
                    running = true;
                    break;
            }

        } while (running);
    }

    private void inGameMenu() {
        do {
            Menu.inGameMenu();
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    currentState = SaveGame;
                    running = false;
                    break;
                case "2":
                    currentState = LoadGame;
                    running = false;
                    break;
                case "3":
                    settings();
                    currentState = Adventuring;
                    running = false;
                    break;
                case "4":
                    aboutMenu();
                    currentState = Adventuring;
                    running = false;
                    break;
                case "5":
                    currentState = Adventuring;
                    running = false;
                    break;
                case "9":
                    if (currentState == InGameMenu) {
                        do {
                            System.out.println("Are you sure you want to exit the game? Y/N");
                            choice = HandleInput.checkInput(gameInput.nextLine(), false);
                            switch (choice.toLowerCase()) {
                                case "y":
                                    resetCurrentGame();
                                    currentState = StartMenu;
                                    running = false;
                                    break;
                                case "n":
                                    running = false;
                                    break;
                                default:
                                    Menu.incorrectInput();
                                    running = true;
                                    break;
                            }
                        } while (running);
                    }
            }
        } while (running);
    }

    // check if monster and hero are in the same room, If true start combat.
    private void playerVsMonsterCheck() {
        // Hero vs Monster
        if (world.getMonsters()[player.getHero().getPosY()][player.getHero().getPosX()] != null) {
            currentState = Fighting;
        } else {
            itemCheck();
        }
    }//Hero vs Monster end

    // check if item exist.
    private void itemCheck() {
        if (world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].isHasItem()) {
            if (world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].getItem() instanceof Treasure) {
                playSound("sounds/treasure.wav");
                player.getHero().getInventory().addItems(world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].getItem(), player);
                world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].setHasItem(false);
            } else {
                System.out.println("* You found " + world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].getItem().getName());
                System.out.println("* 1) Pick it up");
                System.out.println("* 2) Leave it on the ground");
                do {
                    choice = HandleInput.checkInput(gameInput.nextLine(), true);
                    switch (choice) {
                        case "1":
                            playSound("sounds/pick_up.wav");
                            player.getHero().getInventory().addItems(world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].getItem(), player);
                            world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].setHasItem(false);
                            running = false;
                            break;
                        case "2":
                            running = false;
                            break;
                        default:
                            Menu.incorrectInput();
                            running = true;
                            break;
                    }
                } while (running);
            }
        }
    }// Item check END

    // get room description when entering a room.
    private void roomDesc() {
        System.out.println(world.getWorld()[player.getHero().getPosY()][player.getHero().getPosX()].getDescription());
    }

    //Create a new hero 
    private void createNewHero(Player player) {
        running = false;
        do {
            System.out.println("Choose your class");
            System.out.println("1) Warrior");
            System.out.println("2) Rogue");
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    player.setHero(new Warrior(player.getName(), 100, 0, 12, 0, 15, 10, 1, 1, 0, 0, 0, new Club("Wooden Club", 0, 2, 0, true), new EmptyShieldHand("Empty Hand", 0, 0, 0)));
                    player.getHero().setCurrHealthPoint(player.getHero().getFullHealthPoint()); // Sets current health from full health, Don´t remove! keep it with hero creation
                    running = false;
                    currentState = LoadingGame;
                    break;
                case "2":
                    player.setHero(new Rogue(player.getName(), 25, 0, 15, 0, 0, 4, 4, 1, 0, 0, 0, new Club("Wooden Club", 0, 2, 0, true), new EmptyShieldHand("Empty Hand", 0, 0, 0)));
                    player.getHero().setCurrHealthPoint(player.getHero().getFullHealthPoint()); // Sets current health from full health, Don´t remove! keep it with hero creation
                    running = false;
                    currentState = LoadingGame;
                    break;
                default:
                    System.out.println("That is not a valid option");
                    running = true;
                    break;
            }
        } while (running);
    }

    //Create a new player
    private void createNewPlayer() {
        String name;
        System.out.println("Enter your name: ");
        name = HandleInput.checkInput(gameInput.nextLine(), false);
        if (name.length() > 9) {
            System.out.println("Your name can not be longer than 10 characters!");
        } else if (name.length() < 1) {
            System.out.println("You need to enter a name.");
        } else if (Login.loginPlayer(name)) {
            System.out.println("A player with that name already exists.");
            currentState = StartMenu;
        } else {
            player = new Player(name, null);
            Login.addPlayer(player);
        }
    }

    private void loginPlayer() {
        String name;
        System.out.println("Enter your name to log in:");
        name = HandleInput.checkInput(gameInput.nextLine(), false);
        if (Login.loginPlayer(name)) {
            player = new Player(name, null);
            System.out.println(name + " successfully logged in!");
            loggedInPlayer = name;
            currentState = MainMenu;
        } else {
            System.out.println("That user does not exists!");
            currentState = StartMenu;
        }

    }

    //Settings menu
    private void settings() {
        do {
            Menu.settings();
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    changeKeySetting();
                    running = false;
                    break;
                case "2":
                    HandleInput.getExceptionLog().printErrors();
                    Menu.settings();
                    running = false;
                    break;
                case "9":
                    running = false;
                    break;
                default:
                    Menu.incorrectInput();
                    running = true;
                    break;
            }
        } while (running);
    }

    private void aboutMenu() {
        Menu.aboutMenu();
        choice = HandleInput.checkInput(gameInput.nextLine(), true);
        do {
            switch (choice) {
                case "1":
                    About.printAbout();
                    running = false;
                    System.out.println("Press Enter to  continue..");
                    gameInput.nextLine();
                    break;
                case "2":
                    About.how_to_play();
                    running = false;
                    System.out.println("Press Enter to  continue..");
                    gameInput.nextLine();
                    break;
                case "3":
                    About.printCredits();
                    running = false;
                    System.out.println("Press Enter to  continue..");
                    gameInput.nextLine();
                    break;
                case "9":
                    running = false;
                    break;
                default:
                    //TODO Error handling
                    break;
            }
        } while (running);
    }

    //Change the keys used during game play
    private void changeKeySetting() {
        String keyToBind;
        do {
            menu.changeKeyBindings();
            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setNorthKey(keyToBind);
                    }
                    running = true;
                    break;
                case "2":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setSouthKey(keyToBind);
                    }
                    running = true;
                    break;
                case "3":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setWestKey(keyToBind);
                    }
                    running = true;
                    break;
                case "4":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setEastKey(keyToBind);
                    }
                    running = true;
                    break;
                case "5":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setOpenInventory(keyToBind);
                    }
                    running = true;
                    break;
                case "6":
                    System.out.println("Press a key and hit enter");
                    keyToBind = HandleInput.checkInput(gameInput.nextLine(), false);
                    if (checkIfKeyIsBound(keyToBind)) {
                        keybind.setOpenMap(keyToBind);
                    }
                case "9":
                    settings();
                    running = false;
                    break;
                default:
                    Menu.incorrectInput();
                    running = true;
                    break;
            }
        } while (running);
    }

    //Check if the key is already bound to something else
    private boolean checkIfKeyIsBound(String key) {
        key = key.toUpperCase();
        boolean checkKey = false;
        for (int i = 0; i < keybind.getKeybinds().size(); i++) {
            if (key.equals(keybind.getKeybinds().get(i))) {
                checkKey = true;
                System.out.println("(" + keybind.getKeybinds().get(i) + ") is already bound");
                break;
            }
        }
        return !checkKey;
    }

    private boolean checkIfPlayerIsReady() {
        return player != null;
    }

    private void resetCurrentGame() {
        world = null;
        monsterLogic = null;
        gameTurn = 0;
        monsterKills = 0;
    }
    /*----------------Player interaction end----------------*/

    /*------------------Hero interaction--------------------*/

    //Moves the player to the next room according to the action given
    private boolean heroAction(String action, Player player) {
        boolean movedHero = false;
        action = action.toUpperCase();
        //In each case we check if the player is out of bounds or not
        if (action.equals(keybind.getNorthKey())) {
            if ((player.getHero().getPosY() - 1) < 0) {
                Menu.directionHasNoDoor();
            } else {
                player.getHero().setPosY(player.getHero().getPosY() - 1);
                movedHero = true;
            }
        } else if (action.equals(keybind.getSouthKey())) {
            if ((player.getHero().getPosY() + 1) > (world.getWorld().length - 1)) {
                Menu.directionHasNoDoor();
            } else {
                player.getHero().setPosY(player.getHero().getPosY() + 1);
                movedHero = true;
            }
        } else if (action.equals(keybind.getWestKey())) {
            if (player.getHero().getPosX() - 1 < 0) {
                Menu.directionHasNoDoor();
            } else {
                player.getHero().setPosX(player.getHero().getPosX() - 1);
                movedHero = true;
            }
        } else if (action.equals(keybind.getEastKey())) {
            if (player.getHero().getPosX() + 1 > (world.getWorld().length - 1)) {
                Menu.directionHasNoDoor();
            } else {
                player.getHero().setPosX(player.getHero().getPosX() + 1);
                movedHero = true;
            }
        } else if (action.equals(keybind.getOpenInventory())) {
            Menu.openInventory(player);
            System.out.println("* 1) Use item");
            System.out.println("* 2) Remove item");
            System.out.println("* 9) Back to game");

            choice = HandleInput.checkInput(gameInput.nextLine(), true);
            switch (choice) {
                case "1":
                    System.out.println("* Which item would you like to use?");
                    choice = HandleInput.checkInput(gameInput.nextLine(), true);
                    player.getHero().getInventory().getItem(Integer.parseInt(choice), player);
                    break;
                case "2":
                    System.out.println("* Which item would you like to remove?");
                    choice = HandleInput.checkInput(gameInput.nextLine(), true);
                    player.getHero().getInventory().removeItem(Integer.parseInt(choice));
                    break;
                case "9":
                    break;
                default:
                    Menu.incorrectInput();
                    break;
            }
            movedHero = false;
        } else if (action.equals(keybind.getOpenHeroStatus())) {
            Menu.openHeroStatus(player);
            movedHero = false;
        } else if (action.equals(keybind.getOpenMap())) {
            Menu.openFogMap(world, player);
        } else if (action.equals(keybind.getOpenMenu())) {
            currentState = InGameMenu;
        } else if (action.equals(keybind.getOpenDevelopmentMap())){
            Menu.openDevelopmentMap(world, player);
        }
        return movedHero;
    }

    /*----------------Hero interaction end------------------*/

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
