package com.vdobrikov.training.restservice;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NameService {
    private final Faker faker = new Faker();

    public String getName() {
        String name = faker.lordOfTheRings().character();

        log.info("New name='{}'", name);

        return name;
    }
}
