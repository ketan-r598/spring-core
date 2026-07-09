package io.java_core.day2_beans_scope.service;

import io.java_core.day2_beans_scope.repository.BookRepository;
import io.java_core.day2_beans_scope.model.Notification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LibraryService {
    private BookRepository bookRepository;

    // Buggy code: Here Notification Service is scoped prototype however, Library service
   //  being singleton chaches the instance of notification service it was created with
   // and hence end up using the same instance of notification service...
    private NotificationService notificationService;

    public LibraryService(BookRepository bookRepository, NotificationService notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
    }

    public void checkoutBook(String userEmail, String isbn) {
        // business logic
        notificationService.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
    }

    public int getNotificationCount() {
        return notificationService.getSentNotifications().size();
    }
}
