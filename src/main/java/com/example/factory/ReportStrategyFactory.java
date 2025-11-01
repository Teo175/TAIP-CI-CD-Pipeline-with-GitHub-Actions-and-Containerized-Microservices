package com.example.factory;

import com.example.repository.interfaces.IProjectRepository;
import com.example.repository.interfaces.ITaskRepository;
import com.example.strategy.*;

/**
 * Factory for creating report strategies
 */
public class ReportStrategyFactory {
    /**
     * Create a report strategy based on type
     */
    public static IReportStrategy createStrategy(
            StrategyType type,
            IProjectRepository projectRepo,
            ITaskRepository taskRepo) {

        switch (type) {
            case SUMMARY:
                return new SummaryReportStrategy(projectRepo, taskRepo);
            case DETAILED:
                return new DetailedReportStrategy(projectRepo, taskRepo);
            case PERFORMANCE:
                return new PerformanceReportStrategy(projectRepo, taskRepo);
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }

    /**
     * Create strategy from string
     */
    public static IReportStrategy createStrategy(
            String strategyName,
            IProjectRepository projectRepo,
            ITaskRepository taskRepo) {

        try {
            StrategyType type = StrategyType.valueOf(strategyName.toUpperCase());
            return createStrategy(type, projectRepo, taskRepo);
        } catch (IllegalArgumentException e) {
            return new SummaryReportStrategy(projectRepo, taskRepo);
        }
    }
}