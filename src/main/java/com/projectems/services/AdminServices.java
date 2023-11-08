package com.projectems.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.projectems.dto.AdminDTO;

@Service
public class AdminServices {

    public AdminDTO createAdmin(AdminDTO adminDTO) {
        
        return null; 
    }

    public AdminDTO getAdminById(Long id) {
     
        return null; 
    }

    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
       
        return null; 
    }

    public String deleteAdmin(Long id) {
      
        return "Admin with ID " + id + " has been deleted successfully.";
    }

    public List<AdminDTO> getAllAdmins() {
       
        return null; 
    }
}
