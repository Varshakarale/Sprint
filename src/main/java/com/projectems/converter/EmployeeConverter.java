package com.projectems.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.projectems.dto.EmployeeDTO;
import com.projectems.entities.Employee;

@Component
public class EmployeeConverter {
    public EmployeeDTO entityToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        // Map other fields as needed

        return employeeDTO;
    }

    public Employee dtoToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        // Map other fields as needed

        return employee;
    }

    public List<EmployeeDTO> entityToDtoList(List<Employee> employees) {
        return employees.stream()
            .map(this::entityToDto)
            .collect(Collectors.toList());
    }
}
