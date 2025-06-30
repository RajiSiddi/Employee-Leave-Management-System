package com.employers.hr.leavemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employers.hr.leavemanagement.model.Employee;
import com.employers.hr.leavemanagement.model.LeaveRequest;
import com.employers.hr.leavemanagement.repository.EmployeeRepository;
import com.employers.hr.leavemanagement.repository.LeaveRequestRepository;

@Service
public class LeaveManagementService {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	LeaveRequestRepository levrepo;
	

	
	//Save Employee
	public Employee createEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	
	//update Employee
	public Employee updateEmployee(Long id, Employee emp) {
		Employee e = emprepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
        e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		
		return emprepo.save(e);
	}
	
	//Get employee by id
	public Employee getEmployeeById(Long id) {
	    return emprepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with id" +id));
	}
	
	//Get all employees
	public List<Employee> getAll(){
		return emprepo.findAll();
	}
	
	//Apply for leave
	public LeaveRequest applyLeave(Long empId, LeaveRequest leavereq) {
		Employee emp = emprepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found")); //This will either get the Employee or throw an exception if not found.
		leavereq.setEmployee(emp);
		leavereq.setStatus("Pending"); 
		return levrepo.save(leavereq);
	}
	
	//Get All leaves
	
	public List<LeaveRequest> getAllRequests(){
		return levrepo.findAll();
	}
  
	//Delete leaveRequest
	public void deleteRequest(Long id) {
		levrepo.deleteById(id);
	}
}

     