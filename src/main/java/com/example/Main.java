package com.example;

import com.example.model.Project;
import com.example.model.Report;
import com.example.model.Task;
import com.example.observer.EventBus;
import com.example.repository.inmemory.InMemoryProjectRepository;
import com.example.repository.inmemory.InMemoryReportRepository;
import com.example.repository.inmemory.InMemoryTaskRepository;
import com.example.service.ProjectService;
import com.example.service.ReportService;
import com.example.service.TaskService;
import com.example.strategy.SummaryReportStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        InMemoryProjectRepository projectRepo = new InMemoryProjectRepository();
        InMemoryTaskRepository taskRepo = new InMemoryTaskRepository();
        InMemoryReportRepository reportRepo = new InMemoryReportRepository();
        EventBus eventBus = new EventBus();

        ProjectService projectService = new ProjectService(projectRepo, eventBus);
        TaskService taskService = new TaskService(taskRepo, projectRepo, eventBus);
        ReportService reportService = new ReportService(reportRepo, projectRepo, taskRepo,
                eventBus, new SummaryReportStrategy(projectRepo, taskRepo));

        logger.info("Creating projects...");
        Project p1 = new Project("p1", "Website Redesign", "Redesign company website", new Date(), null);
        Project p2 = new Project("p2", "Mobile App", "Develop mobile application", new Date(), null);
        projectService.createProject(p1);
        projectService.createProject(p2);
        logger.info("Created projects: {}, {}", p1.getName(), p2.getName());

        logger.info("Creating tasks...");
        taskService.createTask(new Task("t1", "p1", "Design mockups", "TODO", new Date()));
        taskService.createTask(new Task("t2", "p1", "Implement frontend", "IN_PROGRESS", new Date()));
        taskService.createTask(new Task("t3", "p2", "Setup project", "DONE", new Date()));
        logger.info("Created 3 tasks across projects");

        logger.info("Updating task status...");
        taskService.updateTaskStatus("t1", "IN_PROGRESS");
        logger.info("Task t1: TODO -> IN_PROGRESS");

        logger.info("Listing tasks for project p1:");
        taskService.listTasksByProject("p1").forEach(t ->
                logger.info("  - {} [{}]", t.getTitle(), t.getStatus())
        );

        logger.info("Generating report...");
        Report report = reportService.generateReport();
        logger.info("Report - Projects: {}, Tasks: {}", report.getProjectCount(), report.getTaskCount());

        logger.info("Updating project p1...");
        projectService.updateProject("p1", "Website Redesign v2", "Updated description");

        logger.info("Deleting task t3...");
        taskService.deleteTask("t3");

        logger.info("Generating final report...");
        Report finalReport = reportService.generateReport();
        logger.info("Final Report - Projects: {}, Tasks: {}", finalReport.getProjectCount(), finalReport.getTaskCount());

        logger.info("=== Task Management System Completed ===");
    }
}
