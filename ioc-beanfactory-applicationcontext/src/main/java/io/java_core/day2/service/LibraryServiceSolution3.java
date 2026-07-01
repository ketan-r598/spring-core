package io.java_core.day2.service;

import io.java_core.day2.model.Notification;
import io.java_core.day2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public abstract class LibraryServiceSolution3 {
    private final BookRepository bookRepository;

    public LibraryServiceSolution3(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Lookup
    protected abstract NotificationService getNotificationService();

    public void checkoutBook(String userEmail, String isbn) {
        NotificationService service = getNotificationService(); // Fresh instance
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
    }

    public int getNotificationCount() {
        // if(service == null) service = notificationService.getObject();
        NotificationService service = getNotificationService();
        return service.getSentNotifications().size();
    }
}
