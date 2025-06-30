package com.employers.hr.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employers.hr.leavemanagement.model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

}