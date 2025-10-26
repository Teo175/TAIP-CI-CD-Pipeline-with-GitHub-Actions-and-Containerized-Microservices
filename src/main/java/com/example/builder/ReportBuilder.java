package com.example.builder;

import com.example.model.Report;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ReportBuilder {
    private String id;
    private String projectId;
    private int totalTasks;
    private Map<String, Integer> tasksByStatus = new HashMap<>();
    private LocalDateTime generatedAt;

    public ReportBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ReportBuilder projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public ReportBuilder totalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
        return this;
    }

    public ReportBuilder tasksByStatus(Map<String, Integer> tasksByStatus) {
        this.tasksByStatus = tasksByStatus;
        return this;
    }

    public ReportBuilder generatedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
        return this;
    }

    public Report build() {
        Report report = new Report();
        report.setId(id);
        report.setProjectId(projectId);
        report.setTotalTasks(totalTasks);
        report.setTasksByStatus(tasksByStatus);
        report.setGeneratedAt(generatedAt != null ? generatedAt : LocalDateTime.now());
        return report;
    }
}
