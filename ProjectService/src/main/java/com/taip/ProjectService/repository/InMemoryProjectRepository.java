package com.taip.ProjectService.repository;

import com.taip.ProjectService.model.Project;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {
    private final Map<Long, Project> projects = new HashMap<>();
    private long currentId = 1L;

    @Override
    public Project save(Project project) {
        if (project.getId() == null) {
            project.setId(currentId++);
        }
        projects.put(project.getId(), project);
        return project;
    }

    @Override
    public Project findById(Long id) {
        return projects.get(id);
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public void delete(Long id) {
        projects.remove(id);
    }
}