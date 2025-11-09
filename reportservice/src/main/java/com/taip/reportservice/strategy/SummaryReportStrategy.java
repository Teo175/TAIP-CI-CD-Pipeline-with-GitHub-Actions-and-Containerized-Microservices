package com.taip.reportservice.strategy;

import com.taip.reportservice.model.Report;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class SummaryReportStrategy implements ReportStrategy {
    @Override
    public Report generateReport(List<Map<String, Object>> data) {
        String content = "Total records: " + data.size();
        if (!data.isEmpty()) {
            content += "\nSample record: " + data.getFirst();
        }
        return new Report(null, "Summary Report", content, LocalDate.now());
    }
}
