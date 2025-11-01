package com.example.model;

import java.util.Date;

public class Task {
    private String taskId;
    private String projectId;
    private String title;
    private String status;
    private Date createdAt;

    public Task() {}

    public Task(String taskId, String projectId, String title, String status, Date createdAt) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.title = title;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
