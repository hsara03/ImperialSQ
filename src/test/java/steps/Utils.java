package steps;

import java.util.Random;

public class Utils {

    public static String randomPhoneNumber() {
        return "6"+String.valueOf(generateRandomNumber(7));
    }

    public static int generateRandomNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of digits must be greater than 0");
        }

        Random random = new Random();
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n) - 1;

        return random.nextInt(max - min + 1) + min;
    }

    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static String generateRandomEmail() {
        String localPart = Utils.generateRandomString(8); // Change the number to adjust the length of the local part
        String domain = Utils.generateRandomString(8) + ".com"; // Change the number and domain as needed
        return localPart + "@" + domain;
    }
}
