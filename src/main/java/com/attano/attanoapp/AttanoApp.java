package com.attano.attanoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AttanoApp {

    @Value("${spring.datasource.url:default_url}")
    private String dbUrl;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AttanoApp.class, args);

        if (context instanceof WebServerApplicationContext) {
            int port = ((WebServerApplicationContext) context).getWebServer().getPort();
            System.out.println("Application started on port: " + port);
        }

    }

    @Bean
    public CommandLineRunner testEnvConfig() {
        return args -> {
            System.out.println("Database URL from environment: " + dbUrl);
        };
    }
}