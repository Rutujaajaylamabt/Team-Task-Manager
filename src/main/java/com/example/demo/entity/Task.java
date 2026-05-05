package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // TODO / IN_PROGRESS / DONE
    private LocalDate dueDate;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private Project project;
}