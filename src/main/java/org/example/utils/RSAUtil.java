package org.example.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.util.Base64;

public class RSAUtil {
    private static final Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    private RSAUtil() {
    }

    public static String encode(String plantText, PublicKey publicKey) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        int keySize = ((RSAKey) publicKey).getModulus().bitLength() / 8;
        int blockSize = keySize - 11; // 11 bytes of overhead for PKCS1 padding
        byte[] plaintextBytes = plantText.getBytes(StandardCharsets.UTF_8);
        int blocks = (int) Math.ceil((double) plaintextBytes.length / blockSize);
        byte[] ciphertextBytes = new byte[blocks * keySize];
        int index = 0;
        for (int i = 0; i < blocks; i++) {
            int length = Math.min(blockSize, plaintextBytes.length - i * blockSize);
            byte[] block = new byte[length];
            System.arraycopy(plaintextBytes, i * blockSize, block, 0, length);
            byte[] ciphertextBlock;
            try {
                ciphertextBlock = cipher.doFinal(block);
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            }
            System.arraycopy(ciphertextBlock, 0, ciphertextBytes, index, keySize);
            index += keySize;
        }
        return Base64.getEncoder().encodeToString(ciphertextBytes);
    }

    public static String decode(String ciphertext, PrivateKey privateKey) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        int keySize = ((RSAKey) privateKey).getModulus().bitLength() / 8;
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        int blocks = ciphertextBytes.length / keySize;
        ByteBuffer outputBuffer = ByteBuffer.allocate(blocks * keySize);
        for (int i = 0; i < blocks; i++) {
            byte[] block = new byte[keySize];
            System.arraycopy(ciphertextBytes, i * keySize, block, 0, keySize);
            byte[] plaintextBlock;
            try {
                plaintextBlock = cipher.doFinal(block);
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            }
            outputBuffer.put(plaintextBlock);
        }
        outputBuffer.flip();
        byte[] outputBytes = new byte[outputBuffer.remaining()];
        outputBuffer.get(outputBytes);
        return new String(outputBytes, StandardCharsets.UTF_8);
    }
}
