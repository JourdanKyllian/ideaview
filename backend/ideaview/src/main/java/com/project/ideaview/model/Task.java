package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    public Task() {
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;

    @Column(name = "creator_task_name", columnDefinition = "VARCHAR(255)")
    private String creatorTaskName;

    @Column(name = "batch_task_name", columnDefinition = "VARCHAR(255)")
    private String batchTaskName;

    @Column(name = "descrition_task", columnDefinition = "VARCHAR(255)")
    private String taskDescription;

    @Column(name = "start_date_task", columnDefinition = "VARCHAR(255)")
    private String startDateTask;

    @Column(name = "end_date_task", columnDefinition = "VARCHAR(255)")
    private String endDateTask;

    @Column(name = "active", columnDefinition = "Boolean")
    private boolean active;
}
