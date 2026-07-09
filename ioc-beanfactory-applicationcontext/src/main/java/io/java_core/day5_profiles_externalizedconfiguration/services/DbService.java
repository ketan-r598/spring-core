package io.java_core.day5_profiles_externalizedconfiguration.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String userPassword;

    @PostConstruct
    public void printConfig() {
        System.out.println("DB url: " + dbUrl);
        System.out.println("DB Username: " + userName);
        System.out.println("DB password: " + userPassword);
    }
}
