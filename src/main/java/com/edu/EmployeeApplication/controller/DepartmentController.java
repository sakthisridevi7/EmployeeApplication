package com.edu.EmployeeApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.EmployeeApplication.entity.Department;
import com.edu.EmployeeApplication.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.saveDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Department> getDepartmentList(){
		return departmentService.getDepartmentList();
	}
	
	@GetMapping("/{dId}")
	public Department getDepartmentById(@PathVariable("dId") long dId){
		return departmentService.getDepartmentById(dId);
	}
		
	@PutMapping("/{dId}")
	public Department updateDepartment(@PathVariable("dId") long dId, @RequestBody Department department) {
		return departmentService.updateDepartment(dId,department);
	}
		
	@DeleteMapping("/{dId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("dId") long dId){
		return new ResponseEntity<String>(departmentService.deleteDepartment(dId), HttpStatus.OK);
	}

}
