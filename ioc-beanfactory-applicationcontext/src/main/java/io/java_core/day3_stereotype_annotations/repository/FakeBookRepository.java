package io.java_core.day3_stereotype_annotations.repository;

import io.java_core.day3_stereotype_annotations.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public class FakeBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return List.of();
    }
    @PostConstruct
    void printCreated() {
        System.out.println(" >>> FakeBookRepository is created...");
    }

}

