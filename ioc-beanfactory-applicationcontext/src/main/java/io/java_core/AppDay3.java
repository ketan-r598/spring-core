package io.java_core;

import io.java_core.day3_stereotype_annotations.LibraryConfig;
import io.java_core.day3_stereotype_annotations.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDay3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println(" >>> Container Created ");
        LibraryService libService = context.getBean(LibraryService.class);

        System.out.println("=== All Books ===");
        libService.getAllBooks().forEach(System.out::println);

        System.out.println("=== Sent Notification ===");
        libService.checkoutBook("alice@example.com", "978-0134685991");
        libService.checkoutBook("bob@example.com", "978-1617294945");

        System.out.println("Total number of notifications: " + libService.getNotificationCount());

        System.out.println("Closing Context...");

        context.close();
    }
}
