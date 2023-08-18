package com.taskmanager.crudtaskmanager.TaskRepository;

import com.taskmanager.crudtaskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
