package com.taip.taskservice.controller;

import com.taip.taskservice.business.TaskService;
import com.taip.taskservice.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) { return null; }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) { return null; }

    @GetMapping
    public List<Task> getAllTasks() { return null; }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) { return null; }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {}
}
