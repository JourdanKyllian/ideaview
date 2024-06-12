package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "suggestion")
public class Suggestion {
    public Suggestion() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;
    private String title;
    private String content;
    private String status;
    private Date dateCreation;
    private boolean active;
}
