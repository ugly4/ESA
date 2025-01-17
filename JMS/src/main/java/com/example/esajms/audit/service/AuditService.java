package com.example.esajms.audit.service;

import com.example.esajms.audit.model.AuditEvent;
import com.example.esajms.audit.utils.ChangeType;
import com.example.esajms.entities.base.BaseEntity;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Value("${app.audit.topic}")
    private String queueName;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public AuditService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void insertAuditEvent(BaseEntity<UUID> entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.INSERT,
                "Inserted " + entity.getClass().getSimpleName() + " with id " + entity.getId() + ": " + entity
        ));
    }

    public void deleteAuditEvent(BaseEntity<UUID> entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.DELETE,
                "Deleted " + entity.getClass().getSimpleName() + " with id " + entity.getId() + ": " + entity
        ));
    }

    public void updateAuditEvent(BaseEntity<UUID> entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.UPDATE,
                "Updated " + entity.getClass().getSimpleName() + " with id " + entity.getId() + ": " + entity
        ));
    }

    private void audit(AuditEvent event) {
        event.setTimestamp(LocalDateTime.now());
        jmsTemplate.convertAndSend(queueName, event);
    }
}
