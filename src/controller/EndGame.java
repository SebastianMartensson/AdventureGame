package controller;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EndGame {

    public static void endGame(int monsterKills, Player player, int gameTurn) {
        player.setScore(player.getScore() + (monsterKills * 20) - (gameTurn * 5));
        writeHighScore(monsterKills, player);
        System.out.println();
        System.out.println();
        System.out.println("                     GAME END                      ");
        System.out.println("***************************************************");
        System.out.println("*  Congratulation you have slayed the boss Ogre!   ");
        System.out.println("*    Here is your High Score and monster kills.    ");
        System.out.println("*                                                  ");
        System.out.printf("*\t\t\t%-12s%-10s %-8s\n", "Name:", "Score:", "Kills");
        System.out.printf("*\t\t\t" + "%-12s %-10d%-8d\n", player.getHero().getName(), player.getScore(), monsterKills);
        System.out.println("*                                                  ");
        System.out.println("***************************************************");
        System.out.println("*                 HIGH SCORE top 5                 ");
        System.out.println("*                                                  ");
        System.out.printf("*\t\t\t%-12s%-10s %-8s\n", "Name:", "Score:", "Kills");
        printHighScore();
        System.out.println("*                                                  ");
        System.out.println("***************************************************");
    }
    
    public static void viewHighScore(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("*                 HIGH SCORE top 5                 ");
        System.out.println("*                                                  ");
        System.out.printf("*\t\t\t%-12s%-10s %-8s\n", "Name:", "Score:", "Kills");
        printHighScore();
        System.out.println("*                                                  ");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    private static void printHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/controller/file_handling/files/high_score.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String currentLine = reader.readLine();

            while (currentLine !=null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }

            Collections.sort(lines, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return extractInt(o2) - extractInt(o1);
                }
                int extractInt(String s) {
                    String num = s.replaceAll("\\D", "");
                    // return 0 if no digits found
                    return num.isEmpty() ? 0 : Integer.parseInt(num);
                }
            });

            for(int i = 0; i < 5; i++) {
                System.out.println(lines.get(i));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHighScore(int monsterKills, Player player) {
        try {
            PrintWriter bw = new PrintWriter(new FileWriter("src/controller/file_handling/files/high_score.txt", true));
            bw.printf("*\t\t\t" + "%-12s %-10d%-8d\n", player.getHero().getName(), player.getScore(), monsterKills);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
