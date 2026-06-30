package io.java_core.day1.repository;

import io.java_core.day1.model.Book;

import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of(
                new Book("Effective Java","Joshua Bloch","978-0134685991"),
                new Book("Java Persistence with Spring","Catalin Tudose","978-1617294945")
        );
    }
}
