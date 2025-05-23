package com.myapp.training_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "handbook_department")
public class Department {

    @Id
    @Column(name = "dept_root_id", nullable = false)
    private Integer id;

    @Column(name = "dept_root_name", nullable = false, length = Integer.MAX_VALUE)
    private String deptRootName;

}