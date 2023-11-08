package com.projectems.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.AdminRepository;
import com.projectems.dto.AdminDTO;
import com.projectems.entities.Admin;
import com.projectems.service.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdminServiceTest
{
	 @InjectMocks
	    private AdminService adminService;

	    @Mock
	    private AdminRepository adminRepository;

	    @Test
	    public void testCreateAdmin() {
	        // Create a sample AdminDTO
	        AdminDTO adminDTO = new AdminDTO();
	        adminDTO.setUsername("");

	        // Mock the behavior of the adminRepository.save method
	        when(adminRepository.save(any(Admin.class))).thenReturn(new Admin());

	        // Call the service method
	        AdminDTO createdAdmin = adminService.createAdmin(adminDTO);

	        // Verify that the repository method was called
	        verify(adminRepository, times(1)).save(any(Admin.class));

	        // Assert that the createdAdmin matches the expected AdminDTO
	        assertEquals(adminDTO, createdAdmin);
	    }
	    @Test
	    public void testGetAdminById() {
	        // Create a sample Admin entity and AdminDTO
	        Long adminId = 1L;
	        Admin admin = new Admin();
	        admin.setId(adminId);
	        admin.setUsername("");

	        // Mock the behavior of the adminRepository.findById method
	        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));

	        // Call the service method
	        AdminDTO adminDTO = adminService.getAdminById(adminId);

	        // Verify that the repository method was called
	        verify(adminRepository, times(1)).findById(adminId);

	        // Assert that the returned AdminDTO matches the expected values
	        assertEquals(admin.getId(), adminDTO.getId());
	        assertEquals(admin.getUsername(), adminDTO.getUsername());
	    }

	    @Test
	    public void testUpdateAdmin() {
	        // Create a sample Admin entity and AdminDTO
	        Long adminId = 1L;
	        Admin admin = new Admin();
	        admin.setId(adminId);
	        admin.setUsername("");

	        // Create a sample AdminDTO with updated information
	        AdminDTO updatedAdminDTO = new AdminDTO();
	        updatedAdminDTO.setId(adminId);
	        updatedAdminDTO.setUsername("");

	        // Mock the behavior of the adminRepository.findById and adminRepository.save methods
	        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));
	        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

	        // Call the service method
	        AdminDTO updatedAdmin = adminService.updateAdmin(adminId, updatedAdminDTO);

	        // Verify that the repository methods were called
	        verify(adminRepository, times(1)).findById(adminId);
	        verify(adminRepository, times(1)).save(any(Admin.class));

	        // Assert that the updatedAdmin matches the expected AdminDTO
	        assertEquals(updatedAdminDTO, updatedAdmin);
	    }

	    @Test
	    public void testDeleteAdmin() {
	        // Create a sample Admin entity
	        Long adminId = (long) 101;
	        Admin admin = new Admin();
	        admin.setId(adminId);

	        // Mock the behavior of the adminRepository.findById and adminRepository.deleteById methods
	        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));

	        // Call the service method
	        adminService.deleteAdmin(adminId);

	        // Verify that the repository methods were called
	        verify(adminRepository, times(1)).findById(adminId);
	        verify(adminRepository, times(1)).deleteById(adminId);
	    }

	    @Test
	    public void testGetAllAdmins() {
	        // Create a list of sample Admin entities
	        List<Admin> adminList = new ArrayList<>();
	        adminList.add(new Admin());
	        adminList.add(new Admin());

	        // Mock the behavior of the adminRepository.findAll method
	        when(adminRepository.findAll()).thenReturn(adminList);

	        // Call the service method to get all admins
	        List<AdminDTO> adminDTOList = adminService.getAllAdmins();

	        // Verify that the repository method was called
	        verify(adminRepository, times(1)).findAll();

	        // Assert that the size of the returned list matches the expected size
	        assertEquals(adminList.size(), adminDTOList.size());

	        // Assert that each AdminDTO in the list corresponds to the respective Admin entity
	        for (int i = 0; i < adminList.size(); i++) {
	            Admin admin = adminList.get(i);
	            AdminDTO adminDTO = adminDTOList.get(i);

	            assertEquals(admin.getId(), adminDTO.getId());
	            assertEquals(admin.getUsername(), adminDTO.getUsername());
	        }
	    }
}
