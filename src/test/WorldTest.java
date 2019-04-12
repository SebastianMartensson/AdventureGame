/*
package test;

import controller.Menu;
import controller.Player;
import controller.world.World;
import creature.Warrior;
import item.weapon.club.Club;


public class WorldTest {
    //Test variables
    //Use this when need of a player 
    private Player testPlayer = new Player("PlayerTestName", new Warrior("TestHero", 35, 12, 3, -1, -2, 1, 0,0 , 0, 0, new Club("Wooden Club", 0,2,0,true)));
    //The world object
    private World world = new World(testPlayer);


    public static void main(String[] args) {
        WorldTest worldTest = new WorldTest();
        worldTest.printRooms();
        //worldTest.printMonster();
        //worldTest.printItem();
    }

    //Print the all the rooms in the world
    private void printRooms() {
        Menu.openDevelopmentMap(world, testPlayer);
    }

    //Print all the rooms and if there is a monster print it as well
    private void printMonster() {
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (world.getWorld()[y][x].isHasMonster()) {
                    System.out.print("[" + world.getWorld()[y][x].getMonster().getName() + "]");
                } else {
                    System.out.print("[      ]");
                }
            }
            System.out.println();
        }
    }

    //Print all the room and if there is an item print it as well
    private void printItem() {
        for (int y = 0; y < world.getWorld().length; y++) {
            for (int x = 0; x < world.getWorld().length; x++) {
                if (world.getWorld()[y][x].isHasItem()) {
                    System.out.print("[" + world.getWorld()[y][x].getItem().getName() + "]");
                } else {
                    System.out.print("[      ]");
                }
            }
            System.out.println();
        }
    }
    private void playerInventory (){

        for (int i = 0; i <testPlayer.getHero().getInventory().getInventoryList().length; i++) {
            System.out.println(testPlayer.getHero().getInventory().getInventoryList()[i]);

        }
    }
}

*/