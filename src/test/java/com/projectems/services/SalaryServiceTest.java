package com.projectems.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.SalaryController;
import com.projectems.dao.SalaryRepository;
import com.projectems.dto.SalaryDTO;
import com.projectems.entities.Salary;
import com.projectems.service.impl.SalaryServiceImpl;



@SpringBootTest
public class SalaryServiceTest {

    @InjectMocks
    private SalaryServiceImpl salaryService;

    @Mock
    private SalaryRepository salaryRepository;

    @Test
    
    public void testGetSalaryById() {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(1L);
     //   salaryDTO.setAmount(50000);

        when(salaryService.getSalaryById(1L)).thenReturn(salaryDTO);

        ResponseEntity<SalaryDTO> response = null;
		try {
			//response = SalaryController.getSalaryById(1L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(salaryDTO, response.getBody());
    }

    

    @Test
    public void testCreateSalary() {
        // Create a sample SalaryDTO
        SalaryDTO salaryDTO = new SalaryDTO();
      //  salaryDTO.setAmount(60000);

        // Create a sample Salary entity
        Salary salary = new Salary();
        salary.setAmount(salaryDTO.getAmount());

        when(salaryRepository.save(any(Salary.class))).thenReturn(salary);

        SalaryDTO createdSalary = salaryService.createSalary(salaryDTO);

        assertEquals(salaryDTO.getAmount(), createdSalary.getAmount());
    }

    @Test
    public void testUpdateSalary() {
        // Create a sample SalaryDTO
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(1L);
       // salaryDTO.setAmount(70000);

        // Create a sample Salary entity
        Salary salary = new Salary();
        salary.setId(salaryDTO.getId());
        salary.setAmount(salaryDTO.getAmount());

        when(salaryRepository.save(any(Salary.class))).thenReturn(salary);

        SalaryDTO updatedSalary = salaryService.updateSalary(salaryDTO);

        assertEquals(salaryDTO.getId(), updatedSalary.getId());
        assertEquals(salaryDTO.getAmount(), updatedSalary.getAmount());
    }

    @Test
    public void testDeleteSalary() {
        salaryService.deleteSalary(1L);

        verify(salaryRepository).deleteById(1L);
    }
}
