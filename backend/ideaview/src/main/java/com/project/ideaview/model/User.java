package com.project.ideaview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    public User() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "firstname", columnDefinition = "VARCHAR(255)")
    private String firstname;

    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    @JsonIgnore
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "active", columnDefinition = "Boolean")
    private Boolean active;

    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    private String role;
}
