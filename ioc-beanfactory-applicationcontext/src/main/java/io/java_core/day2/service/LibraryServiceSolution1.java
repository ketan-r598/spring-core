package io.java_core.day2.service;

import io.java_core.day2.model.Notification;
import io.java_core.day2.repository.BookRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LibraryServiceSolution1 {
    private BookRepository bookRepository;
    private ObjectFactory<NotificationService> notificationService;
//    private NotificationService service = null;

    public LibraryServiceSolution1 (BookRepository bookRepository, ObjectFactory<NotificationService> notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
    }

    public void checkoutBook(String userEmail, String isbn) {
        // business logic
        // if( service == null) service = notificationService.getObject();
        NotificationService service = notificationService.getObject();
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
    }

    public int getNotificationCount() {
        // if(service == null) service = notificationService.getObject();
        NotificationService service = notificationService.getObject();
        return service.getSentNotifications().size();
    }
}
