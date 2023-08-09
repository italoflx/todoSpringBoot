package com.buzzvel.toDoList.repository;

import com.buzzvel.toDoList.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
}
