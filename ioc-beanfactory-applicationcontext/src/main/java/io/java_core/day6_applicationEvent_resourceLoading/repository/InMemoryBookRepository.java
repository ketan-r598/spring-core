package io.java_core.day6_applicationEvent_resourceLoading.repository;

import io.java_core.day6_applicationEvent_resourceLoading.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        System.out.println(" >>> InMemoryBookRepository is called...");
        return List.of(
                new Book("Joshua Bloch","Effective Java","978-0134685991")
        );
    }
}
