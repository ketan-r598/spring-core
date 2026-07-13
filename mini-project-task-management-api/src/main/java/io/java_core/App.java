package io.java_core;

import io.java_core.configuration.TaskConfiguration;
import io.java_core.model.Task;
import io.java_core.service.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // Setting up the profile
        System.setProperty("spring.profiles.active", "prod");

        // Starting the container
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(TaskConfiguration.class)) {

            // invokes the shutdown method when jvm start termination
            context.registerShutdownHook();

            TaskService taskService = context.getBean(TaskService.class);

            // 1st task

            // Create new Task
            Task task = taskService.createTask("Read Books", "I've to read books A, b and C");

            // Complete the task
            task = taskService.completeTask(task.id());

            // Displaying all the task
            taskService.getAllTasks().forEach(System.out::println);

            // 2nd Task

            // Create new Task
            Task task2 = taskService.createTask("Write Books", "I've to write books A, b and C");

            // Complete the task
            task2 = taskService.completeTask(task2.id());

            // Displaying all the task
            taskService.getAllTasks().forEach(System.out::println);
        }
    }
}
