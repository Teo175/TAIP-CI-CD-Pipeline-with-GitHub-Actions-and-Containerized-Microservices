package com.example.repository.database;

import com.example.config.DynamoDBManager;
import com.example.model.Report;
import com.example.repository.interfaces.IReportRepository;

import software.amazon.awssdk.enhanced.dynamodb.*;
import java.util.*;

public class ReportRepositoryDynamoDB implements IReportRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<Report> reportTable;

    public ReportRepositoryDynamoDB() {
        this.enhancedClient = DynamoDBManager.getInstance().getEnhancedClient();
        this.reportTable = enhancedClient.table("Reports", TableSchema.fromBean(Report.class));
    }

    @Override
    public void save(Report report) {
        reportTable.putItem(report);
    }

    @Override
    public Report findById(String id) {
        return reportTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public List<Report> findAll() {
        List<Report> reports = new ArrayList<>();
        reportTable.scan().items().forEach(reports::add);
        return reports;
    }

    @Override
    public void delete(String id) {
        reportTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public boolean exists(String id) {
        return findById(id) != null;
    }
}
