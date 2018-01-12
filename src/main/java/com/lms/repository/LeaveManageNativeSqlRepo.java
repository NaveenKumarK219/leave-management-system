package com.lms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lms.models.LeaveDetails;

@Repository
public class LeaveManageNativeSqlRepo {

    @PersistenceContext
    EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public List<LeaveDetails> getAllLeavesOnStatus(StringBuffer whereQuery) {

	Query query = entityManager.createNativeQuery("select * from leave_details where " + whereQuery,
		LeaveDetails.class);
	
	return query.getResultList();
    }
}
