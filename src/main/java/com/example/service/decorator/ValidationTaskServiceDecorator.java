package com.example.service.decorator;

import com.example.model.Task;
import com.example.service.interfaces.ITaskService;
import java.util.Arrays;
import java.util.List;

/**
 * Decorator that adds validation functionality to TaskService operations.
 */
public class ValidationTaskServiceDecorator implements ITaskService {
    private final ITaskService wrappedService;
    private static final List<String> VALID_STATUSES = Arrays.asList(
            "TODO", "IN_PROGRESS", "DONE", "BLOCKED", "CANCELLED"
    );

    public ValidationTaskServiceDecorator(ITaskService wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public void createTask(Task t) {
        validateTask(t);
        wrappedService.createTask(t);
    }

    @Override
    public void updateTaskStatus(String taskId, String status) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        if (!VALID_STATUSES.contains(status)) {
            throw new IllegalArgumentException("Invalid status: " + status + ". Valid statuses: " + VALID_STATUSES);
        }
        wrappedService.updateTaskStatus(taskId, status);
    }

    @Override
    public void deleteTask(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        wrappedService.deleteTask(taskId);
    }

    @Override
    public Task getTask(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        return wrappedService.getTask(taskId);
    }

    @Override
    public List<Task> listTasksByProject(String projectId) {
        if (projectId == null || projectId.trim().isEmpty()) {
            throw new IllegalArgumentException("Project ID cannot be null or empty");
        }
        return wrappedService.listTasksByProject(projectId);
    }

    private void validateTask(Task t) {
        if (t == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (t.getTaskId() == null || t.getTaskId().trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        if (t.getTitle() == null || t.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        if (t.getProjectId() == null || t.getProjectId().trim().isEmpty()) {
            throw new IllegalArgumentException("Project ID cannot be null or empty");
        }
        if (t.getStatus() != null && !VALID_STATUSES.contains(t.getStatus())) {
            throw new IllegalArgumentException("Invalid status: " + t.getStatus());
        }
    }
}