package com.project.ideaview.controller;

import com.project.ideaview.model.Project;
import com.project.ideaview.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * methode qui supprime un projet
     * @param id
     * @return
     */
    @DeleteMapping("/project/{id}")
    public Project deleteProject(@PathVariable Integer id){
        return this.projectService.deleteProject(id);
    }

    /**
     * Page qui permet de faire l'ajout et la modification<br>
     * @param project
     * @return
     */
    @PostMapping("/dashboard/project")
    public Project recupFormProject(@ModelAttribute Project project){
        this.projectService.saveProject(project);
        return project;
    }

    /**
     * recupere tout les projets d'un utilisateur
     * @param id
     * @return
     */
    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable Integer id){
        return this.projectService.byUserIdProject(id);
    }

}
