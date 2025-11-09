package com.taip.reportservice.business;

import com.taip.reportservice.factory.ReportStrategyFactory;
import com.taip.reportservice.model.Report;
import com.taip.reportservice.repository.ReportRepository;
import com.taip.reportservice.strategy.ReportStrategy;
import com.taip.reportservice.strategy.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report generateReport(StrategyType type, List<Map<String, Object>> data) {
        ReportStrategy strategy = ReportStrategyFactory.createStrategy(type);
        Report report = strategy.generateReport(data);
        return reportRepository.save(report);
    }
}

