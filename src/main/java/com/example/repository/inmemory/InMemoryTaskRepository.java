package com.example.repository.inmemory;

import java.util.*;
import java.util.stream.Collectors;

import com.example.model.Task;
import com.example.repository.interfaces.ITaskRepository;

public class InMemoryTaskRepository implements ITaskRepository {
    private final Map<String, Task> store = new HashMap<>();

    @Override
    public void save(Task task) { store.put(task.getTaskId(), task); }

    @Override
    public Task findById(String id) { return store.get(id); }

    @Override
    public Collection<Task> findAll() { return store.values(); }

    @Override
    public void delete(String id) { store.remove(id); }

    @Override
    public boolean exists(String id) { return store.containsKey(id); }

    @Override
    public List<Task> findByProjectId(String projectId) {
        return store.values().stream()
                .filter(t -> t.getProjectId() != null && t.getProjectId().equals(projectId))
                .collect(Collectors.toList());
    }
}