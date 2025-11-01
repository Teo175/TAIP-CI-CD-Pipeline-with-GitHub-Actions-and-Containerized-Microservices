package com.example.observer;

import com.example.model.Report;
import com.example.service.interfaces.IReportService;

public class ReportObserver implements Observer {
    private final IReportService reportService;

    public ReportObserver(IReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType() == EventType.TASK_CREATED ||
                event.getType() == EventType.TASK_UPDATED ||
                event.getType() == EventType.PROJECT_CREATED ||
                event.getType() == EventType.PROJECT_UPDATED) {

            Report report = reportService.generateReport();
        }
    }
}
