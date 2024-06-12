package com.project.ideaview.dto;

import com.project.ideaview.model.Project;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectDto {

    // contenu du formulaire

    private String name;
    private String description;


    public Project getProject() {
        Project project = new Project();
        project.setName(this.name);
        project.setDescription(this.description);
        project.setDateCreation(new Date());
        project.setActive(true);
        return project;
    }
}
