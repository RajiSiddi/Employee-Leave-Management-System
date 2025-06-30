package com.employers.hr.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employers.hr.leavemanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}