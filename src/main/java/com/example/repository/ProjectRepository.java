package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.model.Project;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findById(String id);
    List<Project> findAll();
    void deleteById(String id);
    boolean existsById(String id);
}
