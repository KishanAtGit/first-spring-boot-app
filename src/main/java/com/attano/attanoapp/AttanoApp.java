package com.attano.attanoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AttanoApp {

    @Value("${spring.datasource.url:default_url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(AttanoApp.class, args);
    }

    @Bean
    public CommandLineRunner testEnvConfig() {
        return args -> {
            System.out.println("Database URL from environment: " + dbUrl);
        };
    }
}