package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Department;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    public void setUp(){
        Department department1 = Department.builder()
                .id(1)
                .deptRootName("testDepartment1").build();
        Department department2 = Department.builder()
                .id(2)
                .deptRootName("testDepartment2").build();

        departmentRepository.save(department1);
        departmentRepository.save(department2);
    }

    @Test
    public void DepartmentRepository_GetById_ReturnDepartment(){
        Department departmentFounded = departmentRepository.findById(1).get();

        Assertions.assertThat(departmentFounded).isNotNull();
    }

    @Test
    public void DepartmentRepository_GetAll_ReturnAllDepartments(){
        List<Department> departmentList = departmentRepository.findAll();

        Assertions.assertThat(departmentList).isNotNull();
        Assertions.assertThat(departmentList.size()).isEqualTo(2);
    }

}