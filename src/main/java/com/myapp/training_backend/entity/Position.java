package com.myapp.training_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "handbook_position")
public class Position {

    @Id
    @Column(name = "appoint_id", nullable = false)
    private Integer id;

    @Column(name = "appoint_name", nullable = false, length = 255)
    private String name;
}