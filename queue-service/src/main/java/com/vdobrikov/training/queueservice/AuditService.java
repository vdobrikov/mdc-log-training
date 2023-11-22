package com.vdobrikov.training.queueservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuditService {

    @JmsListener(destination = "${jms.topic.audit}")
    public void onAuditMessage(String message) {
        log.info("Audit message: {}", message);
    }
}
