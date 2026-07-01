package io.java_core;

import io.java_core.day2.LibraryConfig;
import io.java_core.day2.service.LibraryServiceSolution3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        System.out.println("=== Starting Spring Container ===");
//
//        ApplicationContext appContext =
//                new AnnotationConfigApplicationContext(LibraryConfig.class);
//
//        System.out.println("=== Container Started... Retreiving bean");
//
//        LibraryService libraryService = appContext.getBean(LibraryService.class);
//
//        libraryService.findAll()
//                .forEach(System.out::println);
//
//
//
//        // Stretch Task 1: Add a Second Bean of Same Type
//        LibraryService libraryService1 = appContext.getBean(LibraryService.class);
//
//        // Should return true since container creates singleton scopes.
//        System.out.println(libraryService == libraryService1);


        // Stretch Task 2: Switch to BeanFactory
        // Observe: beans are created lazily (only when getBean() is called). This is the core difference.

        // Bean Factory Usage

        // Does the Lazy intialization
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//
//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
//
//        // 3. Register your @Configuration class metadata
//        reader.register(LibraryConfig.class);
//
//        // 4. Manually trigger processing of @Configuration infrastructure (like @Bean methods)
//
//        ConfigurationClassPostProcessor processor = new ConfigurationClassPostProcessor();
//        processor.postProcessBeanFactory(factory);
//
//        System.out.println("=== Container Started... Retreiving bean");
//
//        // 5. Fetch your registered bean from the container
//        LibraryService service = factory.getBean(LibraryService.class);
//        service.findAll().forEach(System.out::println);



        // Stretch Task 3: Add @PostConstruct - Done in LibraryService...

//        System.out.println("=== Closing Container ===");

        /*System.out.println("=== Starting Spring Container ===");
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("=== Container Started ===");

//        LibraryService service = context.getBean(LibraryService.class);
        LibraryServiceSolution1 service = context.getBean(LibraryServiceSolution1.class);
        System.out.println("=== Simulating Checkout ===");

        service.checkoutBook("alice@example.com", "978-0134685991");
        service.checkoutBook("bob@example.com", "978-1617294945");
        service.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");*/

        /*System.out.println("=== Starting Spring Container ===");
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("=== Container Started ===");

        LibraryServiceSolution2 service = context.getBean(LibraryServiceSolution2.class);
        System.out.println("=== Simulating Checkout ===");

        service.checkoutBook("alice@example.com", "978-0134685991");
        service.checkoutBook("bob@example.com", "978-1617294945");
        service.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");*/

        System.out.println("=== Starting Spring Container ===");
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("=== Container Started ===");

        LibraryServiceSolution3 service = context.getBean(LibraryServiceSolution3.class);
        System.out.println("=== Simulating Checkout ===");

        service.checkoutBook("alice@example.com", "978-0134685991");
        service.checkoutBook("bob@example.com", "978-1617294945");
        service.checkoutBook("alice@example.com", "978-0134685991");

        System.out.println("\n=== Notification count: " + service.getNotificationCount() + " ===");
        System.out.println("=== Expected: 3, Actual: see above ===");

    }
}
