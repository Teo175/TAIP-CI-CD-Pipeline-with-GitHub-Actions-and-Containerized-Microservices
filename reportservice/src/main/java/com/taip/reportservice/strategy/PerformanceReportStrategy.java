package com.taip.reportservice.strategy;

import com.taip.reportservice.model.Report;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PerformanceReportStrategy implements ReportStrategy {
    @Override
    public Report generateReport(List<Map<String, Object>> data) {
        long startTime = System.currentTimeMillis();
        int recordCount = data.size();
        long processingTime = System.currentTimeMillis() - startTime;
        
        String content = "Performance Metrics:\n" +
                        "Records processed: " + recordCount + "\n" +
                        "Processing time: " + processingTime + "ms";
        
        return new Report(null, "Performance Report", content, LocalDate.now());
    }
}