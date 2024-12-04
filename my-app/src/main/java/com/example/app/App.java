package com.example.app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        SpringApplication.run(App.class, args);
    }
}
