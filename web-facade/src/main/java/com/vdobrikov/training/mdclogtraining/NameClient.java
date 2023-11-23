package com.vdobrikov.training.mdclogtraining;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class NameClient {
    @Value("${name-service.endpoint}")
    private String nameServiceEndpoint;

    private final RestTemplate restTemplate;

    public String getName() {
        log.info("Calling name service at '{}'", nameServiceEndpoint);

        return restTemplate.getForObject(nameServiceEndpoint, String.class);
    }
}
