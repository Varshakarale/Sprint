package com.projectems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.SalaryConverter;
import com.projectems.dao.SalaryRepository;
import com.projectems.dto.SalaryDTO;
import com.projectems.entities.Salary;

@Service
public class SalaryServices {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private SalaryConverter salaryConverter;

    public SalaryDTO getSalaryById(Long id) {
        Salary salary = salaryRepository.findById(id).orElse(null);
        return salaryConverter.entityToDto(salary);
    }

    public SalaryDTO createSalary(SalaryDTO salaryDTO) {
        Salary salary = salaryConverter.dtoToEntity(salaryDTO);
        salary = salaryRepository.save(salary);
        return salaryConverter.entityToDto(salary);
    }

    public SalaryDTO updateSalary(SalaryDTO salaryDTO) {
        Salary salary = salaryConverter.dtoToEntity(salaryDTO);
        salary.setId(salaryDTO.getId());
        salary = salaryRepository.save(salary);
        return salaryConverter.entityToDto(salary);
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
