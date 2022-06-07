package com.edu.EmployeeApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="employeetbl")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private long id;
	private String emdId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String designation;
	
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
