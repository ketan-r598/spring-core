package io.java_core.day3_stereotype_annotations.repository;

import io.java_core.day3_stereotype_annotations.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
