package com.example.service;

import com.example.model.Report;

public class ReportService {
    private ProjectService projectService;
    private TaskService taskService;

    public ReportService(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    public Report generateProjectReport(String projectId) {
        return null;
    }

    public Report generateOverallReport() {
        return null;
    }
}
