package com.projectems.service;

import java.util.List;

import com.projectems.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO getDepartment(Long id);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id);
    String deleteDepartment(Long id);
    String deleteAllDepartments();
}
