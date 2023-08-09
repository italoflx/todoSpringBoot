package com.buzzvel.toDoList.repository;

import com.buzzvel.toDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
