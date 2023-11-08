package com.projectems.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.DepartmentController;
import com.projectems.dto.DepartmentDTO;
import com.projectems.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentControllerTest
{
	@InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    @Test
    public void testGetAllDepartments() {
        // Create a list of sample DepartmentDTOs
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
       // departmentDTOList.add(new DepartmentDTO(1L, "HR"));
        //departmentDTOList.add(new DepartmentDTO(2L, "IT"));

        // Mock the behavior of the departmentService.getAllDepartments method
        when(departmentService.getAllDepartments()).thenReturn(departmentDTOList);

        // Call the controller method
        List<DepartmentDTO> result = departmentController.getAllDepartments();

        // Verify that the service method was called
        verify(departmentService, times(1)).getAllDepartments();

        // Assert that the response matches the expected DepartmentDTO list
        assertEquals(departmentDTOList, result);
    }

    @Test
    public void testGetDepartment() {
        // Create a sample DepartmentDTO and ID
        Long departmentId = 1L;
     //   DepartmentDTO departmentDTO = new DepartmentDTO(departmentId, "HR");

        // Mock the behavior of the departmentService.getDepartment method
       // when(departmentService.getDepartment(departmentId)).thenReturn(departmentDTO);

        // Call the controller method
        ResponseEntity<DepartmentDTO> response = departmentController.getDepartment(departmentId);

        // Verify that the service method was called
        verify(departmentService, times(1)).getDepartment(departmentId);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected DepartmentDTO
      //  assertEquals(departmentDTO, response.getBody());
    }

    @Test
    public void testAddDepartment() {
        // Create a sample DepartmentDTO
    	//DepartmentDTO departmentDTO = new DepartmentDTO(null, "Sales");

        // Mock the behavior of the departmentService.createDepartment method
       // when(departmentService.createDepartment(departmentDTO)).thenReturn(departmentDTO);

        // Call the controller method
       // ResponseEntity<DepartmentDTO> response = departmentController.addDepartment(departmentDTO);

        // Verify that the service method was called
       // verify(departmentService, times(1)).createDepartment(departmentDTO);

        // Assert that the response status is CREATED
       // assertEquals(201, response.getStatusCodeValue());

        // Assert that the response body matches the expected DepartmentDTO
       // assertEquals(departmentDTO, response.getBody());
    }

    @Test
    public void testUpdateDepartment() {
        // Create a sample DepartmentDTO and ID for updating
        Long departmentId = 1L;
     //   DepartmentDTO updatedDepartmentDTO = new DepartmentDTO(departmentId, "Marketing");

        // Mock the behavior of the departmentService.updateDepartment method
      //  when(departmentService.updateDepartment(updatedDepartmentDTO, departmentId)).thenReturn(updatedDepartmentDTO);

        // Call the controller method
      //  ResponseEntity<DepartmentDTO> response = departmentController.updateDepartment(updatedDepartmentDTO, departmentId);

        // Verify that the service method was called
      //  verify(departmentService, times(1)).updateDepartment(updatedDepartmentDTO, departmentId);

        // Assert that the response status is OK
      //  assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected updated DepartmentDTO
       // assertEquals(updatedDepartmentDTO, response.getBody());
    }

}
