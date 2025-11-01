package com.example.service;

import com.example.model.Project;
import com.example.model.Report;
import com.example.model.Task;
import com.example.observer.EventBus;
import com.example.repository.inmemory.InMemoryProjectRepository;
import com.example.repository.inmemory.InMemoryReportRepository;
import com.example.repository.inmemory.InMemoryTaskRepository;
import com.example.strategy.SummaryReportStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReportServiceTest {
    private ReportService reportService;
    private InMemoryReportRepository reportRepo;
    private InMemoryProjectRepository projectRepo;
    private InMemoryTaskRepository taskRepo;
    private EventBus eventBus;

    @Before
    public void setup() {
        reportRepo = new InMemoryReportRepository();
        projectRepo = new InMemoryProjectRepository();
        taskRepo = new InMemoryTaskRepository();
        eventBus = new EventBus();

        SummaryReportStrategy strategy = new SummaryReportStrategy(projectRepo, taskRepo);
        reportService = new ReportService(reportRepo, projectRepo, taskRepo, eventBus, strategy);
    }

    @Test
    public void testGenerateReport() {
        projectRepo.save(new Project("p1", "Project 1", "Desc", new Date(), null));
        taskRepo.save(new Task("t1", "p1", "Task 1", "TODO", new Date()));

        Report report = reportService.generateReport();

        assertNotNull(report);
        assertNotNull(report.getReportId());
        assertEquals(1, report.getProjectCount());
        assertEquals(1, report.getTaskCount());
    }

    @Test
    public void testGenerateReportWithMultipleProjects() {
        projectRepo.save(new Project("p1", "Project 1", "Desc", new Date(), null));
        projectRepo.save(new Project("p2", "Project 2", "Desc", new Date(), null));
        taskRepo.save(new Task("t1", "p1", "Task 1", "TODO", new Date()));
        taskRepo.save(new Task("t2", "p1", "Task 2", "DONE", new Date()));
        taskRepo.save(new Task("t3", "p2", "Task 3", "IN_PROGRESS", new Date()));

        Report report = reportService.generateReport();

        assertEquals(2, report.getProjectCount());
        assertEquals(3, report.getTaskCount());
    }

    @Test
    public void testGenerateReportEmpty() {
        Report report = reportService.generateReport();

        assertNotNull(report);
        assertEquals(0, report.getProjectCount());
        assertEquals(0, report.getTaskCount());
    }

    @Test
    public void testListReports() {
        reportService.generateReport();
        reportService.generateReport();

        List<Report> reports = reportService.listReports();
        assertEquals(2, reports.size());
    }

    @Test
    public void testReportAggregatesDataAcrossServices() {
        projectRepo.save(new Project("p1", "Project 1", "Desc", new Date(), null));
        projectRepo.save(new Project("p2", "Project 2", "Desc", new Date(), null));
        taskRepo.save(new Task("t1", "p1", "Task 1", "TODO", new Date()));
        taskRepo.save(new Task("t2", "p2", "Task 2", "DONE", new Date()));

        Report report = reportService.generateReport();

        assertTrue(report.getProjectCount() > 0);
        assertTrue(report.getTaskCount() > 0);
        assertNotNull(report.getTimestamp());
    }
}