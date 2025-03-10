package com.jellycheng.javasupport.utils;

import java.util.Base64;
import java.security.SecureRandom;
public class GenerateSecretKey {
    public static String randomStr2base64(){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        return encodedKey;
    }
}
