package com.taip.reportservice.controller;

import com.taip.reportservice.business.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/summary")
    public void generateSummaryReport(@RequestBody List<Map<String, Object>> data) {
    }


    @PostMapping("/detailed")
    public void generateDetailedReport(@RequestBody List<Map<String, Object>> data) {
    }

    @PostMapping("/performance")
    public void generatePerformanceReport(@RequestBody List<Map<String, Object>> data) {
    }
}
