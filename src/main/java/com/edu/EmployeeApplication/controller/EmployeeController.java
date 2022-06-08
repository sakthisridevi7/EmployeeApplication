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

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	//Request Body
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
		
		
	}
	@GetMapping
	public List<Employee> getEmployeeList()
	{
		return employeeservice.getEmployeeList();
		
		
	}
	//api/employee/id
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return employeeservice.getEmployeeById(id);
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee)
	{
		return employeeservice.updateEmployee(id , employee);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		return new ResponseEntity<String>(employeeservice.deleteEmployee(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/GetByFirstName/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable("firstName") String firstName){
		return employeeservice.getEmployeeByFirstName(firstName);
	}
	@GetMapping("/getEmployeeByFullName/{firstName}/{lastName}")
	public List<Employee> getEmployeeByFullName(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName){
		return employeeservice.getEmployeeByFullName(firstName , lastName);
	}
	

}
