package com.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.repository")
@EntityScan("com.entity")
public class InsuranceApp {

    public static void main(String[] args) {
        new SpringApplication(InsuranceApp.class).run(args);
    }

}
