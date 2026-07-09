package io.java_core;

import io.java_core.day2_beans_scope.LibraryConfig;
import io.java_core.day2_beans_scope.service.LibraryService;
import io.java_core.day2_beans_scope.service.LibraryServiceSolution2;
import io.java_core.day2_beans_scope.service.LibraryServiceSolution3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDay2 {

    public static void main(String[] args) {

        System.out.println("=== Starting Spring Container ===");
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("=== Container Started ===");

        LibraryService service = context.getBean(LibraryService.class);
        System.out.println("=== Simulating Checkout ===");

        service.checkoutBook("alice@example.com", "978-0134685991");
        service.checkoutBook("bob@example.com", "978-1617294945");
        service.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");

        System.out.println("=== Starting Spring Container ===");
        System.out.println("=== Container Started ===");

        LibraryServiceSolution2 service2 = context.getBean(LibraryServiceSolution2.class);
        System.out.println("=== Simulating Checkout ===");

        service2.checkoutBook("alice@example.com", "978-0134685991");
        service2.checkoutBook("bob@example.com", "978-1617294945");
        service2.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service2.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");

        System.out.println("=== Starting Spring Container ===");

        System.out.println("=== Container Started ===");

        LibraryServiceSolution3 service3 = context.getBean(LibraryServiceSolution3.class);

        System.out.println("=== Simulating Checkout ===");

        service3.checkoutBook("alice@example.com", "978-0134685991");
        service3.checkoutBook("bob@example.com", "978-1617294945");
        service3.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service3.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");

    }
}
