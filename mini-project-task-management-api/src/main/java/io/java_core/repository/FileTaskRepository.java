package io.java_core.repository;

import io.java_core.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Repository
@Profile("prod")
public class FileTaskRepository implements TaskRepository {

    @Value("${task.filePath}")
    private String filePath;
    private Map<String, Task> taskMap;

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @PostConstruct
    public void setup() throws IllegalStateException, IOException {
        if(filePath == null || filePath.isBlank()) {
            throw new IllegalStateException("File Path is not valid...");
        }

    }
}
