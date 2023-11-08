package com.projectems.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.ManagerRepository;
import com.projectems.dto.ManagerDTO;
import com.projectems.entities.Manager;
import com.projectems.service.ManagerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class ManagerServiceTest {
	@InjectMocks
    private ManagerService managerService;

    @Mock
    private ManagerRepository managerRepository;

    @Test
    public void testGetManagerById() {
        // Create a sample Manager entity and ManagerDTO
        Long managerId = 1L;
        Manager manager = new Manager();
        ManagerDTO managerDTO = new ManagerDTO();

        // Mock the behavior of the managerRepository.findById method
        when(managerRepository.findById(managerId)).thenReturn(Optional.of(manager));

        // Call the service method
        ManagerDTO result = managerService.getManagerById(managerId);

        // Verify that the repository method was called
        verify(managerRepository, times(1)).findById(managerId);

        // Assert that the returned ManagerDTO matches the expected values
        assertEquals(managerDTO.getId(), result.getId());
       // assertEquals(ManagerDTO.getUsername(), ManagerDTO.getUsername());
    }

    @Test
    public void testCreateManager1() {
        // Create a sample ManagerDTO
        ManagerDTO managerDTO = new ManagerDTO();

        // Mock the behavior of the managerRepository.save method
        when(managerRepository.save(any(Manager.class))).thenAnswer(invocation -> {
            Manager manager = invocation.getArgument(0);
            manager.setId(1L); // Simulate the generated ID
            return manager;
        });

        // Call the service method to create a manager
       // ManagerDTO createdManager = ManagerService.createManager(managerDTO);

        // Verify that the repository method was called
        verify(managerRepository, times(1)).save(any(Manager.class));

        // Assert that the createdManager matches the expected ManagerDTO
      //  assertEquals(managerDTO.getId(), createdManager.getId());
     //   assertEquals(ManagerDTO.getUsername(), ManagerDTO.getUsername());
    }

    @SuppressWarnings("static-access")
	@Test
    public void testUpdateManager() {
        // Create a sample Manager entity and ManagerDTO for updating
        Long managerId = 1L;
        Manager manager = new Manager();
        ManagerDTO updatedManagerDTO = new ManagerDTO();

        // Mock the behavior of the managerRepository.findById and managerRepository.save methods
        when(managerRepository.findById(managerId)).thenReturn(Optional.of(manager));
        when(managerRepository.save(any(Manager.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method to update a manager
        ManagerDTO updatedManager = managerService.updateManager(updatedManagerDTO);

        // Verify that the repository methods were called
        verify(managerRepository, times(1)).findById(managerId);
        verify(managerRepository, times(1)).save(any(Manager.class));

        // Assert that the updatedManager matches the expected ManagerDTO
        assertEquals(updatedManagerDTO.getId(), updatedManager.getId());
       // assertEquals(updatedManagerDTO.getUsername(), ManagerDTO.getUsername());
    }

    @Test
    public void testDeleteManager() {
        // Create a sample Manager ID for deletion
        Long managerId = 1L;

        // Call the service method to delete a manager
        managerService.deleteManager(managerId);

        // Verify that the repository method was called
        verify(managerRepository, times(1)).deleteById(managerId);
    }
        @Test
        public void testCreateManager() {
            // Create a sample ManagerDTO
            ManagerDTO managerDTO = new ManagerDTO();

            // Mock the behavior of the managerRepository.save method
            when(managerRepository.save(any(Manager.class))).thenAnswer(invocation -> {
                Manager manager = invocation.getArgument(0);
                manager.setId(1L); // Simulate the generated ID
                return manager;
            });

            // Call the repository method to create a manager
           // ManagerDTO createdManager = managerRepository.createManager(managerDTO);

            verify(managerService, times(0));
			// Verify that the service method was not called
           // ManagerService.createManager(managerDTO);

            // Assert that the createdManager matches the expected ManagerDTO
           // assertEquals(ManagerDTO.getUsername(), ManagerDTO.getUsername());
          //  assertEquals(1L, createdManager.getId()); // ID is generated
        }
    }
   


