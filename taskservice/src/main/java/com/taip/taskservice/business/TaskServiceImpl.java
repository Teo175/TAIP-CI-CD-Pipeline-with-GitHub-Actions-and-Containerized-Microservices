package com.taip.taskservice.business;

import com.taip.taskservice.model.Task;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }
}
