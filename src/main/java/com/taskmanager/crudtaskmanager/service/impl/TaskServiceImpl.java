package com.taskmanager.crudtaskmanager.service.impl;

import com.taskmanager.crudtaskmanager.TaskRepository.TaskRepository;
import com.taskmanager.crudtaskmanager.entity.Task;
import com.taskmanager.crudtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskRepository getTaskRepository(TaskRepository taskRepository) {
        return taskRepository;
    }

    @Override
    public Task createTask(String title, boolean isCompleted) {
        Task task = new Task();
        task.setCompleted(isCompleted);
        task.setTitle(title);
        task.setCreationDate(LocalDate.now());

        return taskRepository.save(task);
    }
}
