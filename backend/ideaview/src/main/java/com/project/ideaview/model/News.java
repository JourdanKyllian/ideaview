package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
    public News() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "news_content", columnDefinition = "VARCHAR(255)")
    private String newsContent;

    @Column(name = "date_creation_news", columnDefinition = "VARCHAR(255)")
    private String dateCreationNews;

    @Column(name = "active", columnDefinition = "Boolean")
    private boolean active;
}
