package controller.file_handling;

import controller.Player;
import controller.State;
import controller.monster_logic.MonsterLogic;
import controller.world.World;

import java.io.Serializable;

/*
This class take the three nessecary objects to save the game and then load it.
The object created of this class will then be saved to a file.
 */
public class SavedGame implements Serializable {
    private Player player;
    private World world;
    private MonsterLogic monsterLogic;
    
    public SavedGame(Player player, World world, MonsterLogic monsterLogic){
        this.player = player;
        this.world = world;
        this.monsterLogic = monsterLogic;
    }

    public MonsterLogic getMonsterLogic() {
        return monsterLogic;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }
    
}
