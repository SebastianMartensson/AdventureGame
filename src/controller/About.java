
package controller;

import java.io.*;

import static controller.input_handling.Log.addError;

public class About {

    //This method shall print about.txt
    public static void printAbout() {

//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
        try {
            //Create new objects and read the file here
            BufferedReader reader = new BufferedReader(new FileReader("src/controller/file_handling/about/about.txt"));
            System.out.println();
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
            System.out.println();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
            //Do something useful with the caught exception
        }
            //Close readers
    }
  
    //This method shall print credits.txt Sebastian N
    public static void printCredits() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/controller/file_handling/about/credits.txt"));
            System.out.println();
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This method shall print how_to_play.txt
    public static void how_to_play() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            //Create new objects and read the file here
            fileReader = new FileReader("src/controller/file_handling/about/how_to_play.txt");
            bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            //print error and sending it to Errorlog
            e.printStackTrace();
            addError(String.valueOf(e));

        } finally {
            //Close readers
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e){
                e.printStackTrace();
                addError(String.valueOf(e));
                }
            }
        }
    }
