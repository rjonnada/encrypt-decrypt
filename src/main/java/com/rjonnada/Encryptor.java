package com.rjonnada;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryptor {
    public static String encrypt(String password, String personalKey) {
        try {
            SecretKeySpec secretKeySpec = KeyTool.getSecretKey(personalKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String encryptedPassword = encrypt("helloWorld", "myPersonalKey");
        System.out.println("Encrypted Password: " + encryptedPassword);
    }

}
