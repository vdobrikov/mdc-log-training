package com.vdobrikov.training.mdclogtraining;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HelloService {
    private final NameClient nameClient;
    private final AuditService auditService;

    public String getHelloResponse() {
        String name = nameClient.getName();
        String helloMessage = "Hello from " + name;
        auditService.audit(helloMessage);
        return helloMessage;
    }
}
