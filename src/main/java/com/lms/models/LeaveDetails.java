package com.lms.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "leave_details")
public class LeaveDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_name")
    private String employeeName;

    @NotNull(message = "Please provide start date!")
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull(message = "Please provide end date!")
    @Column(name = "to_date")
    private Date toDate;

    @NotEmpty(message = "Please provide a reason for the leave!")
    @Column(name = "purpose")
    private String purpose;

    @Column(name = "accept_reject_flag")
    private boolean acceptRejectFlag;

    @Column(name = "active")
    private boolean active;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getEmployeeName() {
	return employeeName;
    }

    public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
    }

    public Date getFromDate() {
	return fromDate;
    }

    public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
    }

    public Date getToDate() {
	return toDate;
    }

    public void setToDate(Date toDate) {
	this.toDate = toDate;
    }

    public String getPurpose() {
	return purpose;
    }

    public void setPurpose(String purpose) {
	this.purpose = purpose;
    }

    public boolean isAcceptRejectFlag() {
	return acceptRejectFlag;
    }

    public void setAcceptRejectFlag(boolean acceptRejectFlag) {
	this.acceptRejectFlag = acceptRejectFlag;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }
}
