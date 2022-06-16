package com.edu.EmployeeApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.EmployeeRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@Test
	public void saveEmployeeTest() {
		Employee employee = employeeRepository.save(new Employee(1,"101","Sakthi","Sridevi","sakthi@gmail.com","896675472","Learner"));
		
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}//
	@Test
	public void getEmployeeTest() {
		Employee employee = employeeRepository.findById(17L).get();
		
		Assertions.assertThat(employee.getId()).isEqualTo(17L);
	}
	@Test
	public void getEmployeeListTest() {
		List<Employee> employees = employeeRepository.findAll();
		
		Assertions.assertThat(employees.size()).isGreaterThan(0);
		
	}
	
	@Test
	public void updateEmployeeTest() {
		Employee employee = employeeRepository.findById(19L).get();
		
		employee.setDesignation("Nurse");
		
		Employee update = employeeRepository.save(employee);
		
		Assertions.assertThat(update.getDesignation()).isEqualTo("Nurse");
	}
	@Test
	public void deleteEmployeeTest() {
		Employee emp = employeeRepository.findById(21L).get();
		employeeRepository.delete(emp);
		Employee employee = null;
		Optional<Employee> emp1 = employeeRepository.findByEmail("sakthi@gmail.com");
		if(emp1.isPresent()) {
			employee = emp1.get();
		}
		Assertions.assertThat(employee).isNull();
	}
	
	
}
