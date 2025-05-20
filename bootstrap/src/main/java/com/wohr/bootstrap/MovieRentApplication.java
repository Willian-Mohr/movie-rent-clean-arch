package com.wohr.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.wohr")
@EnableJpaRepositories(basePackages = "com.wohr.infrastructure.persistence")
@EntityScan(basePackages = "com.wohr.infrastructure.models")
public class MovieRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentApplication.class, args);
    }
}