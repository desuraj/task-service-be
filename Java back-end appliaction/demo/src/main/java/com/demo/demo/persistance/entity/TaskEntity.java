package com.demo.demo.persistance.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task", schema = "public")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
}
