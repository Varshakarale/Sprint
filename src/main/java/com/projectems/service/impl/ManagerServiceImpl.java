package com.projectems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.ManagerConverter;
import com.projectems.dao.ManagerRepository;
import com.projectems.dto.ManagerDTO;
import com.projectems.entities.Manager;
import com.projectems.exceptions.ManagerNotFoundException;
import com.projectems.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerConverter managerConverter;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerConverter managerConverter) {
        this.managerRepository = managerRepository;
        this.managerConverter = managerConverter;
    }

    @Override
    public ManagerDTO getManagerById(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException("Manager not found with id: " + id));
        return managerConverter.entityToDto(manager);
    }

    @Override
    public ManagerDTO createManager(ManagerDTO managerDTO) {
        Manager manager = managerConverter.dtoToEntity(managerDTO);
        manager = managerRepository.save(manager);
        return managerConverter.entityToDto(manager);
    }

    @Override
    public ManagerDTO updateManager(ManagerDTO managerDTO) {
        Manager manager = managerConverter.dtoToEntity(managerDTO);
        manager = managerRepository.save(manager);
        return managerConverter.entityToDto(manager);
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managerConverter.entityListToDtoList(managers);
    }
}
