package com.example.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.xing.model")
@EnableJpaRepositories(value = "com.example.xing.dao")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
