package com.project.ideaview.service;

import com.project.ideaview.model.Task;
import com.project.ideaview.model.User;
import com.project.ideaview.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return this.taskRepository.findAll();
    }

    /**
     * Méthode qui permet de faire l'ajout et la modification<br>
     * - l'ajout : id = null <br>
     * - modification : id != null
     * @param task
     * @return
     */
    public Task saveTask(Task task){
        return this.taskRepository.save(task);
    }

    /**
     * recupere toute les tache d'un projet
     * @param id
     * @return
     */
    public Task byUserIdTask(Integer id){
        return this.taskRepository.findById(id).orElse(new Task());
    }
}
