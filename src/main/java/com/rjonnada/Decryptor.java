package com.rjonnada;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decryptor {
    public static String decrypt(String encryptedPassword, String personalKey) {
        try {
            SecretKeySpec secretKeySpec = KeyTool.getSecretKey(personalKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String decryptedPassword = decrypt("44KtbWDalzx8zhOkfM6o+A==", "myPersonalKey");
        System.out.println("Decrypted Password: " + decryptedPassword);
    }
}
