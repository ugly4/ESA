package com.example.esajms.notification.repository;

import com.example.esajms.notification.model.NotificationCondition;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationConditionRepository extends JpaRepository<NotificationCondition, UUID> {
    List<NotificationCondition> findByEntityName(String entityName);
}