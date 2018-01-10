package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.LeaveDetails;
import com.lms.repository.LeaveManageRepository;

@Service(value = "leaveManageService")
public class LeaveManageService {

    @Autowired
    private LeaveManageRepository leaveManageRepository;

    public void applyLeave(LeaveDetails leaveDetails) {

	leaveDetails.setActive(true);
	leaveManageRepository.save(leaveDetails);
    }

    public List<LeaveDetails> getAllLeaves() {

	return leaveManageRepository.findAll();
    }

    public LeaveDetails getLeaveDetailsOnId(int id) {

	return leaveManageRepository.findOne(id);
    }

    public void updateLeaveDetails(LeaveDetails leaveDetails) {

	leaveManageRepository.save(leaveDetails);

    }

    public List<LeaveDetails> getAllActiveLeaves() {

	return leaveManageRepository.getAllActiveLeaves();
    }
}
