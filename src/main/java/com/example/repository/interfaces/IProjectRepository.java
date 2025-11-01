package com.example.repository.interfaces;

import java.util.List;

import com.example.model.Project;

public interface IProjectRepository extends IRepository<Project, String> {
    List<Project> findByName(String name);
}