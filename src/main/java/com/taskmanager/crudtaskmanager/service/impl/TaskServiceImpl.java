package com.taskmanager.crudtaskmanager.service.impl;

import com.taskmanager.crudtaskmanager.TaskRepository.TaskRepository;
import com.taskmanager.crudtaskmanager.entity.Task;
import com.taskmanager.crudtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
         this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, boolean isCompleted) {
        Task task = mapTask(title, isCompleted);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, String title, boolean isCompleted) {
        Task task = mapTask(title, isCompleted);
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    private Task mapTask(String title, boolean isCompleted) {
        Task task = new Task();
        task.setCompleted(isCompleted);
        task.setTitle(title);
        task.setCreationDate(LocalDate.now());

        return task;
    }
}
