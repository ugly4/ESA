package com.example.esajms.audit.repository;

import com.example.esajms.audit.model.AuditEvent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditEventRepository extends JpaRepository<AuditEvent, UUID> {
}
