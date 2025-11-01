package com.example.service.interfaces;

import java.util.List;

import com.example.model.Project;

public interface IProjectService {
    void createProject(Project p);
    void updateProject(String projectId, String name, String description);
    void deleteProject(String projectId);
    Project getProject(String projectId);
    List<Project> listProjects();
}