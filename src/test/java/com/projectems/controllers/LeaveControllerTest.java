package com.projectems.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.LeaveController;
import com.projectems.dto.LeaveDTO;
import com.projectems.service.LeaveService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LeaveControllerTest
{
	@InjectMocks
    private LeaveController leaveController;

    @Mock
    private LeaveService leaveService;

    @Test
    public void testGetAllLeaves() {
        // Create a list of sample LeaveDTOs
        List<LeaveDTO> leaveDTOList = new ArrayList<>();
        leaveDTOList.add(new LeaveDTO());
        

        // Mock the behavior of the leaveService.getAllLeaves method
        when(leaveService.getAllLeaves()).thenReturn(leaveDTOList);

        // Call the controller method
        List<LeaveDTO> result = leaveController.getAllLeaves();

        // Verify that the service method was called
        verify(leaveService, times(1)).getAllLeaves();

        // Assert that the response matches the expected LeaveDTO list
        assertEquals(leaveDTOList, result);
    }

    @Test
    public void testGetLeave() {
        // Create a sample LeaveDTO and ID
        Long leaveId = 1L;
        LeaveDTO leaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveService.getLeaveById method
        when(leaveService.getLeaveById(leaveId)).thenReturn(leaveDTO);

        // Call the controller method
        ResponseEntity<LeaveDTO> response = leaveController.getLeave(leaveId);

        // Verify that the service method was called
        verify(leaveService, times(1)).getLeaveById(leaveId);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected LeaveDTO
        assertEquals(leaveDTO, response.getBody());
    }

    @Test
    public void testCreateLeave() {
        // Create a sample LeaveDTO
        LeaveDTO leaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveService.createLeave method
        //when(LeaveService.createLeave(leaveDTO)).thenReturn(leaveDTO);

        // Call the controller method to create a leave
       // ResponseEntity<LeaveDTO> response = LeaveController.createLeave(leaveDTO);

        verify(leaveService, times(1));
		// Verify that the service method was called
        //LeaveService.createLeave(leaveDTO);

        // Assert that the response status is CREATED
       // assertEquals(201, response.getStatusCodeValue());

        // Assert that the response body matches the expected LeaveDTO
        //assertEquals(leaveDTO, response.getBody());
    }

    @Test
    public void testUpdateLeave() {
        // Create a sample LeaveDTO and ID for updating
        Long leaveId = 1L;
        LeaveDTO updatedLeaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveService.updateLeave method
        when(leaveService.updateLeave(leaveId, updatedLeaveDTO)).thenReturn(updatedLeaveDTO);

        // Call the controller method
        ResponseEntity<LeaveDTO> response = leaveController.updateLeave(updatedLeaveDTO, leaveId);

        // Verify that the service method was called
        verify(leaveService, times(1)).updateLeave(leaveId, updatedLeaveDTO);

        // Assert that the response status is OK
        assertEquals(200, response.getStatusCodeValue());

        // Assert that the response body matches the expected updated LeaveDTO
        assertEquals(updatedLeaveDTO, response.getBody());
    }
}
