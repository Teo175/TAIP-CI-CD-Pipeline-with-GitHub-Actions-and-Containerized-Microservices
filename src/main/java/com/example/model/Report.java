package com.example.model;

import java.util.Date;

public class Report {
    private String reportId;
    private int projectCount;
    private int taskCount;
    private Date timestamp;

    public Report() {}

    public Report(String reportId, int projectCount, int taskCount, Date timestamp) {
        this.reportId = reportId;
        this.projectCount = projectCount;
        this.taskCount = taskCount;
        this.timestamp = timestamp;
    }

    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }
    public int getProjectCount() { return projectCount; }
    public void setProjectCount(int projectCount) { this.projectCount = projectCount; }
    public int getTaskCount() { return taskCount; }
    public void setTaskCount(int taskCount) { this.taskCount = taskCount; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}
