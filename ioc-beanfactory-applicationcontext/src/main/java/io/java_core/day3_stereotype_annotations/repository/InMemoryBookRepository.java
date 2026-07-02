package io.java_core.day3_stereotype_annotations.repository;

import io.java_core.day3_stereotype_annotations.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of(
                new Book("Effective Java","Joshua Bloch","978-0134685991"),
                new Book("Java Persistence with Spring","Catalin Tudose","978-1617294945")
        );
    }
    @PostConstruct
    public void printCreated() {
        System.out.println(" >>> InMemoryBookRepository is created...");
    }

}
