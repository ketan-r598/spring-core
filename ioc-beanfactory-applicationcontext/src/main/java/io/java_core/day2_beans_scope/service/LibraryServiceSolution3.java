package io.java_core.day2_beans_scope.service;

import io.java_core.day2_beans_scope.model.Notification;
import io.java_core.day2_beans_scope.repository.BookRepository;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public abstract class LibraryServiceSolution3 {
    private final BookRepository bookRepository;
    private final AtomicInteger totalCount = new AtomicInteger(0);

    public LibraryServiceSolution3(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Lookup
    protected abstract NotificationService getNotificationService();

    public void checkoutBook(String userEmail, String isbn) {
        NotificationService service = getNotificationService(); // Fresh instance
        service.sentNotification(new Notification(UUID.randomUUID().toString(), "Book "+isbn+" checked out", userEmail));
        totalCount.incrementAndGet();
    }

    public int getNotificationCount() {
        return totalCount.get();
    }
}
