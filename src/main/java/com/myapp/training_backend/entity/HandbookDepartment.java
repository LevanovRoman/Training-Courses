package com.myapp.training_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "handbook_department")
public class HandbookDepartment {

    @Id
    @Column(name = "dept_root_id", nullable = false)
    private Integer id;

    @Column(name = "dept_root_name", nullable = false, length = Integer.MAX_VALUE)
    private String deptRootName;

    public Integer getId() {
        return id;
    }

    public String getDeptRootName() {
        return deptRootName;
    }
}