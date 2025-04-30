package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.DepartmentResponseDto;
import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.repository.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService; // Тестируемый сервис

    @Test
    public void testGetAllDepartments_ReturnsListOfDepartments() {
        // 1. Подготовка тестовых данных
        Department department1 = Department.builder().id(1).deptRootName("HR").build();
        Department department2 = Department.builder().id(2).deptRootName("IT").build();
        List<Department> mockDepartments = List.of(department1, department2);

        // 2. Мокируем вызов repository.findAll()
        when(departmentRepository.findAll()).thenReturn(mockDepartments);

        // 3. Вызываем тестируемый метод
        List<DepartmentResponseDto> result = departmentService.getAllDepartments();

        // 4. Проверяем результаты
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).name()).isEqualTo("HR");
        Assertions.assertThat(result.get(1).name()).isEqualTo("IT");

        // 5. Проверяем, что метод findAll() был вызван ровно 1 раз
        verify(departmentRepository, times(1)).findAll();
    }
}