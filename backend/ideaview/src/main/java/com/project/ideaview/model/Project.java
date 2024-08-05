package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    public Project() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Date dateCreation;
    private boolean active;

    @ManyToMany(mappedBy = "contributedProjects")
    private Set<Users> contributors;

    @ManyToMany(mappedBy = "adminProjects")
    private Set<Users> admins;
}