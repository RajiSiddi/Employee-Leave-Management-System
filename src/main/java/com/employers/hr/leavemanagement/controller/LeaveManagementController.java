package com.employers.hr.leavemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employers.hr.leavemanagement.model.Employee;
import com.employers.hr.leavemanagement.model.LeaveRequest;
import com.employers.hr.leavemanagement.service.LeaveManagementService;

@RestController
@RequestMapping("/api")
public class LeaveManagementController {
	
	@Autowired
	LeaveManagementService service;
	
	//create Employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		// @RequestBody - JSON body will be converted to Employee object
		return service.createEmployee(employee);
	}
	
	//update employee details
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return service.getAll();
	}
	
	
    //Apply for leave 
	@PostMapping("/leaves/{employeeId}")
	public LeaveRequest applyLeave(@PathVariable Long employeeId, @RequestBody LeaveRequest leaverequest) {
		return service.applyLeave(employeeId, leaverequest);
	}
	
	//GetAllLeaveRequests
	@GetMapping("/leaves")
	public List<LeaveRequest> getAllLeaves(){
		return service.getAllRequests();
	}
	
	//DeleteLeaveRequest
	@DeleteMapping("leaves/{id}")
	public void deleteRequest(@PathVariable Long id) {
		service.deleteRequest(id);
	}

}
