package io.java_core.day2.repository;

import io.java_core.day1.model.Book;
import jdk.javadoc.doclet.Reporter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findAll();
}
