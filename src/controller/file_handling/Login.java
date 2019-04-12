package controller.file_handling;

import controller.Player;
import controller.input_handling.Log;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    public static void addPlayer(Player player) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("src/controller/file_handling/files/players.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(player.getName());
            bufferedWriter.newLine();
        } catch (
                IOException e) {
            Logger.getLogger(Log.class.getSimpleName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            Log.addError(String.valueOf(e));
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getSimpleName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                Log.addError(String.valueOf(ex));
            }
        }
    }

    public static boolean loginPlayer(String playerName) {
        
        boolean playerLoggedIn = false;
        try (Scanner scanner = new Scanner(new File("src/controller/file_handling/files/players.txt"))) {
            while (scanner.hasNext()) {
                String loginName = scanner.nextLine();
                if (loginName.equals(playerName)) {
                    playerLoggedIn = true;
                    scanner.close();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            Log.addError(String.valueOf(e));
        }
        return playerLoggedIn;
    }
}
