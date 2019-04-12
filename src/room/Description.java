package room;


import java.io.Serializable;

public class Description implements Serializable {
    //Starting room
    public static final String STARTING_ROOM_DESCRIPTION = "This is were you first enter the dungeon.\n" +
            "With the only knowable entry blocked there is only one way to go.\n";
    
    //Special rooms
    public static final String GAS_ROOM_DESCRIPTION = "You enter a room filled with deadly gas." +
            " In this room you lose 1 hp if you don't have a protective potion to counter the effects of the poisonous gas.";
    public static final String RALLY_TO_WAR_ROOM_DESCRIPTION = "As you enter this room you hear distant screams from orcs and humans who is rallying to war.\n" +
            "You feel your blood pumping as you ready yourself for battle. your attack power increase by +1."; //hit power
    public static final String HOLY_ROOM_DESCRIPTION = "You enter a strange room that has a light beam shining at an altar. There is no monsters in sight.\n" +
            "You have entered a holy room and you find yourself at ease. You  rest up for a while, you gain +8 HP.";
    public static final String DESERT_ROOM_DESCRIPTION = " You enter a room covered with sand. As you enter you notice that the sand starts to sink." +
            "You watch your steps as the quicksand will drag u in if you are not careful. The monster gains 5+ initiative.";
    public static final String FOGGY_ROOM_DESCRIPTION_ROOM_DESCRIPTION = "You enter a foggy room, your vision is partly blurred. It’s hard to locate the enemy." + "\n" +
            " The enemy depends on his hearing to find you as the fog does not bother him. Monster +5 hit.";
    public static final String SLAUGHTER_ROOM_DESCRIPTION = "You enter a slaughter room. This room is filled with dismembered bodies of previous heroes.\n" +
            "The sight frightens you as you notice there is a enemy hiding in the room, waiting to slaughter you. Your attack power decrease by 2  and enemy starts attacking.";
    public static final String CURSED_ROOM_DESCRIPTION = "You enter a room that is filled with ocult symbols and the walls are covered in blood. This room curses you\n" +
            "You can now only deal half of your damage to the enemy.";
    public static final String FIRE_ROOM_DESCRIPTION = "You enter a boiler room with lit ovens. The fire from the ovens spews out, burning you.\n" +
            "you lose 1 hp each turn ";
    public static final String AGILITY_ROOM_DESCRIPTION = "You enter a room with a opening in the roof. The natural winds of  Northrend blesses your armour. you gain +2 armour.";
    public static final String BOSS_ROOM_DESCRIPTION = "As you enter you find yourself in a dark room. On the other end of the room\n" +
            "you see a entrance to a cave. Out from the cave you notice a giant figure approaching you. The door behind u slams shut.\n" +
            "Out from the cave you see a giant ogre carrying a spiked club,\n" +
            "in the other hand he carries dismembered bodies that he is consuming.\n" +
            "As he approaches you get ready for the battle.";

    //Generic rooms
    public static final String GEN1_ROOM_DESCRIPTION = "You enter a dusty room covering the floors.\n" +
            "There is spider webs everywhere, somehow the walls and floor looks clean.\n" +
            "There might be crawling enemies close";
    public static final String GEN2_ROOM_DESCRIPTION = "You enter a dark shallow room, you can't see then other end of the room.";
    public static final String GEN3_ROOM_DESCRIPTION = "You enter a dark room with a blood pool on the floor.";
    public static final String GEN4_ROOM_DESCRIPTION = "You enter a room that is covered in mirrors, in every direction you see yourself.";
    public static final String GEN5_ROOM_DESCRIPTION = "You enter a room that is filled with strange statues.";
    public static final String GUARD_ROOM_DESCRIPTION = "You enter a room that that is like a guarding hall where a monster is guarding before a big enemy.";


}
