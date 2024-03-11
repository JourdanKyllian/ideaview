package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administrator")
public class Administrator {
    public Administrator() {
        this.isAdmin = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "is_admin", columnDefinition = "Boolean")
    private boolean isAdmin;
}
