package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private String projectId;
    private String name;
    private String description;
    private Date createdAt;
    private List<Task> tasks;

    public Project() {
        this.tasks = new ArrayList<>();
    }

    public Project(String projectId, String name, String description, Date createdAt, List<Task> tasks) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.tasks = tasks != null ? tasks : new ArrayList<>();
    }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public void addTask(Task task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }
}
