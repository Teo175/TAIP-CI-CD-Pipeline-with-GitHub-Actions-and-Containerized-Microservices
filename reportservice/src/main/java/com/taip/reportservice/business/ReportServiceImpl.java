package com.taip.reportservice.business;

import com.taip.reportservice.factory.ReportStrategyFactory;
import com.taip.reportservice.strategy.ReportStrategy;
import com.taip.reportservice.strategy.StrategyType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    private ReportStrategy strategy;

    public void setReportStrategy(StrategyType type) {
        this.strategy = ReportStrategyFactory.createStrategy(type);
    }

    @Override
    public void generateReport(List<Map<String, Object>> data) {
        if (strategy != null) {
            strategy.generateReport(data);
        }
    }
}

