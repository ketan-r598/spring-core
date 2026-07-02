package io.java_core.day2_beans_scope.repository;

import io.java_core.day1_ioc.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of(
                new Book("Effective Java","Joshua Bloch","978-0134685991"),
                new Book("Java Persistence with Spring","Catalin Tudose","978-1617294945")
        );
    }
}
