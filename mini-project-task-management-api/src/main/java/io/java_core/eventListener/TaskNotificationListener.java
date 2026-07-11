package io.java_core.eventListener;

import io.java_core.event.TaskCompletedEvent;
import io.java_core.event.TaskCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationListener {

    @EventListener
    public void onTaskCreated(TaskCreatedEvent taskCreatedEvent) {}

    @EventListener
    public void onTaskCompleted(TaskCompletedEvent taskCompletedEvent) {}
}