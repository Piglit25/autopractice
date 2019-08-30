package utils;

import java.util.Random;

public class DataGenerator {

    private static String getRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sequence = new StringBuilder();
        Random rand = new Random();
        while (sequence.length() < 10) {
            int index = (int) (rand.nextFloat() * chars.length());
            sequence.append(chars.charAt(index));
        }
        return sequence.toString();
    }

    public static String getEmail() {
        return DataGenerator.getRandomString() + "@gmail.com";
    }

}
