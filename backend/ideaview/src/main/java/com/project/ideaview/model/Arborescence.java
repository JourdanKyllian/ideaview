package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "arborescence")
public class Arborescence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "name_file", columnDefinition = "VARCHAR(255)")
    private String nameFile;

    @Column(name = "road_arborescence_file", columnDefinition = "VARCHAR(255)")
    private String roadArborescenceFile;
}
