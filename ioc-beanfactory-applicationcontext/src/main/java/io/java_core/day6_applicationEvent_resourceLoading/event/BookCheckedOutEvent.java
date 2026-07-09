package io.java_core.day6_applicationEvent_resourceLoading.event;

import org.springframework.context.ApplicationEvent;

public class BookCheckedOutEvent extends ApplicationEvent {
    private final String userEmail;
    private final String isbn;
    private final String bookTitle;

    public BookCheckedOutEvent(Object source, String userEmail, String isbn, String bookTitle) {
        super(source);
        this.userEmail = userEmail;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "BookCheckedOutEvent{" +
                "userEmail='" + userEmail + '\'' +
                ", isbn='" + isbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
