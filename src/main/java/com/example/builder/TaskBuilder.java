package com.example.builder;

import com.example.model.Task;
import java.time.LocalDateTime;

public class TaskBuilder {
    private String id;
    private String projectId;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskBuilder id(String id) {
        this.id = id;
        return this;
    }

    public TaskBuilder projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public TaskBuilder title(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder status(String status) {
        this.status = status;
        return this;
    }

    public TaskBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public TaskBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Task build() {
        Task task = new Task();
        task.setId(id);
        task.setProjectId(projectId);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status != null ? status : "TODO");
        task.setCreatedAt(createdAt != null ? createdAt : LocalDateTime.now());
        task.setUpdatedAt(updatedAt != null ? updatedAt : LocalDateTime.now());
        return task;
    }
}
