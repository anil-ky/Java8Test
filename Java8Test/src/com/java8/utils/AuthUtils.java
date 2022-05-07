package com.java8.utils;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

public class AuthUtils {

    public static void main(String[] args) {
        long timestamp = new Date().getTime();

        System.out.println(timestamp);
        System.out.println(timestamp / 1000);
    }

    public String generateHmac(String publicKey, String privateKey) {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        String bodySignature = "";
        long timestamp = new Date().getTime() / 1000;
        long nonce = System.currentTimeMillis();
        String unsignedSignature = publicKey + ":" + nonce + ":" + timestamp + ":" + bodySignature;

        byte[] utf8Signature = unsignedSignature.getBytes(StandardCharsets.UTF_8);
        byte[] hashedSignature = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, privateKeyBytes).doFinal(utf8Signature);
        String signedSignature = Base64.getEncoder().encodeToString(hashedSignature);// encodeByteToBase64(hashedSignature);


        //String hmac = publicKey + ":" + nonce + ":" + timestamp + ":" + signedSignature;
        String hmac = publicKey.concat(":").concat(String.valueOf(nonce)).concat(":")
                .concat(String.valueOf(timestamp)).concat(":").concat(signedSignature);
        return hmac;
    }

    public byte[] decodeStringToBase64(String string) {
        return Base64.getDecoder().decode(string);
    }

    public String encodeByteToBase64(byte[] byteToEncode) {
        return Base64.getEncoder().encodeToString(byteToEncode);
    }

    public long getTimestamp() {
        return new Date().getTime() / 1000;
    }

    /*public HttpEntity<Object> addHeaderForAccessToken(Object baseDTO, String hmacToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", hmacToken);

        return new HttpEntity(baseDTO, headers);
    }*/
}