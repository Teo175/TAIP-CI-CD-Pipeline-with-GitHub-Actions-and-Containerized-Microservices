package com.taip.ProjectService.controller;

import com.taip.ProjectService.business.ProjectService;
import com.taip.ProjectService.model.Project;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) { return null; }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) { return null; }

    @GetMapping
    public List<Project> getAllProjects() { return null; }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) { return null; }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {}
}
