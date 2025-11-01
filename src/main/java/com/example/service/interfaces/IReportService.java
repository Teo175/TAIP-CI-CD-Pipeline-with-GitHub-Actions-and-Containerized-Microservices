package com.example.service.interfaces;

import java.util.List;

import com.example.model.Report;

public interface IReportService {
    Report generateReport();
    List<Report> listReports();
}