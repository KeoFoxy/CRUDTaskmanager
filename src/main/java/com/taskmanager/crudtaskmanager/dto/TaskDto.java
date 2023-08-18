package com.taskmanager.crudtaskmanager.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String title;
    private boolean completed;
}
