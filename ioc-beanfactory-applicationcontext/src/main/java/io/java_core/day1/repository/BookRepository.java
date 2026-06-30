package io.java_core.day1.repository;

import io.java_core.day1.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
