package com.edu.EmployeeApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.EmployeeApplication.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query("select e from Employee e where e.firstName = :firstName")
	List<Employee> getEmployeeByFirstName(@Param("firstName")String firstName);
	
	@Query("select e from Employee e where e.firstName = :firstName and e.lastName = :lastName")
	List<Employee> getEmployeeByFullName(@Param("firstName")String firstName,@Param ("lastName") String lastName);

}
