package com.example.strategy;

import com.example.model.Report;
import com.example.model.Task;
import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.ITaskRepository;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class PerformanceReportStrategy implements IReportStrategy {
    private final IProjectRepository projectRepo;
    private final ITaskRepository taskRepo;

    public PerformanceReportStrategy(IProjectRepository projectRepo, ITaskRepository taskRepo) {
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public Report generateReport() {
        Collection<Task> tasks = taskRepo.findAll();

        long completedTasks = tasks.stream()
                .filter(t -> "DONE".equals(t.getStatus()))
                .count();

        long inProgressTasks = tasks.stream()
                .filter(t -> "IN_PROGRESS".equals(t.getStatus()))
                .count();

        return new Report(
                "perf_" + UUID.randomUUID().toString(),
                projectRepo.findAll().size(),
                tasks.size(),
                new Date()
        );
    }

    @Override
    public String getStrategyName() {
        return "PERFORMANCE";
    }
}
