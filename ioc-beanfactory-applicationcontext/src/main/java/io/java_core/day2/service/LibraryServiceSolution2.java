package io.java_core.day2.service;

import io.java_core.day2.model.Notification;
import io.java_core.day2.repository.BookRepository;
import jakarta.inject.Provider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LibraryServiceSolution2 {
    private BookRepository bookRepository;
    private Provider<NotificationService> notificationService;

    public LibraryServiceSolution2 (BookRepository bookRepository, Provider<NotificationService> notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
    }

    public void checkoutBook(String userEmail, String isbn) {
        // business logic
        // if( service == null) service = notificationService.getObject();
        NotificationService service = notificationService.get();
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
    }

    public int getNotificationCount() {
        // if(service == null) service = notificationService.getObject();
        NotificationService service = notificationService.get();
        return service.getSentNotifications().size();
    }
}
