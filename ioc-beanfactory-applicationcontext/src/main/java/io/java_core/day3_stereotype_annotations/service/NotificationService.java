package io.java_core.day3_stereotype_annotations.service;

import io.java_core.day3_stereotype_annotations.model.Notification;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Scope("prototype")
public class NotificationService {
    private final String instanceId = UUID.randomUUID().toString();
    private final List<Notification> sentNotifications = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println(">>> Notification is created with instanceId " + instanceId);
    }

    public void sentNotification(Notification notification) {
        // Process and sent the notification

        sentNotifications.add(notification);
        System.out.println("[" + instanceId + "] Sent to " + notification.getRecipient()
                + " | Total this instance: " + sentNotifications.size());
    }

    public List<Notification> getSentNotifications() {
        return List.copyOf(sentNotifications);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(">>> NotificationService destroyed " + instanceId);
    }
}
