package io.java_core.day2_beans_scope.service;

import io.java_core.day2_beans_scope.model.Notification;
import io.java_core.day2_beans_scope.repository.BookRepository;
import jakarta.inject.Provider;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LibraryServiceSolution2 {
    private BookRepository bookRepository;
    private Provider<NotificationService> notificationService;
    private AtomicInteger totalCount = new AtomicInteger(0);

    public LibraryServiceSolution2 (BookRepository bookRepository, Provider<NotificationService> notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
    }

    public void checkoutBook(String userEmail, String isbn) {
        NotificationService service = notificationService.get();
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
        totalCount.incrementAndGet();
    }

    public int getNotificationCount() {
        return totalCount.get();
    }
}
