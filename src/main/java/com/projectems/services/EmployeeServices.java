package com.projectems.services;



import com.projectems.dto.EmployeeDTO;
import com.projectems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices implements EmployeeService {

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
      
        return null;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
     
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
       
        return null;
    }
}
