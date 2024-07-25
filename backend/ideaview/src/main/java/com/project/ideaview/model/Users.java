package com.project.ideaview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class Users implements UserDetails {
    public Users() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incr
    private Integer id;
    private String token;
    private String lastname;
    private String firstname;
    @JsonIgnore
    private String email;
    private String password;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Project owner;

    @ManyToMany
    @JoinTable(
            name = "project_has_contributor",
            joinColumns = @JoinColumn(name = "Users_id"),
            inverseJoinColumns = @JoinColumn(name = "Project_id")
    )
    private Set<Project> contributedProjects;

    @ManyToMany
    @JoinTable(
            name = "project_has_admin",
            joinColumns = @JoinColumn(name = "Users_id"),
            inverseJoinColumns = @JoinColumn(name = "Project_id")
    )
    private Set<Project> adminProjects;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    private boolean active;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
