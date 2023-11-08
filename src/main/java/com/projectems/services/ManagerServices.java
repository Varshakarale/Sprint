package com.projectems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.dto.ManagerDTO;
import com.projectems.service.ManagerService;

import java.util.List;

@Service
public class ManagerServices {

    private ManagerService managerService;

    @Autowired
    public ManagerServices(ManagerService managerService) {
        this.managerService = managerService;
    }


    public ManagerDTO createManagerWithAdditionalLogic(ManagerDTO managerDTO) {
        
        return managerService.createManager(managerDTO);
    }

    public List<ManagerDTO> getAllManagers() {
        return managerService.getAllManagers();
    }

}
