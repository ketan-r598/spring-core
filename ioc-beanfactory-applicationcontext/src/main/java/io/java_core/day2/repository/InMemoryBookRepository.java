package io.java_core.day2.repository;

import io.java_core.day1.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of(
                new Book("Effective Java","Joshua Bloch","978-0134685991"),
                new Book("Java Persistence with Spring","Catalin Tudose","978-1617294945")
        );
    }
}
