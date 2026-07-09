package io.java_core;

import io.java_core.day5_profiles_externalizedconfiguration.LibraryConfig;
import io.java_core.day5_profiles_externalizedconfiguration.repository.BookRepository;
import io.java_core.day5_profiles_externalizedconfiguration.repository.InMemoryBookRepository;
import io.java_core.day5_profiles_externalizedconfiguration.services.DbService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDay5 {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "dev");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        DbService dbService = context.getBean(DbService.class);
        BookRepository repo = context.getBean(BookRepository.class);
        System.out.println(context.getEnvironment());
        context.close();

    }
}
