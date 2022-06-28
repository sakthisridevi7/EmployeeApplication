package com.edu.EmployeeApplication.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//(name="employeetbl")
public class Employee {
	@Id
	@GeneratedValue(generator="seq" ,strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=1)

	private long id;
	private String emdId;
	@Column(nullable=false)
	@NotNull
	@NotBlank(message="First name is mandatory")
	private String firstName;
	@Column(nullable=false)
	@NotBlank(message="Last name is mandatory")
	private String lastName;
	@Column(nullable = false, unique = true)
	@NotBlank(message="Email is mandatory")
	@Email(message="Invalid email id")
	private String email;
	private String contactNo;
	private String designation;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	@JsonIgnoreProperties("employees")
	private Department department;
	
	@ManyToMany
	@JoinTable(name="employeeProject",joinColumns= @JoinColumn(name="empId"), inverseJoinColumns = @JoinColumn(name="projectId"))
	@JsonIgnoreProperties("employee")
	private List<Projects> projects;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmdId() {
		return emdId;
	}
	public void setEmdId(String emdId) {
		this.emdId = emdId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", emdId=" + emdId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", contactNo=" + contactNo + ", designation=" + designation + "]";
	}
	public Employee(long id, String emdId, String firstName, String lastName, String email, String contactNo,
			String designation) {
		super();
		this.id = id;
		this.emdId = emdId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
