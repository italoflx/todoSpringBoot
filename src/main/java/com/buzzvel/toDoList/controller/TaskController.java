package com.buzzvel.toDoList.controller;

import com.buzzvel.toDoList.model.Task;
import com.buzzvel.toDoList.repository.TaskRepository;
import com.buzzvel.toDoList.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("task")
public class TaskController {
    TaskService service;
    TaskRepository repository;

    public TaskController(TaskService service, TaskRepository repository){
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public List<Task> list(){
        return this.service.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task t){
        return this.service.create(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task t, @PathVariable Long id){
        return this.service.update(t, id);
    }

    @GetMapping("{id}")
    public Task getById(@PathVariable Long id){
        return this.service.getById(id);
    }

    @PatchMapping("{id}")
    public Task toggleStatusTask(@PathVariable Long id){
        return this.service.toggleStatusTask(id);
    }
}
