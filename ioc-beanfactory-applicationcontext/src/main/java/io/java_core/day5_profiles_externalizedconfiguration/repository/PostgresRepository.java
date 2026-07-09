package io.java_core.day5_profiles_externalizedconfiguration.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class PostgresRepository implements BookRepository {
    public PostgresRepository() {
        System.out.println(" >>> PostgresRepository created ...");
    }
}
