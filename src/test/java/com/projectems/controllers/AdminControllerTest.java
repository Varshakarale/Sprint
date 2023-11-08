package com.projectems.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.AdminController;
import com.projectems.dto.AdminDTO;
import com.projectems.service.AdminService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest

public class AdminControllerTest
{
	@InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @Test
    public void testGetAdminById() {
        // Create a sample AdminDTO and ID
        Long adminId = 1L;
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(adminId);
        adminDTO.setUsername("Ramesh Sinha");

        // Mock the behavior of the adminService.getAdminById method
        when(adminService.getAdminById(adminId)).thenReturn(adminDTO);

        // Call the controller method
        ResponseEntity<AdminDTO> response = adminController.getAdminById(adminId);

        // Verify that the service method was called
        verify(adminService, times(1)).getAdminById(adminId);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected AdminDTO
        assertEquals(adminDTO, response.getBody());
    }

    @Test
    public void testCreateAdmin() {
        // Create a sample AdminDTO
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUsername("Ramesh Sinha");

        // Mock the behavior of the adminService.createAdmin method
        when(adminService.createAdmin(adminDTO)).thenReturn(adminDTO);

        // Call the controller method
        ResponseEntity<AdminDTO> response = adminController.createAdmin(adminDTO);

        // Verify that the service method was called
        verify(adminService, times(1)).createAdmin(adminDTO);

        // Assert that the response status is CREATED
        assertEquals(201, response.getStatusCodeValue());

        // Assert that the response body matches the expected AdminDTO
        assertEquals(adminDTO, response.getBody());
    }

    @Test
    public void testUpdateAdmin() {
        // Create a sample AdminDTO and ID for updating
        Long adminId = 1L;
        AdminDTO updatedAdminDTO = new AdminDTO();
        updatedAdminDTO.setId(adminId);
        updatedAdminDTO.setUsername("");

        // Mock the behavior of the adminService.updateAdmin method
        when(adminService.updateAdmin(adminId, updatedAdminDTO)).thenReturn(updatedAdminDTO);

        // Call the controller method
        ResponseEntity<AdminDTO> response = adminController.updateAdmin(adminId, updatedAdminDTO);

        // Verify that the service method was called
        verify(adminService, times(1)).updateAdmin(adminId, updatedAdminDTO);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected updated AdminDTO
        assertEquals(updatedAdminDTO, response.getBody());
    }

    @Test
    public void testDeleteAdmin() {
        // Create a sample Admin ID for deletion
        Long adminId = 1L;

        // Call the controller method to delete an admin
        ResponseEntity<Void> response = adminController.deleteAdmin(adminId);

        // Verify that the service method was called
        verify(adminService, times(1)).deleteAdmin(adminId);

        // Assert that the response status is NO_CONTENT (204)
        assertEquals(204, response.getStatusCodeValue());
    }	

    

}
