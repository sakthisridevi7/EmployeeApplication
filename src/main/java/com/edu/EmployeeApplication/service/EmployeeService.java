package com.edu.EmployeeApplication.service;

import java.util.List;

import com.edu.EmployeeApplication.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getEmployeeList();

	//void updateEmployee();

	//void deleteEmployee();

	Employee getEmployeeById(long id);

	Employee updateEmployee(long id, Employee employee);

	String deleteEmployee(long id);

	List<Employee> getEmployeeByFirstName(String firstName);

	List<Employee> getEmployeeByFullName(String firstName, String lastName);

	List<Employee> getEmployeeByLastName(String lastName);

}
