package com.projectems.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.LeaveConverter;
import com.projectems.dao.LeaveRepository;
import com.projectems.dto.LeaveDTO;
import com.projectems.entities.Leave;

@Service
public class LeaveServices {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private LeaveConverter leaveConverter;

    public LeaveDTO getLeaveById(Long id) {
        Optional<Leave> leave = leaveRepository.findById(id);
        return leave.map(leaveConverter::convertToLeaveDTO).orElse(null);
    }

    public LeaveDTO createLeave(LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave = leaveRepository.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    public LeaveDTO updateLeave(Long id, LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave.setId(id);
        leave = leaveRepository.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    public String deleteLeave(Long id) {
        leaveRepository.deleteById(id);
        return "Leave with ID " + id + " has been deleted successfully.";
    }

    public List<LeaveDTO> getAllLeaves() {
        List<Leave> leaves = leaveRepository.findAll();
        return leaves.stream().map(leaveConverter::convertToLeaveDTO).collect(Collectors.toList());
    }
}
