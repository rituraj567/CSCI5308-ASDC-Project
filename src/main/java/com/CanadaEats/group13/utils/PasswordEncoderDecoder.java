package com.CanadaEats.group13.utils;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class PasswordEncoderDecoder {

    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private static final String UNICODE_FORMAT = "UTF8";
    private static PasswordEncoderDecoder passwordEncoderDecoder;
    byte[] arrayBytes;
    SecretKey key;
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    private String myEncryptionKey;
    private String myEncryptionScheme;

    private PasswordEncoderDecoder() {
        myEncryptionKey = ApplicationConstants.ENCRYPTION_KEY;
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        try {
            arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = skf.generateSecret(ks);
        } catch (Exception ex) {
            System.out.println("Exception occured in PasswordEncoderDecoder");
        }
    }

    public static PasswordEncoderDecoder getInstance() {
        if (passwordEncoderDecoder == null) {
            passwordEncoderDecoder = new PasswordEncoderDecoder();
        }
        return passwordEncoderDecoder;
    }

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
}
