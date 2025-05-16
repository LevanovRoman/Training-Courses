package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.DepartmentResponseDto;
import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertDepartmentToDepartmentResponseDto)
                .toList();
    }

    private DepartmentResponseDto convertDepartmentToDepartmentResponseDto(Department department) {
        return new DepartmentResponseDto(department.getId(), department.getDeptRootName());
    }
}
