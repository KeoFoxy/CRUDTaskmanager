package com.taskmanager.crudtaskmanager.controller;

import com.taskmanager.crudtaskmanager.dto.TaskDto;
import com.taskmanager.crudtaskmanager.entity.Task;
import com.taskmanager.crudtaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task taskDto) {
        Task task = taskService.updateTask(taskDto.getId(), taskDto.getTitle(), taskDto.isCompleted());
        return ResponseEntity.ok(task);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
//
//    public void deleteTaskById(Long id) {
//
//    }
}
