package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.model.Project;
import com.example.model.Task;
import com.example.observer.Event;
import com.example.observer.EventBus;
import com.example.observer.EventType;
import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.ITaskRepository;
import com.example.service.interfaces.ITaskService;

public class TaskService implements ITaskService {
    private final ITaskRepository taskRepo;
    private final IProjectRepository projectRepo;
    private final EventBus eventBus;

    public TaskService(ITaskRepository taskRepo, IProjectRepository projectRepo, EventBus eventBus) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
        this.eventBus = eventBus;
    }

    @Override
    public void createTask(Task t) {
        if (t == null || t.getTaskId() == null) throw new IllegalArgumentException("Task or id null");
        if (!projectRepo.exists(t.getProjectId())) {
            throw new IllegalArgumentException("Linked project not found: " + t.getProjectId());
        }
        taskRepo.save(t);
        Project p = projectRepo.findById(t.getProjectId());
        if (p != null) {
            p.addTask(t);
            projectRepo.save(p);
        }
        eventBus.publish(new Event(EventType.TASK_CREATED, t));
    }

    @Override
    public void updateTaskStatus(String taskId, String status) {
        Task existing = taskRepo.findById(taskId);
        if (existing == null) throw new NoSuchElementException("Task not found: " + taskId);
        existing.setStatus(status);
        taskRepo.save(existing);
        eventBus.publish(new Event(EventType.TASK_UPDATED, existing));
    }

    @Override
    public void deleteTask(String taskId) {
        Task t = taskRepo.findById(taskId);
        taskRepo.delete(taskId);
        eventBus.publish(new Event(EventType.TASK_DELETED, t));
    }

    @Override
    public Task getTask(String taskId) {
        return taskRepo.findById(taskId);
    }

    @Override
    public List<Task> listTasksByProject(String projectId) {
        return taskRepo.findByProjectId(projectId);
    }
}