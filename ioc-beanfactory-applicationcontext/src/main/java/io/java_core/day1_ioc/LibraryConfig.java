package io.java_core.day1_ioc;

import io.java_core.day1_ioc.repository.BookRepository;
import io.java_core.day1_ioc.repository.InMemoryBookRepository;
import io.java_core.day1_ioc.service.LibraryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public BookRepository bookRepository() {
        System.out.println(">>> Creating Book Repository");
        return new InMemoryBookRepository();
    }

    @Bean
    public LibraryService libraryService(BookRepository bookRepository) {
        System.out.println(">>> Creating Library Service");
        return new LibraryService(bookRepository);
    }


    // Causes ioc-container to throw error
//    @Bean
//    public BookRepository bookRepository1() {
//        return new FakeBookRepository();
//    }
}
