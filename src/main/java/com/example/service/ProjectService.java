package com.example.service;

import java.util.*;

import com.example.model.Project;
import com.example.observer.Event;
import com.example.observer.EventBus;
import com.example.observer.EventType;
import com.example.repository.interfaces.IProjectRepository;
import com.example.service.interfaces.IProjectService;

import java.util.*;

public class ProjectService implements IProjectService {
    private final IProjectRepository projectRepo;
    private final EventBus eventBus;

    public ProjectService(IProjectRepository projectRepo, EventBus eventBus) {
        this.projectRepo = projectRepo;
        this.eventBus = eventBus;
    }

    @Override
    public void createProject(Project p) {
        if (p == null || p.getProjectId() == null) throw new IllegalArgumentException("Project or id null");
        projectRepo.save(p);
        eventBus.publish(new Event(EventType.PROJECT_CREATED, p));
    }

    @Override
    public void updateProject(String projectId, String name, String description) {
        Project existing = projectRepo.findById(projectId);
        if (existing == null) throw new NoSuchElementException("Project not found: " + projectId);
        existing.setName(name);
        existing.setDescription(description);
        projectRepo.save(existing);
        eventBus.publish(new Event(EventType.PROJECT_UPDATED, existing));
    }

    @Override
    public void deleteProject(String projectId) {
        Project p = projectRepo.findById(projectId);
        projectRepo.delete(projectId);
        eventBus.publish(new Event(EventType.PROJECT_DELETED, p));
    }

    @Override
    public Project getProject(String projectId) {
        return projectRepo.findById(projectId);
    }

    @Override
    public List<Project> listProjects() {
        return new ArrayList<>(projectRepo.findAll());
    }
}
