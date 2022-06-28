package com.edu.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.EmployeeApplication.entity.Department;
import com.edu.EmployeeApplication.exception.ResourceNotFoundException;
import com.edu.EmployeeApplication.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(long dId) {
		// TODO Auto-generated method stud
		Optional<Department> department= departmentRepository.findById(dId);
		
		if(department.isPresent())
			return department.get();
		else
			throw new ResourceNotFoundException("Department","Id",dId);
		
		
		//return department;
	}

	@Override
	public Department updateDepartment(long dId, Department department) {
		// TODO Auto-generated method stub
		Department dept = departmentRepository.findById(dId).orElseThrow(
				()-> new ResourceNotFoundException("Department","Id",dId));
		
		dept.setDeptId(department.getDeptId());
		dept.setDeptName(department.getDeptName());
		dept.setLocation(department.getLocation());
		dept.setHodId(department.getHodId());
		
		departmentRepository.save(dept);
		return dept;
	}

	@Override
	public String deleteDepartment(long dId) {
		// TODO Auto-generated method stub
	
		Department department = departmentRepository.findById(dId).orElseThrow(
				()-> new ResourceNotFoundException("Department","Id",dId));
		departmentRepository.deleteById(dId);
		return "record is deleted successfully";
	}

}
