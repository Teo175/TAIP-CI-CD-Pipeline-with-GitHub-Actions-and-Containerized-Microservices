package com.taip.taskservice.business;

import com.taip.taskservice.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task testTask;

    @BeforeEach
    void setUp() {
        testTask = new Task(null, "Test Task", "Test Description", false, 1L);
    }

    @Test
    void createTask_ShouldReturnCreatedTask() {
        Task result = taskService.createTask(testTask);
        
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(testTask.getName(), result.getName());
        assertEquals(testTask.getDescription(), result.getDescription());
        assertEquals(testTask.isCompleted(), result.isCompleted());
        assertEquals(testTask.getProjectId(), result.getProjectId());
    }

    @Test
    void updateTask_ShouldReturnUpdatedTask() {
        Task updatedTask = new Task(1L, "Updated Task", "Updated Description", true, 2L);
        
        Task result = taskService.updateTask(1L, updatedTask);
        
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(updatedTask.getName(), result.getName());
        assertEquals(updatedTask.getDescription(), result.getDescription());
        assertEquals(updatedTask.isCompleted(), result.isCompleted());
        assertEquals(updatedTask.getProjectId(), result.getProjectId());
    }

    @Test
    void deleteTask_ShouldNotThrowException() {
        assertDoesNotThrow(() -> taskService.deleteTask(1L));
    }

    @Test
    void getAllTasks_ShouldReturnListOfTasks() {
        List<Task> result = taskService.getAllTasks();
        
        assertNotNull(result);
        assertInstanceOf(List.class, result);
    }

    @Test
    void createTask_WithNullTask_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(null));
    }

    @Test
    void updateTask_WithNullId_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask(null, testTask));
    }

    @Test
    void deleteTask_WithNullId_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask(null));
    }
}