package controller.world;

import controller.Player;
import creature.*;
import room.*;

import java.io.Serializable;
import java.security.SecureRandom;

public class World implements Serializable {
    private WorldLayout worldLayout = new WorldLayout();
    private WorldItem item = new WorldItem();
    private SecureRandom rand = new SecureRandom();
    private Room room;
    private Room[][] world;
    private Monster[][] monsters;

    public World(Player player) {
        //Create a new world array of rooms
        world = new Room[worldLayout.getWorldLayout().length][worldLayout.getWorldLayout().length];
        //Create a new worldMonster array of monsters
        monsters = new Monster[worldLayout.getWORLD_MONSTER_PLACEMENT().length][worldLayout.getWORLD_MONSTER_PLACEMENT().length];
        //Fill the world with Rooms
        populateWorldWithRooms();
        //Fill the rooms with items
        populateWorldWithItems();
        //Fill the rooms with doors
        populateRoomsWithDoors();
        //Place the hero (player) in the start position and fill the world with monsters
        populateWorldWithMonsters(player);
    }

    //Fill the world array with room according to a predefined world layout
    private void populateWorldWithRooms() {
        for (int y = 0; y < worldLayout.getWorldLayout().length; y++) {
            for (int x = 0; x < worldLayout.getWorldLayout().length; x++) {
                //Switch over the value at each position in the array and insert a room according to the matching case
                switch (worldLayout.getWorldLayout()[y][x]) {
                    case 0:
                        room = new Special("Start", Description.STARTING_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(true);
                        break;
                    case 1:
                        room = new Special("Gas", Description.GAS_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 2:
                        room = new Special("Rally", Description.RALLY_TO_WAR_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 3:
                        room = new Special("Holy", Description.HOLY_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 4:
                        room = new Special("Desert", Description.DESERT_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 5:
                        room = new Special("Foggy", Description.FOGGY_ROOM_DESCRIPTION_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 6:
                        room = new Special("Slaughter", Description.SLAUGHTER_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 7:
                        room = new Special("Cursed", Description.CURSED_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 8:
                        room = new Special("Fire", Description.FIRE_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 9:
                        room = new Special("Agility", Description.AGILITY_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 10:
                        room = new Special("Boss", Description.BOSS_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 11:
                        room = new Generic("Gen1", Description.GEN1_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 12:
                        room = new Generic("Gen2", Description.GEN2_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 13:
                        room = new Generic("Gen3", Description.GEN3_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 14:
                        room = new Generic("Gen4", Description.GEN4_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 15:
                        room = new Generic("Gen5", Description.GEN5_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                    case 16:
                        room = new Generic("Guarding", Description.GUARD_ROOM_DESCRIPTION);
                        world[y][x] = room;
                        room.setVisited(false);
                        break;
                }
            }
        }
    }//populateWorldWithRooms end

    //Adding worldMonster to the world in a randomly controlled way
    private void populateWorldWithMonsters(Player player) {
        Monster monster;
        for (int y = 0; y < worldLayout.getWORLD_MONSTER_PLACEMENT().length; y++) {
            for (int x = 0; x < worldLayout.getWORLD_MONSTER_PLACEMENT().length; x++) {
                switch (worldLayout.getWORLD_MONSTER_PLACEMENT()[y][x]) {
                    case 0:
                        //Insert no worldMonster
                        break;
                    case 1:
                        monster = new Spider("Spider", 7, 4, 2, 4, 6, 15, "A bigger Spider crawling around in the dark!");
                        monster.setPosY(y);
                        monster.setPosX(x);
                        monsters[y][x] = monster;
                        break;
                    case 2:
                        monster = new Goblin("Goblin", 10, 10, 2, 4, 3, 50, "A small ugly green humanoid creature is visible, with a small sword. It´s a hideously Goblin!");
                        monster.setPosY(y);
                        monster.setPosX(x);
                        monsters[y][x] = monster;
                        break;
                    case 3:
                        monster = new Ghoul("Ghoul", 35, 11, 2, 2, 0, 200, "Grunting in the dark, tearing the flesh of a human remains with it´s teeth. It´s fearsome flesh eating ghoul");
                        monster.setPosY(y);
                        monster.setPosX(x);
                        monsters[y][x] = monster;
                        break;
                    case 4:
                        monster = new Orc("Orc", 20, 13, 3, 5, 2, 100, "Bigger then you, green and armed like yourself, and deadly. It´s an orc!");
                        monster.setPosY(y);
                        monster.setPosX(x);
                        monsters[y][x] = monster;
                        break;
                    case 5:
                        monster = new Ogre("Ogre", 100, 11, 4, 6, 1, 450, "");
                        monster.setPosY(y);
                        monster.setPosX(x);
                        monsters[y][x] = monster;
                        break;
                }
            }
        }
    }

    //populate items into world
    private void populateWorldWithItems() {
        //populateWorldWithItems start
        SecureRandom rand = new SecureRandom();
        // Iterate over world layout.
        for (int y = 0; y < worldLayout.getWorldLayout().length; y++) {
            for (int x = 0; x < worldLayout.getWorldLayout().length; x++) {
                //Switch over the value at each position in the array and randomly insert a worldMonster according to the matching case
                //Room 0 is ignored since the Hero starts here.
                switch (worldLayout.getWorldLayout()[y][x]) {
                    case 1:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 2:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 3:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 4:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 5:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 6:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 7:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 8:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 9:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 10:
                        world[y][x].setItem(item.getLargeTreasure());
                        world[y][x].setHasItem(true);
                        break;
                    case 11:
                        world[y][x].setItem(item.getMediumTreasure());
                        world[y][x].setHasItem(true);
                        break;
                    case 12:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 13:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 14:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 15:
                        if (rand.nextBoolean()) {
                            world[y][x].setItem(item.getRandomItem());
                            world[y][x].setHasItem(true);
                        }
                        break;
                    case 16:
                        world[y][x].setItem(item.getMediumTreasure());
                        world[y][x].setHasItem(true);
                }
            }
        }
    }//populateWorldWithItems end

    private void populateRoomsWithDoors() {
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world.length; x++) {
                switch (worldLayout.getWorldDoorPlacement()[y][x]) {
                    case 1:
                        world[y][x].setDoor(new Door(getRandomIsLocked()));
                        break;
                    case 9:
                        world[y][x].setBossDoor(new Door(true));
                        break;
                    default:
                        //TODO Door error handling
                        break;
                }
            }
        }
    }

    private boolean getRandomIsLocked() {
        boolean locked = false;
        if (rand.nextFloat() < 0.25) {
            locked = true;
        }
        return locked;
    }

    public Room[][] getWorld() {
        return world;
    }

    public WorldItem getItem() {
        return item;
    }

    public Monster[][] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[][] monsters) {
        this.monsters = monsters;
    }
}
