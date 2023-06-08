package org.example;

import org.example.config.KeyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties({KeyConfig.class})
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "org.example.mapper")
public class AppApplication {
  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }
}