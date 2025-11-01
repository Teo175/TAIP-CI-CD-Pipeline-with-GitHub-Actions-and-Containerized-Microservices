package com.example.repository.interfaces;

import java.util.List;

import com.example.model.Task;

public interface ITaskRepository extends IRepository<Task, String> {
    List<Task> findByProjectId(String projectId);
}
