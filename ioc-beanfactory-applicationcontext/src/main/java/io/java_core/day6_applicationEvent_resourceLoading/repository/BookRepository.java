package io.java_core.day6_applicationEvent_resourceLoading.repository;

import io.java_core.day6_applicationEvent_resourceLoading.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
