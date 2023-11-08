package com.projectems.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.ManagerController;
import com.projectems.dto.ManagerDTO;
import com.projectems.service.ManagerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ManagerControllerTest {
	@InjectMocks
    private ManagerController managerController;

    @Mock
    private ManagerService managerService;

    @Test
    public void testGetManagerById() {
        // Create a sample ManagerDTO and ID
        Long managerId = 1L;
        ManagerDTO managerDTO = new ManagerDTO();

        // Mock the behavior of the managerService.getManagerById method
        when(managerService.getManagerById(managerId)).thenReturn(managerDTO);

        // Call the controller method
        ResponseEntity<ManagerDTO> response = managerController.getManagerById(managerId);

        // Verify that the service method was called
        verify(managerService, times(1)).getManagerById(managerId);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected ManagerDTO
        assertEquals(managerDTO, response.getBody());
    }

    @Test
    public void testCreateManager() {
        // Create a sample ManagerDTO
        ManagerDTO managerDTO = new ManagerDTO();

        // Mock the behavior of the managerService.createManager method
      //  when(ManagerService.createManager(managerDTO)).thenReturn(managerDTO);

        // Call the controller method to create a manager
      //  ResponseEntity<ManagerDTO> response = ManagerController.createManager(managerDTO);

        verify(managerService, times(1));
		// Verify that the service method was called
       // ManagerService.createManager(managerDTO);

        // Assert that the response status is CREATED
      //  assertEquals(201, response.getStatusCodeValue());

        // Assert that the response body matches the expected ManagerDTO
       // assertEquals(managerDTO, response.getBody());
    }

    @Test
    public void testUpdateManager() {
        // Create a sample ManagerDTO and ID for updating
        Long managerId = 1L;
        ManagerDTO updatedManagerDTO = new ManagerDTO();

        // Mock the behavior of the managerService.updateManager method
        when(managerService.updateManager(updatedManagerDTO)).thenReturn(updatedManagerDTO);

        // Call the controller method
        ResponseEntity<ManagerDTO> response = managerController.updateManager(managerId, updatedManagerDTO);

        // Verify that the service method was called
        verify(managerService, times(1)).updateManager(updatedManagerDTO);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected updated ManagerDTO
        assertEquals(updatedManagerDTO, response.getBody());
    }

    @Test
    public void testDeleteManager() {
        // Create a sample Manager ID for deletion
        Long managerId = 1L;

        // Call the controller method to delete a manager
        ResponseEntity<Void> response = managerController.deleteManager(managerId);

        // Verify that the service method was called
        verify(managerService, times(1)).deleteManager(managerId);

        // Assert that the response status is NO_CONTENT (204)
        assertEquals(204, response.getStatusCodeValue());
    }
}
