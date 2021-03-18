package com.rjonnada.util;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class KeyTool {
    private static byte[] key;

    public static SecretKeySpec getSecretKey(String personalKey) {
        MessageDigest messageDigestSHA = null;
        try {
            key = personalKey.getBytes("UTF-8");
            messageDigestSHA = MessageDigest.getInstance("SHA-1");
            key = messageDigestSHA.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
