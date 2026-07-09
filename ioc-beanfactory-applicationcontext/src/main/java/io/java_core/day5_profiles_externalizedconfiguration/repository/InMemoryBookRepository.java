package io.java_core.day5_profiles_externalizedconfiguration.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class InMemoryBookRepository implements BookRepository {
    public InMemoryBookRepository() {
        System.out.println(" >>> InMemoryBookRepository is created...");
    }
}
