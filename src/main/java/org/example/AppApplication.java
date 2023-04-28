package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.config.KeyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties({KeyConfig.class})
@SpringBootApplication
@EnableScheduling
@Slf4j
@MapperScan(basePackages = "org.example.mapper")
public class AppApplication {
  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
    log.info("Project initiation....................");
  }
}