package org.example.rle2;

import java.util.Scanner;

public class RLE2 {
    public static String compress(String txt) {
        StringBuilder res = new StringBuilder();
        int len = txt.length();
        int i = 0;
        while (i < len - 1) {
            int start = i;
            boolean repetitive = false;
            if (i < len - 1 && txt.charAt(i + 1) == txt.charAt(start)) {
                repetitive = true;
                while (i < len && txt.charAt(i) == txt.charAt(start)) {
                    ++i;
                }
            } else {
                if (i < len - 1 && txt.charAt(i + 1) != txt.charAt(i)) {
                    while (i < len - 1 && txt.charAt(i) != txt.charAt(i + 1)) {
                        ++i;
                    }
                }
            }

            int count = i - start;
            if (repetitive) {
                count = count | 0x80;
                char c = (char) count;
                res.append(c);
                res.append(txt.charAt(start));
            } else {
                res.append((char) count);
                for (int j = start; j < i; ++j) {
                    res.append(txt.charAt(j));
                }
            }
        }

        return res.toString();
    }

    public static String decompress(String compressed) {
        StringBuilder decompressed = new StringBuilder();
        int len = compressed.length();
        int i = 0;
        while (i < len) {
            int count = compressed.charAt(i);
            char c = compressed.charAt(i + 1);
            boolean repetitive = (count & 0x80) != 0;
            if (repetitive) {
                count = count ^ 0x80;
                for (int j = 0; j < count; ++j) {
                    decompressed.append(c);
                }
                i += 2;
            } else {
                for (int j = 0; j < count; ++j) {
                    decompressed.append(compressed.charAt(i + 1));
                    ++i;
                }
                i++;
            }
        }

        return decompressed.toString();
    }

    public static void main(String[] args) {
        System.out.println("Input text:  ");
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        String compressed = compress(txt);
        System.out.println(txt);
        System.out.println(compressed);

        String decompressed = decompress(compressed);
        System.out.println(decompressed);
    }
}

