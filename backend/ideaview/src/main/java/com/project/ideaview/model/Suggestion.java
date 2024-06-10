package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "suggestion_object", columnDefinition = "VARCHAR(255)")
    private String suggestionObject;

    @Column(name = "suggestion_content", columnDefinition = "VARCHAR(255)")
    private String contentSuggestion;

    @Column(name = "suggestion_status", columnDefinition = "VARCHAR(255)")
    private String statusSuggestion;

    @Column(name = "date_creation_suggestion")
    private String dateCreationSuggestion;

    @Column(name = "active", columnDefinition = "Boolean")
    private boolean active;
}
