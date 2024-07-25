package com.project.ideaview.service;

import com.project.ideaview.model.Project;
import com.project.ideaview.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Méthode qui permet de faire l'ajout d'un projet<br>
     * - l'ajout : id = null <br>
     * - modification : id != null
     * @param project
     * @return
     */
    public Project createProject(Project project){
        return this.projectRepository.save(project);
    }

    /**
     * recupere tout les projets d'un utilisateur
     * @param id
     * @return
     */
    public Project byUserIdProject(Integer id){
        return this.projectRepository.findById(id).orElse(new Project());
    }


    /**
     * Methode qui permet de faire la mise a jour d'un projet<br>
     * @param project
     * @param id
     * @return
     */
    public Project updateProject(Project project, Integer id){
        Project projectUpdate = this.projectRepository.findById(id).orElse(new Project());
        //projectUpdate.setName(project.getName()); pas de mise a jour du nom
        projectUpdate.setDescription(project.getDescription());
        return this.projectRepository.save(projectUpdate);
    }

    /**
     * Méthode qui delete un projet en passant active à false
     * @param id
     * @return
     */
    public Project deleteProject(Integer id){
        Project project = this.projectRepository.findById(id).orElse(new Project());
        project.setActive(false);
        return this.projectRepository.save(project);
    }
}
