package com.example.controller;

import com.example.model.Report;
import com.example.service.ReportService;

public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public Report getProjectReport(String projectId) {
        return null;
    }

    public Report getOverallReport() {
        return null;
    }
}
