package com.example.service;

import com.example.factory.ReportStrategyFactory;
import com.example.model.Report;
import com.example.observer.Event;
import com.example.observer.EventBus;
import com.example.observer.EventType;
import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.IReportRepository;
import com.example.repository.interfaces.ITaskRepository;
import com.example.service.interfaces.IReportService;
import com.example.strategy.IReportStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * ReportService now uses Strategy pattern for flexible report generation
 */
public class ReportService implements IReportService {
    private final IReportRepository reportRepo;
    private final IProjectRepository projectRepo;
    private final ITaskRepository taskRepo;
    private final EventBus eventBus;
    private IReportStrategy currentStrategy;

    public ReportService(IReportRepository reportRepo, IProjectRepository projectRepo,
                         ITaskRepository taskRepo, EventBus eventBus, IReportStrategy defaultStrategy) {
        this.reportRepo = reportRepo;
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
        this.eventBus = eventBus;
        this.currentStrategy = defaultStrategy;
    }

    /**
     * Set the report generation strategy at runtime
     */
    public void setReportStrategy(IReportStrategy strategy) {
        this.currentStrategy = strategy;
    }

    /**
     * Switch strategy using factory
     */
    public void setReportStrategyByName(String strategyName) {
        this.currentStrategy = ReportStrategyFactory.createStrategy(
                strategyName, projectRepo, taskRepo
        );
    }

    public String getCurrentStrategyName() {
        return currentStrategy.getStrategyName();
    }

    @Override
    public Report generateReport() {
        Report r = currentStrategy.generateReport();
        reportRepo.save(r);
        eventBus.publish(new Event(EventType.REPORT_GENERATED, r));
        return r;
    }

    @Override
    public List<Report> listReports() {
        return new ArrayList<>(reportRepo.findAll());
    }
}