package io.java_core.day6_applicationEvent_resourceLoading.repository;

import io.java_core.day6_applicationEvent_resourceLoading.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        System.out.println(" >>> Postgres Book Repositroy is called...");

        return List.of(
                new Book("Catalin Tudose", "Java Persistence with Spring", "978-161729494")
        );
    }
}
