package com.buzzvel.toDoList.controller;

import com.buzzvel.toDoList.model.Subtask;
import com.buzzvel.toDoList.repository.SubtaskRepository;
import com.buzzvel.toDoList.service.SubtaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("subtask")
public class SubtaskController {
    SubtaskService service;
    SubtaskRepository repository;

    public SubtaskController(SubtaskService service, SubtaskRepository repository){
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public List<Subtask> list(){
        return this.service.list();
    }

    @PostMapping("/{idTask}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Subtask t, @PathVariable Long idTask){
        this.service.create(idTask, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

    @PutMapping("/{id}")
    public Subtask update(@RequestBody Subtask t, @PathVariable Long id){
        return this.service.update(t, id);
    }

    @GetMapping("{id}")
    public Subtask getById(@PathVariable Long id){
        return this.service.getById(id);
    }
}

