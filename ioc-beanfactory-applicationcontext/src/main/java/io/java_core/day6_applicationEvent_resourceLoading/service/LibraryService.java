package io.java_core.day6_applicationEvent_resourceLoading.service;

import io.java_core.day6_applicationEvent_resourceLoading.event.BookCheckedOutEvent;
import io.java_core.day6_applicationEvent_resourceLoading.event.LowStockEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class LibraryService {

    private final ApplicationEventPublisher eventPublisher;
    private final ResourceLoader resourceLoader;

    public LibraryService(ApplicationEventPublisher eventPublisher, ResourceLoader resourceLoader) {
        this.eventPublisher = eventPublisher;
        this.resourceLoader = resourceLoader;
    }

    public void checkOutBook(String author, String booktitle, String isbn) {
        //  publish the checked out book event
        eventPublisher.publishEvent(new BookCheckedOutEvent(this, author,booktitle,isbn));

        // publish low stock event
        eventPublisher.publishEvent(new LowStockEvent(this, "abc@gmail.com",3));
    }

    public void loadAllResources() {
        Resource resource = resourceLoader.getResource("classpath:books.json");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
