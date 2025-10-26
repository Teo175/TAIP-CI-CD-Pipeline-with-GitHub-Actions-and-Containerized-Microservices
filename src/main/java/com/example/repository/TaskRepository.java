package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.model.Task;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(String id);
    List<Task> findAll();
    List<Task> findByProjectId(String projectId);
    void deleteById(String id);
    boolean existsById(String id);
}
