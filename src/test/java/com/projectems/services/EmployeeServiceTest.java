package com.projectems.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.EmployeeRepository;
import com.projectems.dto.EmployeeDTO;
import com.projectems.entities.Employee;
import com.projectems.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class EmployeeServiceTest
{
	@InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testGetEmployeeById() {
        // Create a sample Employee entity and EmployeeDTO
        Long employeeId = 1L;
        Employee employee = new Employee();
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeRepository.findById method
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // Call the service method
        EmployeeDTO result = employeeService.getEmployeeById(employeeId);

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).findById(employeeId);

        // Assert that the returned EmployeeDTO matches the expected values
        assertEquals(employeeDTO.getId(), result.getId());
        assertEquals(employeeDTO.getFirstName(), result.getFirstName());
        assertEquals(employeeDTO.getLastName(), result.getLastName());
    }

    @Test
    public void testCreateEmployee() {
        // Create a sample EmployeeDTO
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeRepository.save method
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> {
            Employee employee = invocation.getArgument(0);
            employee.setId(1L); // Simulate the generated ID
            return employee;
        });

        // Call the service method to create an employee
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).save(any(Employee.class));

        // Assert that the createdEmployee matches the expected EmployeeDTO
        assertEquals(employeeDTO.getId(), createdEmployee.getId());
        assertEquals(employeeDTO.getFirstName(), createdEmployee.getFirstName());
    }

    @Test
    public void testUpdateEmployee() {
        // Create a sample Employee entity and EmployeeDTO for updating
        Long employeeId = 1L;
        Employee employee = new Employee();
        EmployeeDTO updatedEmployeeDTO = new EmployeeDTO();

        // Mock the behavior of the employeeRepository.findById and employeeRepository.save methods
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method to update an employee
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(updatedEmployeeDTO);

        // Verify that the repository methods were called
        verify(employeeRepository, times(1)).findById(employeeId);
        verify(employeeRepository, times(1)).save(any(Employee.class));

        // Assert that the updatedEmployee matches the expected EmployeeDTO
        assertEquals(updatedEmployeeDTO.getId(), updatedEmployee.getId());
        assertEquals(updatedEmployeeDTO.getFirstName(), updatedEmployee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        // Create a sample Employee ID for deletion
        Long employeeId = 1L;

        // Call the service method to delete an employee
        employeeService.deleteEmployee(employeeId);

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

}
