package com.example.repository.database;

import com.example.aop.LoggingAspect;
import com.example.model.Project;
import com.example.config.DynamoDBManager;
import com.example.repository.interfaces.IProjectRepository;

import software.amazon.awssdk.enhanced.dynamodb.*;

import java.util.*;

public class ProjectRepositoryDynamoDB implements IProjectRepository {

    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<Project> projectTable;
    private final LoggingAspect logger = new LoggingAspect();

    public ProjectRepositoryDynamoDB() {
        this.enhancedClient = DynamoDBManager.getInstance().getEnhancedClient();
        this.projectTable = enhancedClient.table("Projects", TableSchema.fromBean(Project.class));
    }

    @Override
    public void save(Project project) {
        projectTable.putItem(project);
    }

    @Override
    public Project findById(String id) {
        return projectTable.getItem(Key.builder().partitionValue(id).build());
    }

    @Override
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        projectTable.scan().items().forEach(projects::add);
        return projects;
    }

    @Override
    public void delete(String id) {
        projectTable.deleteItem(Key.builder().partitionValue(id).build());
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public List<Project> findByName(String name) {
        return List.of();
    }
}
