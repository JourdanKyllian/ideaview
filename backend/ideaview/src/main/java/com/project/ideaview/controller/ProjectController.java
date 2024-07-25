package com.project.ideaview.controller;

import com.project.ideaview.dto.ProjectDto;
import com.project.ideaview.model.Project;
import com.project.ideaview.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * Route qui permet de faire l'ajout d'un projet<br>
     * @param projectDto
     * @return
     */
    @PostMapping("/save")
    public Project createProject(@RequestBody ProjectDto projectDto){
        return this.projectService.createProject(projectDto.getProject());
    }

    /**
     * Route qui recupère tout les projets d'un utilisateur
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Project getProject(@PathVariable Integer id){
        return this.projectService.byUserIdProject(id);
    }

    /**
     * Route qui permet de faire la mise a jour d'un projet<br>
     * @param projectDto
     * @return
     */
    @PostMapping("/dashboard/update/{id}")
    public Project updateProject(@RequestBody ProjectDto projectDto, @PathVariable Integer id){
        return this.projectService.updateProject(projectDto.getProject(), id);
    }

    /**
     * Route qui supprime un projet
     * @param id
     * @return
     */
    @DeleteMapping("/dashboard/delete/{id}")
    public Project deleteProject(@PathVariable Integer id){
        return this.projectService.deleteProject(id);
    }
}
