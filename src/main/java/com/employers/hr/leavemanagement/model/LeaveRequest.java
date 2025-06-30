package com.employers.hr.leavemanagement.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "Leaves")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime startDate;  //yyyy-MM-dd-HH-mm-ss(format)
	private LocalDateTime endDate;
	private String reason;
	private String status; // pending, approved , rejected.
	
    @ManyToOne
    @JoinColumn(name= "employee_id") //specify the foreign key column in Leaves table that joins to employees table's primary key 
	private Employee employee;
    
    public LeaveRequest() {
    	
    }
	public LeaveRequest(Long id, LocalDateTime startDate, LocalDateTime endDate, String reason, String status, Employee employee) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.employee = employee;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
    
}
