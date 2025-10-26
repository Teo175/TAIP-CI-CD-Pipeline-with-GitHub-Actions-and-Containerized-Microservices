package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return null;
    }

    public Optional<Task> getTaskById(String id) {
        return null;
    }

    public List<Task> getAllTasks() {
        return null;
    }

    public List<Task> getTasksByProjectId(String projectId) {
        return null;
    }

    public Task updateTask(String id, Task task) {
        return null;
    }

    public void deleteTask(String id) {
    }
}
