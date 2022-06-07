package com.edu.EmployeeApplication.service;

import java.util.List;

import com.edu.EmployeeApplication.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getDepartmentList();

	Department getDepartmentById(long dId);

	Department updateDepartment(long dId, Department department);

	String deleteDepartment(long dId);

}
