package com.vdobrikov.training.mdclogtraining;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebFacade {

    public static void main(String[] args) {
        SpringApplication.run(WebFacade.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
