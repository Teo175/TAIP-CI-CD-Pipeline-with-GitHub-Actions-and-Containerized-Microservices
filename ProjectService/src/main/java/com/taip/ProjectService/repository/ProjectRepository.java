package com.taip.ProjectService.repository;

import com.taip.ProjectService.model.Project;
import java.util.List;

public interface ProjectRepository {
    Project save(Project project);
    Project findById(Long id);
    List<Project> findAll();
    void delete(Long id);
}

