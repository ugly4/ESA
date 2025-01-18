package com.example.esajms.audit.model;

import com.example.esajms.audit.utils.ChangeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import java.time.LocalDateTime;

@Entity(name = "esa$AuditEvents")
@Table(name = "ESA_AUDIT_EVENTS")
public class AuditEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "ENTITY_NAME", nullable = false)
    private String entityName;

    @Column(name = "ENTITY_ID", nullable = false)
    private UUID entityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "CHANGE_TYPE", nullable = false)
    private ChangeType changeType;

    @Column(name = "CHANGE_DETAILS", nullable = false)
    private String changeDetails;

    @Column(name = "TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    public AuditEvent(String entityName, UUID entityId, ChangeType changeType, String changeDetails) {
        this.entityName = entityName;
        this.entityId = entityId;
        this.changeDetails = changeDetails;
        this.changeType = changeType;
    }

    public AuditEvent() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public String getChangeDetails() {
        return changeDetails;
    }

    public void setChangeDetails(String changeDetails) {
        this.changeDetails = changeDetails;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
