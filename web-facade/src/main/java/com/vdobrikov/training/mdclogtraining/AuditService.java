package com.vdobrikov.training.mdclogtraining;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuditService {
    private final JmsTemplate jmsTemplate;

    @Value("${jms.topic.audit}")
    private String auditQueue;

    public void audit(String message) {
        jmsTemplate.convertAndSend(auditQueue, message);
    }
}
