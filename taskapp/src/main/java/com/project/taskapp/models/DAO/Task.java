package com.project.taskapp.models.DAO;

import jakarta.persistence.*;

//that file called DAO (data access)

/**
 * This class represents the Task entity (table in database)
 */
@Entity // Marks this class as a JPA entity (table)
@Table(name = "task") // Optional: specify table name
public class Task {
    @Id // Marks this field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto-generates ID using database auto-increment
    private Long id;

    @Column(nullable = false)
    // Column cannot be null
    private String title;

    @Column(length = 1000)
    // Allows longer description text
    private String description;

    @Enumerated(EnumType.STRING)
    // Stores enum as String (NOT ordinal)
    @Column(nullable = false)
    private Status status;

    @Column(name = "assigned_to")
    // Custom column name
    private String assignedTo;

    // Default constructor (required by JPA)
    public Task() {
    }

    // Constructor without ID (used when creating new task)
    public Task(String title, String description, Status status, String assignedTo) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

}
