package io.java_core.day1_ioc.repository;

import io.java_core.day1_ioc.model.Book;

import java.util.List;

public class FakeBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of();
    }
}
