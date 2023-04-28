package org.example.config;

import lombok.Data;

import lombok.experimental.Accessors;
import org.example.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Accessors(chain = true)
@Data
@Configuration
@ConfigurationProperties(prefix = "key.content")
public class KeyConfig {

    private static final KeyFactory KEY_FACTORY;

    @Value("${key.content.public-key-string}")
    private String publicKeyStr;
    @Value("${key.content.private-key-string}")
    private String privateKeyStr;
    private PublicKey pwdPublicKey;
    private PrivateKey pwdPrivateKey;

    static {
        try {
            KEY_FACTORY = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize RSA KeyFactory", e);
        }
    }

    public PublicKey getPwdPublicKey() {
        if (pwdPublicKey == null) {
            try {
                pwdPublicKey = getPublicKey(publicKeyStr);
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException("Failed to generate PublicKey from the provided key", e);
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }
        return pwdPublicKey;
    }

    public PrivateKey getPwdPrivateKey() {
        if (pwdPrivateKey == null) {
            try {
                pwdPrivateKey = getPrivateKey(privateKeyStr);
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException("Failed to generate PrivateKey from the provided key", e);
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }
        return pwdPrivateKey;
    }

    private PublicKey getPublicKey(String pubKey) throws InvalidKeySpecException, MyException {
        if (pubKey == null) {
            throw new MyException("publicKey is null");
        }
        byte[] bytes = Base64.getDecoder().decode(pubKey.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        return KEY_FACTORY.generatePublic(spec);
    }

    private PrivateKey getPrivateKey(String privateKey) throws InvalidKeySpecException, MyException {
        if (privateKey == null) {
            throw new MyException("privateKey is null");
        }
        byte[] bytes = Base64.getDecoder().decode(privateKey.getBytes(StandardCharsets.UTF_8));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        return KEY_FACTORY.generatePrivate(spec);
    }
}
