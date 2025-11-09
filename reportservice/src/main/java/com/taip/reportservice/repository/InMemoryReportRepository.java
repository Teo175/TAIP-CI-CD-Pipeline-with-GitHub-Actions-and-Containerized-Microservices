package com.taip.reportservice.repository;

import com.taip.reportservice.model.Report;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryReportRepository implements ReportRepository {
    private final Map<Long, Report> reports = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Report save(Report report) {
        if (report.getId() == null) {
            report.setId(idGenerator.getAndIncrement());
        }
        reports.put(report.getId(), report);
        return report;
    }

    @Override
    public Report findById(Long id) {
        return reports.get(id);
    }

    @Override
    public List<Report> findAll() {
        return new ArrayList<>(reports.values());
    }

    @Override
    public void delete(Long id) {
        reports.remove(id);
    }
}