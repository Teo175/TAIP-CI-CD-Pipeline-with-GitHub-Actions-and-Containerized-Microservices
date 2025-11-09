package com.taip.taskservice.builder;

import com.taip.taskservice.model.Task;

public class TaskBuilder {
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private Long projectId;

    public TaskBuilder setId(Long id) { this.id = id; return this; }
    public TaskBuilder setName(String name) { this.name = name; return this; }
    public TaskBuilder setDescription(String description) { this.description = description; return this; }
    public TaskBuilder setCompleted(boolean completed) { this.completed = completed; return this; }
    public TaskBuilder setProjectId(Long projectId) { this.projectId = projectId; return this; }

    public Task build() { return new Task(id, name, description, completed, projectId); }
}

