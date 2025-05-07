package org.example.gamedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GameDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameDemoApplication.class, args);
    }
}
