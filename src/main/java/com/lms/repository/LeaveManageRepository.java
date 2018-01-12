package com.lms.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.models.LeaveDetails;

@Repository(value = "leaveManageRepository")
public interface LeaveManageRepository extends JpaRepository<LeaveDetails, Serializable> {


    @Query(nativeQuery = true, value = "select array_to_json(array_agg(row_to_json(t))) from (select employee_name||' on leave' as title,to_char(from_date,'YYYY-MM-DD') as start,to_char(to_date,'YYYY-MM-DD') as end from leave_details) as t;")
    public Object getAllLeavesAsJsonArray();

    @Query(nativeQuery = true, value = "select * from leave_details where active=true")
    public List<LeaveDetails> getAllActiveLeaves();

    @Query(nativeQuery = true, value = "select * from leave_details where username=? order by id desc")
    public List<LeaveDetails> getAllLeavesOfUser(String username);


}
