package com.java8.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class HmacGenerator {
    MessageDigest digest;
    String accID;
    String tenantID;
    String publicKey;
    String privateKey;
    Mac sha256_Hmac;

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HmacGenerator hmacGenerator = new HmacGenerator();

        //String token = hmacGenerator.createToken("");

        System.out.println(new Date().getTime()/1000);

        //System.out.println("Token = " + token);
    }

    public HmacGenerator() throws NoSuchAlgorithmException {
        //accID = "782f1b71-7ca4-4465-917f-68d58ffbec8b ";
        //tenantID = "6423ae63-59b6-4986-a949-c910ac622471";
        publicKey = "dfc168e9-7e6b-4318-a169-fb068208f14e";
        privateKey = "sUBlS5Te08jX3NTS7/m0VPhk4Fh4bqiAUi7ZkmLHlao=";
        digest = MessageDigest.getInstance("SHA-256");
        sha256_Hmac = Mac.getInstance("HmacSHA256");
    }

    String createHashBody(String msg, MessageDigest digest) {
        if (msg.isEmpty()) {
            return msg;
        }
        byte[] bodyBytes;
        try {
            bodyBytes = msg.getBytes("utf-8");
            byte[] hashedMsg = digest.digest(bodyBytes);
            return Base64.getEncoder().encodeToString(hashedMsg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    String createSignature(String privatekey, String toBeSigned, Mac sha256_Hmac) throws UnsupportedEncodingException {

        try {
            byte[] keyByte = Base64.getDecoder().decode(privatekey);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, "HmacSHA256");
            sha256_Hmac.init(secretKeySpec);
            byte[] message = toBeSigned.getBytes("utf-8");
            byte[] hashmsg = sha256_Hmac.doFinal(message);
            String signedSigniture = Base64.getEncoder().encodeToString(hashmsg);

            return signedSigniture;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String createToken(String body) throws UnsupportedEncodingException {
        long seconds = System.currentTimeMillis() / 1000l;
        String nonce = (String.valueOf(seconds));
        String hashedBody = createHashBody(body, digest);
        String toBeSigned = String.format("%s:%s:%s:%s", publicKey, nonce, seconds, hashedBody);
        String signedSigniture = createSignature(privateKey, toBeSigned, sha256_Hmac);
        String token = String.format("hmac %s:%s:%s:%s", publicKey, nonce, seconds, signedSigniture);
        System.out.println("Token: " + token);
        return token;

    }
}