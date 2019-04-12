package controller.file_handling;

import controller.Player;
import controller.State;
import controller.input_handling.Log;
import controller.monster_logic.MonsterLogic;
import controller.world.World;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save {
    /*
    The following three objects needs to be sent as parameters to the SavedGame object:
    1. Player
    2. World
    3. State
    Saving these three probably limits the feature to not be able to save whilst fighting.
     */

    //Saves a SavedGame object to a file 
    public static void saveGame(Player player, World world, State state, MonsterLogic monsterLogic) {
        FileOutputStream fileOutput = null;
        ObjectOutputStream objectOutput = null;
        SavedGame currentSave = null;

        try {
            currentSave = new SavedGame(player, world, monsterLogic);
            File file = new File("src/controller/file_handling/saved_games/" + player.getName() + ".ser");
            // If the file does not exists, create a new file
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutput = new FileOutputStream(file, false);
            objectOutput = new ObjectOutputStream(fileOutput);
            //Write the object to file
            objectOutput.writeObject(currentSave);
        } catch (IOException e) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            Log.addError(String.valueOf(e));
        } finally {
            try {
                if (objectOutput != null) {
                    objectOutput.close();
                }
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e) {
                Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
                Log.addError(String.valueOf(e));
            }
        }


    }
}
