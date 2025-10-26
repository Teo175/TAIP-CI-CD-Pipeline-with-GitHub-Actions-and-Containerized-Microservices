package com.example.service;

import com.example.model.Project;
import com.example.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return null;
    }

    public Optional<Project> getProjectById(String id) {
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
