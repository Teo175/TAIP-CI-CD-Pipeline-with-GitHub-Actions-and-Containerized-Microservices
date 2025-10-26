package com.example.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Report {
    private String id;
    private String projectId;
    private int totalTasks;
    private Map<String, Integer> tasksByStatus;
    private LocalDateTime generatedAt;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public int getTotalTasks() { return totalTasks; }
    public void setTotalTasks(int totalTasks) { this.totalTasks = totalTasks; }

    public Map<String, Integer> getTasksByStatus() { return tasksByStatus; }
    public void setTasksByStatus(Map<String, Integer> tasksByStatus) { this.tasksByStatus = tasksByStatus; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
