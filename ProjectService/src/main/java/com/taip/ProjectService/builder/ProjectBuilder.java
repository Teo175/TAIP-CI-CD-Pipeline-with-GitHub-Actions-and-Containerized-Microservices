package com.taip.ProjectService.builder;

import com.taip.ProjectService.model.Project;

import java.time.LocalDate;

public class ProjectBuilder {
    private Long id;
    private String name;
    private String description;
    private LocalDate deadline;

    public ProjectBuilder setId(Long id) { this.id = id; return this; }
    public ProjectBuilder setName(String name) { this.name = name; return this; }
    public ProjectBuilder setDescription(String description) { this.description = description; return this; }
    public ProjectBuilder setDeadline(LocalDate deadline) { this.deadline = deadline; return this; }

    public Project build() {
        return new Project(id, name, description, deadline);
    }
}
