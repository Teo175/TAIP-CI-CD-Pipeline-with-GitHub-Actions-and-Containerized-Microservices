package com.example.service.interfaces;

import java.util.List;

import com.example.model.Task;

public interface ITaskService {
    void createTask(Task t);
    void updateTaskStatus(String taskId, String status);
    void deleteTask(String taskId);
    Task getTask(String taskId);
    List<Task> listTasksByProject(String projectId);
}