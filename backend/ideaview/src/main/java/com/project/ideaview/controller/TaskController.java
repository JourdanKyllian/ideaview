package com.project.ideaview.controller;

import com.project.ideaview.model.Task;
import com.project.ideaview.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> task(){
        return this.taskService.getAll();
    }

    @DeleteMapping("/task/{id}")
    public Task deleteTask(@PathVariable Integer id){
        Task task = this.taskService.byId(id);
        task.setActive(!task.isActive());
        this.taskService.save(task);
        return task;
    }

    @PostMapping("/dashboard/task")
    public Task recupFormArticle(@ModelAttribute Task task){
        this.taskService.save(task);
        return task;
    }
}
