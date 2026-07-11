package io.java_core.service;

import io.java_core.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    public Task createTask(String title, String description) {
        // find the number of tasks -> if greater than threshold, throw IllegalStateException
        // Create new task
        // Add it to repo / save it
        // if saved successfully:
        //      publish task created event
        //      return the newly created task
        // return null
        return null;
    }
    public Task completeTask(String id) {
        // Get the task from the repo
        // Create a new task with status updated
        // Delete the existing task from the repo
        // Add the task with updated status
        // Publish the completed task event

        // if id does not exist - Illegal Argument exception
        return null;
    }
    public List<Task> getAllTasks() {
        // fetch the list from repo and return the list.
        return null;
    }
}