package com.project.ideaview.service;

import com.project.ideaview.model.Task;
import com.project.ideaview.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll(){
        return this.taskRepository.findAll();
    }

    public Task save(Task task){
        return this.taskRepository.save(task);
    }

    public Task byId(Integer id){
        return this.taskRepository.findById(id).orElse(new Task());
    }
}
