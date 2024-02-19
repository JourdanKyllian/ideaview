package com.project.ideaview.controller;

import com.project.ideaview.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String task(){
        return "task";
    }


    @PostMapping("/dashboard/task")
    public void recupTask() {
        System.out.println(taskService.getAll());
    }
}
