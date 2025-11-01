package com.example.service;

import com.example.model.Project;
import com.example.observer.EventBus;
import com.example.repository.inmemory.InMemoryProjectRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectServiceTest {
    private ProjectService projectService;
    private InMemoryProjectRepository projectRepo;
    private EventBus eventBus;

    @Before
    public void setup() {
        projectRepo = new InMemoryProjectRepository();
        eventBus = new EventBus();
        projectService = new ProjectService(projectRepo, eventBus);
    }

    @Test
    public void testCreateProject() {
        Project p = new Project("p1", "Project 1", "Description", new Date(), null);
        projectService.createProject(p);

        Project retrieved = projectService.getProject("p1");
        assertNotNull(retrieved);
        assertEquals("p1", retrieved.getProjectId());
        assertEquals("Project 1", retrieved.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateProjectWithNullId() {
        Project p = new Project(null, "Project", "Desc", new Date(), null);
        projectService.createProject(p);
    }

    @Test
    public void testReadProject() {
        Project p = new Project("p1", "Project 1", "Desc", new Date(), null);
        projectRepo.save(p);

        Project result = projectService.getProject("p1");
        assertNotNull(result);
        assertEquals("p1", result.getProjectId());
    }

    @Test
    public void testUpdateProject() {
        Project p = new Project("p1", "Old Name", "Old Desc", new Date(), null);
        projectRepo.save(p);

        projectService.updateProject("p1", "New Name", "New Desc");

        Project updated = projectService.getProject("p1");
        assertEquals("New Name", updated.getName());
        assertEquals("New Desc", updated.getDescription());
    }

    @Test(expected = Exception.class)
    public void testUpdateNonExistentProject() {
        projectService.updateProject("nonexistent", "Name", "Desc");
    }

    @Test
    public void testDeleteProject() {
        Project p = new Project("p1", "Project", "Desc", new Date(), null);
        projectRepo.save(p);

        projectService.deleteProject("p1");

        assertNull(projectService.getProject("p1"));
    }

    @Test
    public void testListProjects() {
        projectRepo.save(new Project("p1", "Project 1", "Desc1", new Date(), null));
        projectRepo.save(new Project("p2", "Project 2", "Desc2", new Date(), null));

        List<Project> projects = projectService.listProjects();
        assertEquals(2, projects.size());
    }

    @Test
    public void testListProjectsEmpty() {
        List<Project> projects = projectService.listProjects();
        assertEquals(0, projects.size());
    }
}
