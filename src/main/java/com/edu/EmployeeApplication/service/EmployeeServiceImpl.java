package com.edu.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.EmployeeRepository;


import exception.GivenIdNotFoundException;
import exception.NoRecordFoundException;
import exception.ResourceNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		 return employeeRepository.save(employee);
		
	}
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty()) {
			throw new NoRecordFoundException();
		}
		else
		{
			return employees;
		}
		
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		/*Employee employee = new Employee();
		employee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		return employee;*/
		Optional<Employee> employee =  employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else
		{
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Employee updateEmployee(long id , Employee employee) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		emp.setEmdId(employee.getEmdId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setContactNo(employee.getContactNo());
		emp.setDesignation(employee.getDesignation());
		
		
		employeeRepository.save(emp);
		return emp;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		
		employeeRepository.deleteById(id);
		return "Record is deleted successfully";
		
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeeByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByFullName(firstName,lastName);
	}

	@Override
	public List<Employee> getEmployeeByLastName(String lastName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByLastName(lastName);
	}
	
		

}
