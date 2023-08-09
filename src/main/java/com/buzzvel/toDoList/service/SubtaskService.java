package com.buzzvel.toDoList.service;

import com.buzzvel.toDoList.model.Subtask;
import com.buzzvel.toDoList.repository.SubtaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubtaskService {
    SubtaskRepository repository;
    EntityManager manager;

    public SubtaskService(SubtaskRepository repository, EntityManager manager){
        this.repository = repository;
        this.manager = manager;
    }

    public void create(Long idTask,Subtask e) {
        Query query = manager.createNativeQuery("INSERT INTO subtask (id_task, text) VALUES (?,?)");
        query.setParameter(1, idTask);
        query.setParameter(2, e.getText());
        query.executeUpdate();
    }

    public Subtask update(Subtask e, Long id) {
        Optional<Subtask> pessoaBanco = repository.findById(id);
        if (pessoaBanco.isPresent()){
            return this.repository.save(e);
        }else{
            throw new EntityNotFoundException();
        }
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<Subtask> list() {
        return this.repository.findAll();
    }

    public Subtask getById(Long id) {
        Optional<Subtask> pessoaBanco = repository.findById(id);
        if (pessoaBanco.isPresent()){
            return pessoaBanco.get();
        }else{
            throw new EntityNotFoundException();
        }
    }
}

