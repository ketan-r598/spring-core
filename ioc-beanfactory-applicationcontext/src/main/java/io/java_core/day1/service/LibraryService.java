package io.java_core.day1.service;

import io.java_core.day1.model.Book;
import io.java_core.day1.repository.BookRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;

public class LibraryService {
    private BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @PostConstruct
    public void init() {
        System.out.println(">>> LibraryService is created successfully");
    }
}
