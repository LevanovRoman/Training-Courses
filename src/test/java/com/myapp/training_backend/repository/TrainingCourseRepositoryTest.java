package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCourse;
import com.myapp.training_backend.entity.TrainingField;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class TrainingCourseRepositoryTest {

    @Autowired
    private TrainingCourseRepository trainingCourseRepository;
    @Autowired
    private TrainingFieldRepository trainingFieldRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Test
    public void TrainingCourseRepository_FindById_ReturnTrainingCourse(){
        Department department = Department.builder().id(1).deptRootName("departmentName").build();
        Position position = Position.builder().id(1).name("positionName").build();
        TrainingField trainingField = TrainingField.builder().id(1).course("trainingField").build();

        TrainingCourse trainingCourse = TrainingCourse.builder()
                .department(department)
                .position(position)
                .course(trainingField)
                .build();
        trainingCourseRepository.save(trainingCourse);

        TrainingCourse trainingCourseFounded = trainingCourseRepository.findById(trainingCourse.getId()).get();

        Assertions.assertThat(trainingCourseFounded).isNotNull();
    }

    @Test
    public void TrainingCourseRepository_FindAllByDepartmentAndPosition_ReturnMoreThanOne() {
        Department department = Department.builder().id(1).deptRootName("departmentName").build();
        Position position = Position.builder().id(1).name("positionName").build();
        TrainingField trainingField1 = TrainingField.builder().id(1).course("trainingField").build();
        TrainingField trainingField2 = TrainingField.builder().id(2).course("trainingField2").build();

        departmentRepository.save(department);
        positionRepository.save(position);
        trainingFieldRepository.save(trainingField1);
        trainingFieldRepository.save(trainingField2);

        TrainingCourse trainingCourse1 = TrainingCourse.builder()
                .department(department)
                .position(position)
                .course(trainingField1)
                .build();
        TrainingCourse trainingCourse2 = TrainingCourse.builder()
                .department(department)
                .position(position)
                .course(trainingField2)
                .build();
        trainingCourseRepository.save(trainingCourse1);
        trainingCourseRepository.save(trainingCourse2);

        List<TrainingCourse> trainingCourseList = trainingCourseRepository.findAllByDepartmentAndPosition(department,
                position);
        Assertions.assertThat(trainingCourseList).isNotNull();
        Assertions.assertThat(trainingCourseList.size()).isEqualTo(2);
    }

    @Test
    public void TrainingCourseRepository_FindByDepartmentAndPositionAndCourse_ReturnTrainingCourse() {
        Department department = Department.builder().id(1).deptRootName("departmentName").build();
        Position position = Position.builder().id(1).name("positionName").build();
        TrainingField trainingField = TrainingField.builder().id(1).course("trainingField").build();

        departmentRepository.save(department);
        positionRepository.save(position);
        trainingFieldRepository.save(trainingField);

        TrainingCourse trainingCourse = TrainingCourse.builder()
                .department(department)
                .position(position)
                .course(trainingField)
                .build();

        trainingCourseRepository.save(trainingCourse);

        TrainingCourse trainingCourseFounded = trainingCourseRepository.findByDepartmentAndPositionAndCourse(
                department,
                position,
                trainingField
        ).get();

        Assertions.assertThat(trainingCourseFounded).isNotNull();
    }
}