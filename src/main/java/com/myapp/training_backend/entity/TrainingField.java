package com.myapp.training_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training_field")
public class TrainingField {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "training_field", nullable = false, length = Integer.MAX_VALUE)
    private String course;
}