package com.taip.ProjectService.business;

import com.taip.ProjectService.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
    List<Project> getAllProjects();
    Project getProject(Long id);
}
