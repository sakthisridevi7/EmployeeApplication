package com.edu.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.EmployeeApplication.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
