package io.java_core.day2.repository;

import io.java_core.day1.model.Book;

import java.util.List;


public interface BookRepository {
    List<Book> findAll();
}
