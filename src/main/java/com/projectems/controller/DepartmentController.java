package com.projectems.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projectems.dto.DepartmentDTO;
import com.projectems.service.DepartmentService;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
        return departmentDTOs;
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.getDepartment(id);
        if (departmentDTO != null) {
            return ResponseEntity.ok(departmentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long id) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentDTO, id);
        if (updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartmentByID(@PathVariable Long id) {
        String result = departmentService.deleteDepartment(id);
        if (result.equals("deleted")) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/departments")
    public ResponseEntity<Void> deleteAllDepartments() {
        String result = departmentService.deleteAllDepartments();
        if (result.equals("deleted")) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
