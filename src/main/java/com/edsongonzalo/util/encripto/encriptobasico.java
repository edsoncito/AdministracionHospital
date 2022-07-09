package com.edsongonzalo.util.encripto;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class encriptobasico implements encriptor {

    @Override
    public String encriptarBasico(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    // @Override
    // public String desencriptar(String stringAEncriptar) {
    //     try {
    //         MessageDigest msgd = MessageDigest.getInstance("MD5");
    //         byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
    //         StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
    //         for (int i = 0; i < bytes.length; i++) {
    //             int bajo = (int) (bytes[i] & 0x0f);
    //             int alto = (int) ((bytes[i] & 0xf0) >> 4);
    //             strbCadenaMD5.append(CONSTS_HEX[alto]);
    //             strbCadenaMD5.append(CONSTS_HEX[bajo]);
    //         }
    //         return strbCadenaMD5.toString();
    //     } catch (NoSuchAlgorithmException e) {
    //         return null;
    //     }   
    //}

}
