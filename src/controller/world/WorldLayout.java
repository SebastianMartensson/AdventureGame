package controller.world;

import java.io.Serializable;
import java.security.SecureRandom;

/*
  -----------------------------------------
  DO NOT PRESS CTRL + ALT + L IN THIS CLASS
  -----------------------------------------
*/
public class WorldLayout implements Serializable {
    
    //This is a fixed layout of the world
    private final int[][] WORLD_LAYOUT =
            //0  = Starting room
            //1  = Gas room
            //2  = Rally to war room
            //3  = Holy room
            //4  = Desert room
            //5  = Foggy room
            //6  = Slaughter room
            //7  = Cursed room
            //8  = Fire room
            //9  = Agility room
            //10 = Boss room
            //11 = Generic room 1
            //12 = Generic room 2
            //13 = Generic room 3
            //14 = Generic room 4
            //15 = Generic room 5
            //16 = Monster Guard Boss room
            {       //Each number corresponds to a Room
                    { 0,  2,  5,  1, 14, 15,   3, 11, 12},
                    {13,  1, 15, 11, 12,  3,  11, 13, 11},
                    { 9, 13,  3, 14,  8, 13,   8, 14, 15},
                    {13,  2, 11,  4,  16, 7,  11,  7,  4},
                    {15, 12, 15,  16, 10,16,   2, 13,  8},
                    { 2, 13,  5,  8,  16, 3,  15,  4, 13},
                    { 8, 14, 13, 11,  9, 11,   8, 14,  5},
                    { 1,  4, 15,  3, 13, 12,   3,  9,  4},
                    {13, 15,  8,  3, 12, 15,  11,  3, 13}

            };

    public int[][] getWorldLayout() {
        return WORLD_LAYOUT;
    }

    private final int[][] WORLD_DOOR_PLACEMENT =
            //0 = No doors
            //1 = Three doors - south, west and east
            //2 = Three doors - north, east and south
            //3 = Three doors - north, west and south
            //4 = Four doors
            //5 = Three door - north, east and west
            //9 = Boss room
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 9, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
            };
            
            /*{
                    {0, 1, 0, 1, 0, 1, 0, 1, 0},
                    {2, 0, 4, 0, 4, 0, 4, 0, 3},
                    {0, 4, 0, 4, 0, 4, 0, 4, 0},
                    {2, 0, 4, 0, 5, 0, 4, 0, 3},
                    {0, 4, 0, 3, 9, 2, 0, 4, 0},
                    {2, 0, 4, 0, 1, 0, 4, 0, 3},
                    {0, 4, 0, 4, 0, 4, 0, 4, 0},
                    {2, 0, 4, 0, 4, 0, 4, 0, 3},
                    {0, 5, 0, 5, 0, 5, 0, 5, 0}
            };*/

    public int[][] getWorldDoorPlacement() {
        return WORLD_DOOR_PLACEMENT;
    }
    
    private final int[][] WORLD_MONSTER_PLACEMENT =
            //0 No monster
            //1 Spider
            //2 Goblin
            //3 Ghoul
            //4 Orc
            //5 Ogre
            {
                    {0  , 0  , r(), r(), r(), r(), r(), r(), r()},
                    {0  , r(), r(), r(), r(), r(), r(), r(), r()},
                    {r(), r(), r(), r(), r(), r(), r(), r(), r()},
                    {r(), r(), r(), r(), 3  , r(), r(), r(), r()},
                    {r(), r(), r(), 4  , 5  , 4  , r(), r(), r()},
                    {r(), r(), r(), r(), 3  , r(), r(), r(), r()},
                    {r(), r(), r(), r(), r(), r(), r(), r(), r()},
                    {r(), r(), r(), r(), r(), r(), r(), r(), r()},
                    {r(), r(), r(), r(), r(), r(), r(), r(), r()},
            };

    public int[][] getWORLD_MONSTER_PLACEMENT() {
        return WORLD_MONSTER_PLACEMENT;
    }
    
    private int r(){
        SecureRandom random = new SecureRandom();
        int randomMonster;
        if (random.nextBoolean()){
            randomMonster = random.nextInt(5);
        }else {
            randomMonster = 0;
        }
        return randomMonster;
    }
}
