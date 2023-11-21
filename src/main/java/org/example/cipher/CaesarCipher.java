package org.example.cipher;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher implements Cipher{
    @Override
    public byte[] encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            result.append(ch);
        }

        return result.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String decrypt(byte[] byteArray, int key) {
        String text = Arrays.toString(byteArray);

        return Arrays.toString(encrypt(text, 26 - key));
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("Input text");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println("Input key");
        int key = scanner.nextInt();
        CaesarCipher cc = new CaesarCipher();
        String result = new String(cc.encrypt(text,key), StandardCharsets.UTF_8);
//        String result = Arrays.toString(cc.encrypt(text, key));
        System.out.println("Encrypt text: " + result);
        System.out.println("If you want decrypt, input: yes either exit:");
        text = scanner.next();
        if (text.equalsIgnoreCase("yes")){
            System.out.println("Decrypt text: " + cc.decrypt(result.getBytes(StandardCharsets.UTF_8), key));
        }
    }
}
