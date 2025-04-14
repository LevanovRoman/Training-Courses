package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponseDto> getAllDepartments();
}
