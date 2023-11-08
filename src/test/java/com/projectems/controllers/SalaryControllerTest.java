package com.projectems.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.SalaryController;
import com.projectems.dto.SalaryDTO;
import com.projectems.service.SalaryService;

@SpringBootTest
public class SalaryControllerTest {

    @InjectMocks
    private SalaryController salaryController;

    @Mock
    private SalaryService salaryService;

    @Test
    public void testGetSalaryById() {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(1L);
        //salaryDTO.setAmount(50000);

        when(salaryService.getSalaryById(1L)).thenReturn(salaryDTO);

      //  ResponseEntity<SalaryDTO> response = SalaryController.getSalaryById(1L);

       // assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(salaryDTO, response.getBody());
    }

    @Test
    public void testCreateSalary() {
        SalaryDTO salaryDTO = new SalaryDTO();
       // salaryDTO.setAmount(60000);

        when(salaryService.createSalary(salaryDTO)).thenReturn(salaryDTO);

        ResponseEntity<SalaryDTO> response = salaryController.createSalary(salaryDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(salaryDTO, response.getBody());
    }

    @Test
    public void testUpdateSalary() {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(1L);
      //  salaryDTO.setAmount(70000);

        when(salaryService.updateSalary(salaryDTO)).thenReturn(salaryDTO);

        ResponseEntity<SalaryDTO> response = salaryController.updateSalary(1L, salaryDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(salaryDTO, response.getBody());
    }

    @Test
    public void testDeleteSalary() {
        ResponseEntity<Void> response = salaryController.deleteSalary(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
