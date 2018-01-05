package com.lms.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.models.LeaveDetails;

@Repository(value = "leaveManageRepository")
public interface LeaveManageRepository extends JpaRepository<LeaveDetails, Serializable> {

}
