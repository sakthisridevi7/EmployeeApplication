package com.edu.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.EmployeeApplication.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department , Long>{

}
