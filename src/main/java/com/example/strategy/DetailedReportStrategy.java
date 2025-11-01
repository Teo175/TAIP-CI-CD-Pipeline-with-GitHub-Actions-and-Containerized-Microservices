package com.example.strategy;

import com.example.model.Project;
import com.example.model.Report;
import com.example.model.Task;
import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.ITaskRepository;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class DetailedReportStrategy implements IReportStrategy {
    private final IProjectRepository projectRepo;
    private final ITaskRepository taskRepo;

    public DetailedReportStrategy(IProjectRepository projectRepo, ITaskRepository taskRepo) {
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public Report generateReport() {
        Collection<Project> projects = projectRepo.findAll();
        Collection<Task> tasks = taskRepo.findAll();

        int completedTasks = (int) tasks.stream()
                .filter(t -> "DONE".equals(t.getStatus()))
                .count();

        return new Report(
                "detailed_" + UUID.randomUUID().toString(),
                projects.size(),
                tasks.size(),
                new Date()
        );
    }

    @Override
    public String getStrategyName() {
        return "DETAILED";
    }
}