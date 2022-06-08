package com.edu.EmployeeApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.EmployeeRepository;

import exception.ResourceNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeerepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		 return employeerepository.save(employee);
		
	}
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
		
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		Employee employee = new Employee();
		employee = employeerepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		return employee;
	}

	@Override
	public Employee updateEmployee(long id , Employee employee) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp = employeerepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		emp.setEmdId(employee.getEmdId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setContactNo(employee.getContactNo());
		emp.setDesignation(employee.getDesignation());
		
		
		employeerepository.save(emp);
		return emp;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee = employeerepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		
		employeerepository.deleteById(id);
		return "Record is deleted successfully";
		
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeerepository.getEmployeeByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeeByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return employeerepository.getEmployeeByFullName(firstName,lastName);
	}
	
		

}
