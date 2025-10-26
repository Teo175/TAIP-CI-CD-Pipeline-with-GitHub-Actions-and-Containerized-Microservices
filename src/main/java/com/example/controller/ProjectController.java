package com.example.controller;

import java.util.List;

import com.example.model.Project;
import com.example.service.ProjectService;

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
