package org.example.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Accessors(chain = true)
@Data
@Configuration
@ConfigurationProperties(prefix = "aes")
public class AESConfig {
    @Value("${aes.secret-key}")
    private String secretKey;
    @Value("${aes.init-vector}")
    private String initVector;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getInitVector() {
        return initVector;
    }

    public void setInitVector(String initVector) {
        this.initVector = initVector;
    }

    public AESConfig(@Value("${aes.secret-key}") String secretKey, @Value("${aes.init-vector}") String initVector) {
        this.secretKey = secretKey;
        this.initVector = initVector;
    }
}
