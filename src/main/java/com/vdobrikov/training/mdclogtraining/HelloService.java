package com.vdobrikov.training.mdclogtraining;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HelloService {
    private final Faker faker;
    public String getHelloResponse() {
        String name = faker.lordOfTheRings().character();

        log.info("New name='{}'", name);

        return "Hello from " + name;
    }
}
