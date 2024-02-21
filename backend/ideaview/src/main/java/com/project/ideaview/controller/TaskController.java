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

    @PostMapping("/dashboard/task")
    public Task recupFormArticle(@ModelAttribute Task task){
        this.taskService.saveTask(task);
        return task;
    }
}
