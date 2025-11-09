package com.taip.taskservice.business;

import com.taip.taskservice.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> getAllTasks();
}
