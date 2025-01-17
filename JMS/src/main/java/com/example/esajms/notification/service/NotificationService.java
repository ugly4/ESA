package com.example.esajms.notification.service;


import com.example.esajms.audit.model.AuditEvent;
import com.example.esajms.notification.model.NotificationCondition;
import com.example.esajms.notification.repository.NotificationConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationConditionRepository conditionRepository;
    private final JavaMailSender mailSender;

    @Autowired
    public NotificationService(NotificationConditionRepository conditionRepository, JavaMailSender mailSender) {
        this.conditionRepository = conditionRepository;
        this.mailSender = mailSender;
    }


    public void checkAndNotify(AuditEvent auditEvent) {
        List<NotificationCondition> conditions =
                conditionRepository.findByEntityName(auditEvent.getEntityName());

        for (NotificationCondition condition : conditions) {
            sendEmail(condition.getEmail(), auditEvent);
        }
    }

    private void sendEmail(String to, AuditEvent auditEvent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Notification: " + auditEvent.getEntityName());
        message.setText(auditEvent.getChangeDetails());

        mailSender.send(message);
    }
}
