package controller;

import java.io.Serializable;
import java.security.SecureRandom;

public class Dice implements Serializable {

    private static SecureRandom rand = new SecureRandom();

    // Throwing dice 4
    public static int getD4() {
        int d4 = 1 + rand.nextInt(4);
        return d4;
    }

    // Throwing dice 6
    public static int getD6() {
        int d6 = 1 + rand.nextInt(6);
        return d6;
    }

    // Throwing dice 8
    public static int getD8() {
        int d8 = 1 + rand.nextInt(8);
        return d8;
    }

    // Throwing dice 12
    public static int getD12() {
        int d12 = 1 + rand.nextInt(12);
        return d12;
    }

    // Throwing dice 20
    public static int getD20() {
        int d20 = 1 + rand.nextInt(20);
        return d20;
    }

    // Throwing dice 4 TWO TIMES
    public static int getTwoD4() {
        int d4FirstThrow = 1 + rand.nextInt(4);
        int d4SecondThrow = 1 + rand.nextInt(4) + d4FirstThrow;
        return d4SecondThrow;
    }

    // Throwing dice 6 TWO TIMES
    public static int getTwoD6() {
        int d6FirstThrow = 1 + rand.nextInt(6);
        int d6SecondThrow = 1 + rand.nextInt(6) + d6FirstThrow;
        return d6SecondThrow;
    }

    // Throwing dice 8 TWO TIMES
    public static int getTwoD8() {
        int d8FirstThrow = 1 + rand.nextInt(8);
        int d8SecondThrow = 1 + rand.nextInt(8) + d8FirstThrow;
        return d8SecondThrow;
    }


}
