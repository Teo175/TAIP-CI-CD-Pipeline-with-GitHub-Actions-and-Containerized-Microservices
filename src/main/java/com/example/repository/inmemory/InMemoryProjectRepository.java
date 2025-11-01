package com.example.repository.inmemory;

import java.util.*;
import java.util.stream.Collectors;

import com.example.model.Project;
import com.example.repository.interfaces.IProjectRepository;

public class InMemoryProjectRepository implements IProjectRepository {
    private final Map<String, Project> store = new HashMap<>();

    @Override
    public void save(Project project) { store.put(project.getProjectId(), project); }

    @Override
    public Project findById(String id) { return store.get(id); }

    @Override
    public Collection<Project> findAll() { return store.values(); }

    @Override
    public void delete(String id) { store.remove(id); }

    @Override
    public boolean exists(String id) { return store.containsKey(id); }

    @Override
    public List<Project> findByName(String name) {
        return store.values().stream()
                .filter(p -> p.getName() != null && p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}