package com.myapp.training_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "training_courses")
public class TrainingCoursesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dept_root_id")
    private HandbookDepartment department;

    @ManyToOne
    @JoinColumn(name = "appoint_id")
    private HandbookPosition position;

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

    public TrainingCoursesList() {
    }

    public TrainingCoursesList(Long id, HandbookDepartment department, HandbookPosition position, TrainingField course) {
        this.id = id;
        this.department = department;
        this.position = position;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public HandbookDepartment getDepartment() {
        return department;
    }

    public HandbookPosition getPosition() {
        return position;
    }

    public TrainingField getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartment(HandbookDepartment department) {
        this.department = department;
    }

    public void setPosition(HandbookPosition position) {
        this.position = position;
    }

    public void setCourse(TrainingField course) {
        this.course = course;
    }
}
