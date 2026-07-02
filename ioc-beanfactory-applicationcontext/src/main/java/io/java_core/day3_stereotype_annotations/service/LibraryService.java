package io.java_core.day3_stereotype_annotations.service;

import io.java_core.day3_stereotype_annotations.model.Book;
import io.java_core.day3_stereotype_annotations.model.Notification;
import io.java_core.day3_stereotype_annotations.repository.BookRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LibraryService {
    private final BookRepository bookRepository;
    private final ObjectFactory<NotificationService> notificationService;
    private final AtomicInteger totalCount = new AtomicInteger(0);

    public LibraryService(@Qualifier("fakeBookRepository") @Lazy BookRepository bookRepository, ObjectFactory<NotificationService> notificationService) {
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

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
