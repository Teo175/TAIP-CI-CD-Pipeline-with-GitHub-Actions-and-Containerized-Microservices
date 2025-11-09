package com.taip.reportservice.strategy;

import com.taip.reportservice.model.Report;
import java.util.List;
import java.util.Map;

public interface ReportStrategy {
    Report generateReport(List<Map<String, Object>> data);
}
