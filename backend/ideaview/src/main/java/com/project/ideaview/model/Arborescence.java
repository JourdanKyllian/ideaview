package com.project.ideaview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "arborescence")
public class Arborescence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_insc
    private Integer id;
    private String fileName;
    private String fileExtension;
    private String fileSize;
    private String filePath;
    private String fileContent;
    private Date uploadDate;
}
