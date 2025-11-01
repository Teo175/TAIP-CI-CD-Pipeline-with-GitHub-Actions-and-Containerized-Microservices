package com.example.service;

import com.example.model.Project;
import com.example.model.Task;
import com.example.observer.EventBus;
import com.example.repository.inmemory.InMemoryProjectRepository;
import com.example.repository.inmemory.InMemoryTaskRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService taskService;
    private InMemoryTaskRepository taskRepo;
    private InMemoryProjectRepository projectRepo;
    private EventBus eventBus;

    @Before
    public void setup() {
        taskRepo = new InMemoryTaskRepository();
        projectRepo = new InMemoryProjectRepository();
        eventBus = new EventBus();
        taskService = new TaskService(taskRepo, projectRepo, eventBus);

        Project p = new Project("p1", "Test Project", "Desc", new Date(), null);
        projectRepo.save(p);
    }

    @Test
    public void testCreateTask() {
        Task t = new Task("t1", "p1", "Task 1", "TODO", new Date());
        taskService.createTask(t);

        Task retrieved = taskService.getTask("t1");
        assertNotNull(retrieved);
        assertEquals("t1", retrieved.getTaskId());
        assertEquals("p1", retrieved.getProjectId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithNullId() {
        Task t = new Task(null, "p1", "Task", "TODO", new Date());
        taskService.createTask(t);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithNonExistentProject() {
        Task t = new Task("t1", "nonexistent", "Task", "TODO", new Date());
        taskService.createTask(t);
    }

    @Test
    public void testReadTask() {
        Task t = new Task("t1", "p1", "Task 1", "TODO", new Date());
        taskRepo.save(t);

        Task result = taskService.getTask("t1");
        assertNotNull(result);
        assertEquals("t1", result.getTaskId());
    }

    @Test
    public void testUpdateTaskStatus() {
        Task t = new Task("t1", "p1", "Task 1", "TODO", new Date());
        taskRepo.save(t);

        taskService.updateTaskStatus("t1", "IN_PROGRESS");

        Task updated = taskService.getTask("t1");
        assertEquals("IN_PROGRESS", updated.getStatus());
    }

    @Test(expected = Exception.class)
    public void testUpdateNonExistentTask() {
        taskService.updateTaskStatus("nonexistent", "DONE");
    }

    @Test
    public void testDeleteTask() {
        Task t = new Task("t1", "p1", "Task", "TODO", new Date());
        taskRepo.save(t);

        taskService.deleteTask("t1");

        assertNull(taskService.getTask("t1"));
    }

    @Test
    public void testListTasksByProject() {
        taskRepo.save(new Task("t1", "p1", "Task 1", "TODO", new Date()));
        taskRepo.save(new Task("t2", "p1", "Task 2", "DONE", new Date()));

        List<Task> tasks = taskService.listTasksByProject("p1");
        assertEquals(2, tasks.size());
    }

    @Test
    public void testTaskLinkedToProject() {
        Task t = new Task("t1", "p1", "Task 1", "TODO", new Date());
        taskService.createTask(t);

        Project p = projectRepo.findById("p1");
        assertNotNull(p);
        assertEquals(1, p.getTasks().size());
        assertEquals("t1", p.getTasks().get(0).getTaskId());
    }
}
