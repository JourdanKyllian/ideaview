package com.project.ideaview.controller;

import com.project.ideaview.model.Project;
import com.project.ideaview.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public List<Project> project(){
        return this.projectService.getAllProject();
    }

    @DeleteMapping("/project/{id}")
    public Project deleteProject(@PathVariable Integer id){
        Project project = this.projectService.byUserIdProject(id);
        project.setActive(!project.isActive());
        this.projectService.saveProject(project);
        return project;
    }

    @PostMapping("/dashboard/project")
    public Project recupFormProject(@ModelAttribute Project project){
        this.projectService.saveProject(project);
        return project;
    }
}
