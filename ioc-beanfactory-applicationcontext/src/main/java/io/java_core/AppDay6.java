package io.java_core;

import io.java_core.day6_applicationEvent_resourceLoading.LibraryConfig;
import io.java_core.day6_applicationEvent_resourceLoading.repository.BookRepository;
import io.java_core.day6_applicationEvent_resourceLoading.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDay6 {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class)) {
            System.out.println("=== Starting Container ===");

            BookRepository repo = context.getBean(BookRepository.class);
            repo.findAll().forEach(System.out::println);

            LibraryService service = context.getBean(LibraryService.class);

            System.out.println("=== Checking out First Book... ===");
            service.checkOutBook("Joshua Bloch","Effective Java","978-0134685991");

            System.out.println("=== Checking out Second Book... ===");
            service.checkOutBook("Catalin Tudose","Java Persistence with Spring","978-161729494");

            System.out.println("=== Loading Resources Started===");
            service.loadAllResources();
            System.out.println("=== Loading Resources Done");

            System.out.println("=== Container Closed... ===");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
