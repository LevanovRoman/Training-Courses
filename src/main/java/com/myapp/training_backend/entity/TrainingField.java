package com.myapp.training_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "training_field")
public class TrainingField {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "training_field", nullable = false, length = Integer.MAX_VALUE)
    private String course;

    public Integer getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }
}