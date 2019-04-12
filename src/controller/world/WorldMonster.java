package controller.world;

import creature.*;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;

public class WorldMonster implements Serializable {
    private ArrayList<Monster> smallMonsters = new ArrayList<>();
    private ArrayList<Monster> mediumMonsters = new ArrayList<>();
    private Monster boss;

    //Constructor- add monsters to arraylist when object is created
    public WorldMonster() {
        smallMonsters.add(new Goblin("Goblin", 10, 10, 2, 4, 3, 50, "A small ugly green humanoid creature is visible, with a small sword. It´s a hideously Goblin!"));
        smallMonsters.add(new Spider("Spider", 7, 4, 2, 4, 6, 15, "A bigger Spider crawling around in the dark!"));
        mediumMonsters.add(new Orc("Orc", 20, 13, 3, 5, 2, 100, "Bigger then you, green and armed like yourself, and deadly. It´s an orc!"));
        mediumMonsters.add(new Ghoul("Ghoul", 35, 11, 2, 2, 0, 200, "Grunting in the dark, tearing the flesh of a human remains with it´s teeth. It´s fearsome flesh eating ghoul"));
        //Add boss to room ten
        this.boss = new Ogre("Ogre", 100, 11, 4, 6, 1, 450, "");
    }

    public ArrayList<Monster> getSmallMonsters() {
        return smallMonsters;
    }

    public ArrayList<Monster> getMediumMonsters() {
        return mediumMonsters;
    }

    public Monster getBoss() {
        return boss;
    }

    //Return a random monster from the ArrayList of monsters
    public Monster getRandomSmallMonster() {
        SecureRandom random = new SecureRandom();
        int getRandomMonster = random.nextInt(smallMonsters.size());
        return smallMonsters.get(getRandomMonster);
    }

    public Monster getRandomMediumMonster() {
        SecureRandom random = new SecureRandom();
        int getRandomMonster = random.nextInt(mediumMonsters.size());
        return mediumMonsters.get(getRandomMonster);
    }
}
