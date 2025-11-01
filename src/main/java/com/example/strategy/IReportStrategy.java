package com.example.strategy;

import com.example.model.Report;

/**
 * Strategy interface for different report generation approaches
 */
public interface IReportStrategy {
    /**
     * Generate a report using a specific strategy
     */
    Report generateReport();

    /**
     * Get the strategy name/type
     */
    String getStrategyName();
}
