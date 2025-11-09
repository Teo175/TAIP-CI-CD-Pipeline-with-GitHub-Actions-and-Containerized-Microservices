package com.taip.ProjectService.repository;

import com.taip.ProjectService.model.Project;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProjectRepository {
    private final Map<Long, Project> projects = new HashMap<>();
    private long currentId = 1L;

    public Project save(Project project) {
        return null;
    }

    public Project findById(Long id) {
        return null;
    }

    public List<Project> findAll() {
        return null;
    }

    public void delete(Long id) {
    }
}

