package org.example.cipher;

public interface Cipher {

    byte[] encrypt(String text, int key);
    String decrypt(byte[] byteArray, int key);

}

