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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public AESConfig(@Value("${aes.secret-key}") String secretKey) {
        this.secretKey = secretKey;
    }
}
