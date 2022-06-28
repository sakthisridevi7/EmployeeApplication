package com.edu.EmployeeApplication.controller;

import java.util.List;

import javax.validation.Valid;

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
	EmployeeService employeeService;
	
	//Request Body
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
		
	}
	@GetMapping
	public List<Employee> getEmployeeList()
	{
		return employeeService.getEmployeeList();
		
		
	}
	//api/employee/id
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return employeeService.getEmployeeById(id);
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(id , employee);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/GetByFirstName/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable("firstName") String firstName){
		return employeeService.getEmployeeByFirstName(firstName);
	}
	@GetMapping("/GetByLastName/{lastName}")
	public List<Employee> getEmployeeByLastName(@PathVariable("lastName") String lastName){
		return employeeService.getEmployeeByLastName(lastName);
	}
	@GetMapping("/GetEmployeeByFullName/{firstName}/{lastName}")
	public List<Employee> getEmployeeByFullName(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName){
		return employeeService.getEmployeeByFullName(firstName , lastName);
	}
	

}
