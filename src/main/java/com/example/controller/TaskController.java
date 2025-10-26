package com.example.controller;

import java.util.List;

import com.example.model.Task;
import com.example.service.TaskService;

public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public Task createTask(Task task) {
        return null;
    }

    public Task getTask(String id) {
        return null;
    }

    public List<Task> getAllTasks() {
        return null;
    }

    public List<Task> getTasksByProject(String projectId) {
        return null;
    }

    public Task updateTask(String id, Task task) {
        return null;
    }

    public void deleteTask(String id) {
    }
}
