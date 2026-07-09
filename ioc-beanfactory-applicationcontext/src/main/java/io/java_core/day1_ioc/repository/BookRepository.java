package io.java_core.day1_ioc.repository;

import io.java_core.day1_ioc.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
