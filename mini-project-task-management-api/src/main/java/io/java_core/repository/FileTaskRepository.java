package io.java_core.repository;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.java_core.model.Task;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("prod")
public class FileTaskRepository implements TaskRepository {

    @Value("${task.filePath}")
    private String filePath;
    private Map<String, Task> taskMap;

    private final ObjectMapper mapper;

    public FileTaskRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Task> findAll() {
        return taskMap.values().stream().toList();
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    @Override
    public Task save(Task task) {
        taskMap.put(task.id(), task);
        return taskMap.get(task.id());
    }

    @Override
    public void deleteById(String id) {
        taskMap.remove(id);
    }

    @PostConstruct
    public void setup() throws IllegalStateException {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalStateException("File Path is not valid...");
        }

        // Reading tasks from json file and populating the map.
        taskMap = new HashMap<>();
        try (JsonParser parser = mapper.createParser(Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8))) {

            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected JSON array");
            }


            while (parser.nextToken() == JsonToken.START_OBJECT) {
                Task task = mapper.readValue(parser, Task.class);
                taskMap.put(task.id(), task);
            }

        } catch (IOException exception) {
            System.out.println("oh, snap! Something went wrong... Creating an empty map" + exception.getMessage());
            taskMap = new HashMap<>();
            exception.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre destroy is running...");
        if (filePath == null || filePath.isBlank()) {
            System.err.println("No valid filepath found...");
            return;
        }
        try {

            mapper.writeValue(Files.newBufferedWriter(Path.of(filePath), StandardCharsets.UTF_8), taskMap.values().stream().toList());
        } catch (IOException e) {
            System.out.println("Oh snap!, something went wrong..." + e.getMessage());
            e.printStackTrace();
        }
    }
}