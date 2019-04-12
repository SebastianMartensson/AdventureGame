package controller.file_handling;

import controller.Player;
import controller.input_handling.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Load {

    public static SavedGame loadGameFromFile(String loggedInPlayer) {
        FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;
        SavedGame savedGame = null;
        if (checkIfFileExists("src/controller/file_handling/saved_games/" + loggedInPlayer + ".ser")) {
            try {
                fileInput = new FileInputStream("src/controller/file_handling/saved_games/" + loggedInPlayer + ".ser");
                objectInput = new ObjectInputStream(fileInput);
                savedGame = (SavedGame) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
                Log.addError(String.valueOf(e));
            } finally {
                try {
                    if (fileInput != null) {
                        fileInput.close();
                    }
                    if (objectInput != null) {
                        objectInput.close();
                    }
                } catch (IOException e) {
                    Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                    Log.addError(String.valueOf(e));
                }
            }
        } else {
            System.out.println("A saved game for that player does not exists");
        }
        return savedGame;
    }

    private static boolean checkIfFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

}
