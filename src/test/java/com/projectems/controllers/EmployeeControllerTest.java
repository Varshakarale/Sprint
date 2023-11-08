package com.projectems.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.EmployeeController;
import com.projectems.dto.EmployeeDTO;
import com.projectems.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
public class EmployeeControllerTest
{
	@InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        // Create a sample EmployeeDTO and ID
        Long employeeId = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeService.getEmployeeById method
        when(employeeService.getEmployeeById(employeeId)).thenReturn(employeeDTO);

        // Call the controller method
        ResponseEntity<EmployeeDTO> response = employeeController.getEmployeeById(employeeId);

        // Verify that the service method was called
        verify(employeeService, times(1)).getEmployeeById(employeeId);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected EmployeeDTO
        assertEquals(employeeDTO, response.getBody());
    }

    @Test
    public void testCreateEmployee() {
        // Create a sample EmployeeDTO
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeService.createEmployee method
        when(employeeService.createEmployee(employeeDTO)).thenReturn(employeeDTO);

        // Call the controller method to create an employee
        ResponseEntity<EmployeeDTO> response = employeeController.createEmployee(employeeDTO);

        // Verify that the service method was called
        verify(employeeService, times(1)).createEmployee(employeeDTO);

        // Assert that the response status is CREATED
        assertEquals(201, response.getStatusCodeValue());

        // Assert that the response body matches the expected EmployeeDTO
        assertEquals(employeeDTO, response.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        // Create a sample EmployeeDTO and ID for updating
        Long employeeId = 1L;
        EmployeeDTO updatedEmployeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeService.updateEmployee method
        when(employeeService.updateEmployee(updatedEmployeeDTO)).thenReturn(updatedEmployeeDTO);

        // Call the controller method
        ResponseEntity<EmployeeDTO> response = employeeController.updateEmployee(employeeId, updatedEmployeeDTO);

        // Verify that the service method was called
        verify(employeeService, times(1)).updateEmployee(updatedEmployeeDTO);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected updated EmployeeDTO
        assertEquals(updatedEmployeeDTO, response.getBody());
    }

    @Test
    public void testDeleteEmployee() {
        // Create a sample Employee ID for deletion
        Long employeeId = 1L;

        // Call the controller method to delete an employee
        ResponseEntity<Void> response = employeeController.deleteEmployee(employeeId);

        // Verify that the service method was called
        verify(employeeService, times(1)).deleteEmployee(employeeId);

        // Assert that the response status is NO_CONTENT (204)
        assertEquals(204, response.getStatusCodeValue());
    }

}
