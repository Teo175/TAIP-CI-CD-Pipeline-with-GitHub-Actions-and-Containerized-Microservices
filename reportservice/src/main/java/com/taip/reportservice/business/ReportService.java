package com.taip.reportservice.business;

import com.taip.reportservice.model.Report;
import com.taip.reportservice.strategy.StrategyType;

import java.util.List;
import java.util.Map;

public interface ReportService {
    Report generateReport(StrategyType type, List<Map<String, Object>> data);
}

