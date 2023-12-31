package com.taskmanager.crudtaskmanager.service;

import com.taskmanager.crudtaskmanager.entity.Task;

public interface TaskService {
    Task createTask(String title, boolean isCompleted);

    Task updateTask(Long id, String title, boolean isCompleted);

    Task getTaskById(Long id);

    void deleteById(Long id);
}
