package io.java_core.repository;

import io.java_core.model.Task;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class InMemoryTaskRepository implements TaskRepository {
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
}
