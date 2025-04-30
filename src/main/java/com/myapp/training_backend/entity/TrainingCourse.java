package com.myapp.training_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "training_courses")
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dept_root_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "appoint_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "training_field_id")
    private TrainingField course;

    @Override
    public String toString() {
        return "TrainingCoursesList{" +
                "id=" + id +
                ", department=" + department +
                ", position=" + position +
                ", course=" + course +
                '}';
    }
}
