package com.project.ideaview.controller;

import com.project.ideaview.dto.ProjectDto;
import com.project.ideaview.model.Project;
import com.project.ideaview.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * Route qui permet de faire l'ajout et la modification d'yn projet<br>
     * @param projectDto
     * @return
     */
    @PostMapping("/projectsave")
    public Project createProject(@RequestBody ProjectDto projectDto){
        return this.projectService.createProject(projectDto.getProject());
    }

    /**
     * Route qui recupère tout les projets d'un utilisateur
     * @param id
     * @return
     */
    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable Integer id){
        return this.projectService.byUserIdProject(id);
    }

    /**
     * Route qui supprime un projet
     * @param id
     * @return
     */
    @DeleteMapping("/dashboard/projectdel/{id}")
    public Project deleteProject(@PathVariable Integer id){
        return this.projectService.deleteProject(id);
    }
}
