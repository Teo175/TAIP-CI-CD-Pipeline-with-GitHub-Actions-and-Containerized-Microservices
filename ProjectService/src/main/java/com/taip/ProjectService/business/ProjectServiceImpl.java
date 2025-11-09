package com.taip.ProjectService.business;

import com.taip.ProjectService.model.Project;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public Project createProject(Project project) { return null; }

    @Override
    public Project updateProject(Long id, Project project) { return null; }

    @Override
    public void deleteProject(Long id) {}

    @Override
    public List<Project> getAllProjects() { return null; }

    @Override
    public Project getProject(Long id) { return null; }
}
