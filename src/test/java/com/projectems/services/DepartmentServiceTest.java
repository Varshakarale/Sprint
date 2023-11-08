package com.projectems.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.DepartmentRepository;
import com.projectems.dto.DepartmentDTO;
import com.projectems.entities.Department;
import com.projectems.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentServiceTest
{
	@InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    public void testGetAllDepartments() {
        // Create a list of sample Department entities
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        departmentList.add(new Department());

        // Mock the behavior of the departmentRepository.findAll method
        when(departmentRepository.findAll()).thenReturn(departmentList);

        // Call the service method
        List<DepartmentDTO> departmentDTOList = departmentService.getAllDepartments();

        // Verify that the repository method was called
        verify(departmentRepository, times(1)).findAll();

        // Assert that the size of the returned list matches the expected size
        assertEquals(departmentList.size(), departmentDTOList.size());

        // Assert that each DepartmentDTO in the list corresponds to the respective Department entity
        for (int i = 0; i < departmentList.size(); i++) {
            Department department = departmentList.get(i);
            DepartmentDTO departmentDTO = departmentDTOList.get(i);

            assertEquals(department.getId(), departmentDTO.getId());
            assertEquals(department.getName(), departmentDTO.getName());
        }
    }

    @Test
    public void testGetDepartment() {
        // Create a sample Department entity and DepartmentDTO
        Long departmentId = 1L;
        Department department = new Department();
       // DepartmentDTO departmentDTO = new DepartmentDTO(null, "");
        // Mock the behavior of the departmentRepository.findById method
        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        // Call the service method
        DepartmentDTO result = departmentService.getDepartment(departmentId);

        // Verify that the repository method was called
        verify(departmentRepository, times(1)).findById(departmentId);

        // Assert that the returned DepartmentDTO matches the expected values
       // assertEquals(departmentDTO.getId(), result.getId());
      //  assertEquals(departmentDTO.getName(), result.getName());
    }

    @Test
    public void testCreateDepartment() {
        // Create a sample DepartmentDTO
    //	DepartmentDTO departmentDTO = new DepartmentDTO(null, "");

        // Mock the behavior of the departmentRepository.save method
        when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> {
            Department department = invocation.getArgument(0);
            department.setId(1L); // Simulate the generated ID
            return department;
        });

        // Call the service method to create a department
       // DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);

        // Verify that the repository method was called
        verify(departmentRepository, times(1)).save(any(Department.class));

        // Assert that the createdDepartment matches the expected DepartmentDTO
        //assertEquals(departmentDTO.getName(), createdDepartment.getName());
    //    assertEquals(1L, createdDepartment.getId()); // ID is generated
}
}