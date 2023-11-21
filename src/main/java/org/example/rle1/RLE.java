package org.example.rle1;

import java.util.Scanner;

public class RLE {
    public String encode(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == prev) {
                count++;
            } else {
                result.append(prev);
                result.append(count);
                count = 1;
                prev = input.charAt(i);
            }
        }

        result.append(prev);
        result.append(count);

        return result.toString();
    }


    public String decode(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i += 2) {
            char c = input.charAt(i);
            int count = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            for (int j = 0; j < count; j++) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RLE rle = new RLE();
        System.out.print("Input text:  ");
        String encoded = rle.encode(scanner.next());
        System.out.println("Encoded: " + encoded);
        System.out.println("If you want decode this text, yes:");
        if (scanner.next().toLowerCase().equals("yes")){
            System.out.println("Decoded: " + rle.decode(encoded));
        }


    }
}

