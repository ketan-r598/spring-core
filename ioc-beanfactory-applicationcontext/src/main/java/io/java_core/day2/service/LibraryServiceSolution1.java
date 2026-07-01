package io.java_core.day2.service;

import io.java_core.day2.model.Notification;
import io.java_core.day2.repository.BookRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LibraryServiceSolution1 {
    private BookRepository bookRepository;
    private ObjectFactory<NotificationService> notificationService;
    private final AtomicInteger totalCount = new AtomicInteger(0);

    public LibraryServiceSolution1 (BookRepository bookRepository, ObjectFactory<NotificationService> notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
    }

    public void checkoutBook(String userEmail, String isbn) {
        NotificationService service = notificationService.getObject();
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
        totalCount.incrementAndGet();
    }

    public int getNotificationCount() {
        return totalCount.get();
    }
}
