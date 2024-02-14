package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "project_name", columnDefinition = "VARCHAR(255)")
    private String projectName;

    @Column(name = "project_description", columnDefinition = "VARCHAR(255)")
    private String projectDescription;

    @Column(name = "start_date_project", columnDefinition = "VARCHAR(255)")
    private String startDateProject;

    @Column(name = "end_date_project", columnDefinition = "VARCHAR(255)")
    private String endDateProject;

    @Column(name = "project_status", columnDefinition = "VARCHAR(255)")
    private String projectStatus;
}
