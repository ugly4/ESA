package com.example.esajms.consumer;

import com.example.esajms.audit.model.AuditEvent;
import com.example.esajms.audit.repository.AuditEventRepository;
import com.example.esajms.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    private final AuditEventRepository auditEventRepository;
    private final NotificationService notificationService;

    @Autowired
    public Listener(AuditEventRepository auditEventRepository, NotificationService notificationService) {
        this.auditEventRepository = auditEventRepository;
        this.notificationService = notificationService;
    }

    @JmsListener(destination = "${app.audit.topic}")
    public void onMessage(AuditEvent auditEvent) {
        try {

            if (auditEvent == null || auditEvent.getChangeType() == null || auditEvent.getEntityName() == null) {
                throw new IllegalArgumentException("Invalid message structure");
            }

            auditEventRepository.save(auditEvent);

            notificationService.checkAndNotify(auditEvent);

        } catch (Exception e) {
            System.err.println("Failed to process JMS message: " + e.getMessage());
        }
    }
}
