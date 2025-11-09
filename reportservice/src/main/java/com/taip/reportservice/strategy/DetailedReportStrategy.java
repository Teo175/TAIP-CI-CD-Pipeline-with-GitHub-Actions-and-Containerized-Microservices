package com.taip.reportservice.strategy;

import com.taip.reportservice.model.Report;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DetailedReportStrategy implements ReportStrategy {
    @Override
    public Report generateReport(List<Map<String, Object>> data) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            content.append("Record ").append(i + 1).append(": ").append(data.get(i)).append("\n");
        }
        return new Report(null, "Detailed Report", content.toString(), LocalDate.now());
    }
}