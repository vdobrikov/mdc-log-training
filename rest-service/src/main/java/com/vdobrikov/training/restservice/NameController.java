package com.vdobrikov.training.restservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NameController {
    private final NameService nameService;

    @GetMapping("/api/name")
    public String getName() {
        return nameService.getName();
    }
}
