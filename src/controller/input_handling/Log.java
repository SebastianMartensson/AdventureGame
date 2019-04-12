package controller.input_handling;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Saves each exception to a log and prints the exception back to the user
 */

public class Log {
    private static final String ERRORFILE = "src/controller/input_handling/errorlog.txt";
    private ArrayList<String> exceptions;

    public Log() {
        exceptions = new ArrayList<>();
    }

    //Add new exception
    public static void addError(String exception) {
        writeToFile("Incorrect format: " + exception);
        System.out.println("* " + exception + " is incorrect. Try again");
    }

    public void printErrors() {
        readFileToArray();
        for (int i = 0; i < exceptions.size(); i++) {
            System.out.println("[" + i + "] " + exceptions.get(i));
        }
    }

    //Write the exception given from the HandleInput class to a text file
    private static void writeToFile(String exception) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(ERRORFILE, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(exception);
            bufferedWriter.newLine();
        } catch (IOException e) {
            Logger.getLogger(Log.class.getSimpleName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            addError(String.valueOf(e));
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
                addError(String.valueOf(ex));
            }
        }
    }

    private void readFileToArray() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(ERRORFILE);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                exceptions.add(currentLine);
            }
        } catch (IOException e) {
            Logger.getLogger(Log.class.getSimpleName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            addError(String.valueOf(e));
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getSimpleName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                addError(String.valueOf(ex));
            }
        }
    }

    public void clearLog() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(ERRORFILE);
            printWriter.write("");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}
