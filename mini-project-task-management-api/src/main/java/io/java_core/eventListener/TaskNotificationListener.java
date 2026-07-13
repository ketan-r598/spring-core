package io.java_core.eventListener;

import io.java_core.event.TaskCompletedEvent;
import io.java_core.event.TaskCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationListener {

    @EventListener
    public void onTaskCreated(TaskCreatedEvent taskCreatedEvent) {
        System.out.println();
        System.out.println(" >>> TaskCreatedEvent is triggered...");
        System.out.println(" >>> New Task Created " + taskCreatedEvent.getTask());
        System.out.println();
    }

    @EventListener
    public void onTaskCompleted(TaskCompletedEvent taskCompletedEvent) {
        System.out.println();
        System.out.println(" >>> TaskCompletedEvent is triggered...");
        System.out.println(" >>> New Task Created " + taskCompletedEvent.getTask());
        System.out.println();
    }
}