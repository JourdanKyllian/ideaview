package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incr
    private Integer id;
    private String number;
    private String job;
    private String profile_picture;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
