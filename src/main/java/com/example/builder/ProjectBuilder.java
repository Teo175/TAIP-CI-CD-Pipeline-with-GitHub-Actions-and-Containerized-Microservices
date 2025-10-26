package com.example.builder;

import com.example.model.Project;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Design Pattern: Builder
public class ProjectBuilder {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> taskIds = new ArrayList<>();

    public ProjectBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ProjectBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ProjectBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ProjectBuilder taskIds(List<String> taskIds) {
        this.taskIds = taskIds;
        return this;
    }

    public Project build() {
        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setDescription(description);
        project.setCreatedAt(createdAt != null ? createdAt : LocalDateTime.now());
        project.setUpdatedAt(updatedAt != null ? updatedAt : LocalDateTime.now());
        project.setTaskIds(taskIds);
        return project;
    }
}
