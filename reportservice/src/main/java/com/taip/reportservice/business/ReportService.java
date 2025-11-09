package com.taip.reportservice.business;

import com.taip.reportservice.strategy.ReportStrategy;
import com.taip.reportservice.strategy.StrategyType;

import java.util.List;
import java.util.Map;

public interface ReportService {
    void setReportStrategy(StrategyType type);
    void generateReport(List<Map<String, Object>> data);
}

