package io.java_core.event;

import io.java_core.model.Task;
import org.springframework.context.ApplicationEvent;

public class TaskCreatedEvent extends ApplicationEvent {
    private Task task;

    public TaskCreatedEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
