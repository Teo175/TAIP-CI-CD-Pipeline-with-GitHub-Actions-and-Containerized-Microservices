package com.example.controller;

import com.example.model.Project;
import com.example.service.ProjectService;
import java.util.List;

public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public Project createProject(Project project) {
        return null;
    }

    public Project getProject(String id) {
        return null;
    }

    public List<Project> getAllProjects() {
        return null;
    }

    public Project updateProject(String id, Project project) {
        return null;
    }

    public void deleteProject(String id) {
    }
}
