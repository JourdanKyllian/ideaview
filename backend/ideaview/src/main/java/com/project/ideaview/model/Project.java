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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;
    private String name;
    private String description;
    private Date dateCreation;
    private boolean active;

    // Many-to-Many to User for contributors
    @ManyToMany(mappedBy = "contributedProjects")
    private Set<Users> contributors;

    // Many-to-Many to User for admins
    @ManyToMany(mappedBy = "adminProjects")
    private Set<Users> admins;
}