package com.example.strategy;

import com.example.model.Report;
import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.ITaskRepository;
import java.util.Date;
import java.util.UUID;

public class SummaryReportStrategy implements IReportStrategy {
    private final IProjectRepository projectRepo;
    private final ITaskRepository taskRepo;

    public SummaryReportStrategy(IProjectRepository projectRepo, ITaskRepository taskRepo) {
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public Report generateReport() {
        int projectCount = projectRepo.findAll().size();
        int taskCount = taskRepo.findAll().size();

        return new Report(
                "summary_" + UUID.randomUUID().toString(),
                projectCount,
                taskCount,
                new Date()
        );
    }

    @Override
    public String getStrategyName() {
        return "SUMMARY";
    }
}