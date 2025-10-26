package com.example.factory;

import com.example.model.Report;

// Design Pattern: Factory
public class ReportFactory {

    public Report createReport(String type) {
        return new Report();
    }
}