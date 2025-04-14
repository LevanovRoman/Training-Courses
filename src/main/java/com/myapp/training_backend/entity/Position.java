package com.myapp.training_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "handbook_position")
public class Position {

    @Id
    @Column(name = "appoint_id", nullable = false)
    private Integer id;

    @Column(name = "appoint_name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}