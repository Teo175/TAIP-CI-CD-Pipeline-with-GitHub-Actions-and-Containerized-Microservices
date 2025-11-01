package com.example.repository.database;

import com.example.config.DynamoDBManager;
import com.example.model.Task;
import com.example.repository.interfaces.ITaskRepository;

import software.amazon.awssdk.enhanced.dynamodb.*;
import java.util.*;

public class TaskRepositoryDynamoDB implements ITaskRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<Task> taskTable;

    public TaskRepositoryDynamoDB() {
        this.enhancedClient = DynamoDBManager.getInstance().getEnhancedClient();
        this.taskTable = enhancedClient.table("Tasks", TableSchema.fromBean(Task.class));
    }

    @Override
    public void save(Task task) {
        taskTable.putItem(task);
    }

    @Override
    public Task findById(String id) {
        return taskTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        taskTable.scan().items().forEach(tasks::add);
        return tasks;
    }

    @Override
    public void delete(String id) {
        taskTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public boolean exists(String id) {
        return findById(id) != null;
    }

    @Override
    public List<Task> findByProjectId(String projectId) {
        List<Task> results = new ArrayList<>();
        taskTable.scan().items().forEach(task -> {
            if (projectId.equals(task.getProjectId())) results.add(task);
        });
        return results;
    }
}
