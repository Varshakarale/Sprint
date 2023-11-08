package com.projectems.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.LeaveRepository;
import com.projectems.dto.LeaveDTO;
import com.projectems.entities.Leave;
import com.projectems.service.LeaveService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LeaveServiceTest
{
	@InjectMocks
    private LeaveService leaveService;

    @Mock
    private LeaveRepository leaveRepository;

    @Test
    public void testGetAllLeaves() {
        // Create a list of sample Leave entities
        List<Leave> leaveList = new ArrayList<>();
        leaveList.add(new Leave());
        leaveList.add(new Leave());

        // Mock the behavior of the leaveRepository.findAll method
        when(leaveRepository.findAll()).thenReturn(leaveList);

        // Call the service method
        List<LeaveDTO> leaveDTOList = leaveService.getAllLeaves();

        // Verify that the repository method was called
        verify(leaveRepository, times(1)).findAll();

        // Assert that the size of the returned list matches the expected size
        assertEquals(leaveList.size(), leaveDTOList.size());

        // Assert that each LeaveDTO in the list corresponds to the respective Leave entity
        for (int i = 0; i < leaveList.size(); i++) {
            Leave leave = leaveList.get(i);
            LeaveDTO leaveDTO = leaveDTOList.get(i);

            assertEquals(leave.getId(), leaveDTO.getId());
           // assertEquals(leave.getUsername(), leaveDTO.getUsername());
        }
    }

    @Test
    public void testGetLeaveById() {
        // Create a sample Leave entity and LeaveDTO
        Long leaveId = 1L;
        Leave leave = new Leave();
        LeaveDTO leaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveRepository.findById method
        when(leaveRepository.findById(leaveId)).thenReturn(Optional.of(leave));

        // Call the service method
        LeaveDTO result = leaveService.getLeaveById(leaveId);

        // Verify that the repository method was called
        verify(leaveRepository, times(1)).findById(leaveId);

        // Assert that the returned LeaveDTO matches the expected values
        assertEquals(leaveDTO.getId(), result.getId());
      //  assertEquals(leaveDTO.getUsername(), result.getUsername());
    }

    @Test
    public void testCreateLeave() {
        // Create a sample LeaveDTO
        LeaveDTO leaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveRepository.save method
        when(leaveRepository.save(any(Leave.class))).thenAnswer(invocation -> {
            Leave leave = invocation.getArgument(0);
            leave.setId(1L); // Simulate the generated ID
            return leave;
        });

        // Call the service method to create a leave
       // LeaveDTO createdLeave = LeaveService.createLeave(leaveDTO);

        // Verify that the repository method was called
        verify(leaveRepository, times(1)).save(any(Leave.class));

        // Assert that the createdLeave matches the expected LeaveDTO
      //  assertEquals(leaveDTO.getId(), createdLeave.getId());
     //   assertEquals(leaveDTO.getUsername(), createdLeave.getUsername());
    }

    @Test
    public void testUpdateLeave() {
        // Create a sample Leave entity and LeaveDTO for updating
        Long leaveId = 1L;
        Leave leave = new Leave();
        LeaveDTO updatedLeaveDTO = new LeaveDTO();

        // Mock the behavior of the leaveRepository.findById and leaveRepository.save methods
        when(leaveRepository.findById(leaveId)).thenReturn(Optional.of(leave));
        when(leaveRepository.save(any(Leave.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method to update a leave
        LeaveDTO updatedLeave = leaveService.updateLeave(leaveId, updatedLeaveDTO);

        // Verify that the repository methods were called
        verify(leaveRepository, times(1)).findById(leaveId);
        verify(leaveRepository, times(1)).save(any(Leave.class));

        // Assert that the updatedLeave matches the expected LeaveDTO
        assertEquals(updatedLeaveDTO.getId(), updatedLeave.getId());
       // assertEquals(updatedLeaveDTO.getUsername(), updatedLeave.getUsername());
    }
}
