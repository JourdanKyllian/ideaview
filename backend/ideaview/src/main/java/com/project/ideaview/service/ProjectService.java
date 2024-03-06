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

    public List<Project> getAllProject(){
        return this.projectRepository.findAll();
    }

    /**
     * Méthode qui permet de faire l'ajout et la modification<br>
     * - l'ajout : id = null <br>
     * - modification : id != null
     * @param project
     * @return
     */
    public Project saveProject(Project project){
        return this.projectRepository.save(project);
    }

    /**
     * recupere toute les tache d'un projet
     * @param id
     * @return
     */
    public Project byUserIdProject(Integer id){
        return this.projectRepository.findById(id).orElse(new Project());
    }
}
