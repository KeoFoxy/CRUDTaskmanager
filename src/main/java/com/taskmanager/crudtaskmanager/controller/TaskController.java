package com.taskmanager.crudtaskmanager.controller;

import com.taskmanager.crudtaskmanager.dto.TaskDto;
import com.taskmanager.crudtaskmanager.entity.Task;
import com.taskmanager.crudtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.createTask(taskDto.getTitle(), taskDto.isCompleted());
        return ResponseEntity.ok(task);
    }

//    public Task updateTask(Task taskDto, Long taskId) {
//
//    }
//
//    public Task getTaskById(Long id) {
//
//    }
//
//    public void deleteTaskById(Long id) {
//
//    }
}
