package com.taip.taskservice.business;

import com.taip.taskservice.model.Task;
import com.taip.taskservice.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task testTask;

    @BeforeEach
    void setUp() {
        testTask = new Task(null, "Test Task", "Test Description", false, 1L);
    }

    @Test
    void createTask_ShouldReturnCreatedTask() {
        Task savedTask = new Task(1L, testTask.getName(), testTask.getDescription(), testTask.isCompleted(), testTask.getProjectId());
        when(taskRepository.save(testTask)).thenReturn(savedTask);
        
        Task result = taskService.createTask(testTask);
        
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(testTask.getName(), result.getName());
        verify(taskRepository).save(testTask);
    }

    @Test
    void updateTask_ShouldReturnUpdatedTask() {
        Task updatedTask = new Task(1L, "Updated Task", "Updated Description", true, 2L);
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);
        
        Task result = taskService.updateTask(1L, updatedTask);
        
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(updatedTask.getName(), result.getName());
        verify(taskRepository).save(any(Task.class));
    }

    @Test
    void deleteTask_ShouldNotThrowException() {
        doNothing().when(taskRepository).delete(1L);
        
        assertDoesNotThrow(() -> taskService.deleteTask(1L));
        
        verify(taskRepository).delete(1L);
    }

    @Test
    void getAllTasks_ShouldReturnListOfTasks() {
        List<Task> tasks = Arrays.asList(testTask);
        when(taskRepository.findAll()).thenReturn(tasks);
        
        List<Task> result = taskService.getAllTasks();
        
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(taskRepository).findAll();
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