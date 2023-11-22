package com.vdobrikov.training.mdclogtraining;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class NameClient {
    private static final String NAME_SERVICE_ENDPOINT = "http://localhost:8081/api/name";

    private final RestTemplate restTemplate;

    public String getName() {
        log.info("Calling name service at '{}'", NAME_SERVICE_ENDPOINT);

        return restTemplate.getForObject(NAME_SERVICE_ENDPOINT, String.class);
    }
}
