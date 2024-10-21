package com.wallet.service;

import java.security.SecureRandom;

public class RandomStringGen {
    private static  String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static  String NUMBERS = "0123456789";
    private static  SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
    public static String generateNumericRandomString(int length){
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(NUMBERS.length());
            sb.append(NUMBERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
