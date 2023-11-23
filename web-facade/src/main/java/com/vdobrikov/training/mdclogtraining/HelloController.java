package com.vdobrikov.training.mdclogtraining;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;

    @GetMapping
    public String hello(@RequestParam(required = false) String name) {
        log.info("GET hello. name='{}'", name);
        name = name == null ? "Unknown" : name;

        try {
            MDC.put("name", name);
            return name + ", " + helloService.getHelloResponse();
        } finally {
            MDC.remove("name");
        }
    }
}
