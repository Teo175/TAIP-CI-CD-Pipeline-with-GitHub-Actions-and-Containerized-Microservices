package com.taip.ProjectService.business;

import com.taip.ProjectService.model.Project;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceImplTest {
    
    private final ProjectServiceImpl projectService = new ProjectServiceImpl();

    @Test
    void createProject_ShouldReturnCreatedProject() {
        Project project = new Project(null, "Test Project", "Description", LocalDate.now());
        
        Project result = projectService.createProject(project);
        
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Test Project", result.getName());
    }

    @Test
    void updateProject_ShouldReturnUpdatedProject() {
        Project project = new Project(1L, "Updated Project", "Updated Description", LocalDate.now());
        
        Project result = projectService.updateProject(1L, project);
        
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated Project", result.getName());
    }

    @Test
    void getProject_ShouldReturnProject() {
        Project result = projectService.getProject(1L);
        
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void getAllProjects_ShouldReturnProjectList() {
        List<Project> result = projectService.getAllProjects();
        
        assertNotNull(result);
    }

    @Test
    void deleteProject_ShouldNotThrowException() {
        assertDoesNotThrow(() -> projectService.deleteProject(1L));
    }
}