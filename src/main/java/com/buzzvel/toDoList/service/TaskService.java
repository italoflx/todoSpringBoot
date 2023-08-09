package com.buzzvel.toDoList.service;

import com.buzzvel.toDoList.model.Task;
import com.buzzvel.toDoList.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public Task create(Task e) {
        return this.repository.saveAndFlush(e);
    }

    public Task update(Task e, Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()){
            return this.repository.save(e);
        }else{
            throw new EntityNotFoundException();
        }
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<Task> list() {
        return this.repository.findAll();
    }

    public Task getById(Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()){
            return task.get();
        }else{
            throw new EntityNotFoundException();
        }
    }

    public Task toggleStatusTask(Long id){
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()){
            task.get().setConcluded(!task.get().getConcluded());
            return repository.saveAndFlush(task.get());
        }else{
            throw new EntityNotFoundException();
        }
    }
}
