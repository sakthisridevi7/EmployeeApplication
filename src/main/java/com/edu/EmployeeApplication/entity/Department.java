package com.edu.EmployeeApplication.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Departmenttbl")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long dId;
	@Column(nullable=false , unique=true)
	private String deptId;
	@Column(nullable=false)
	private String deptName;
	private String location;
	private long hodId;
	
	@OneToMany(mappedBy="department")
	@JsonIgnoreProperties("department")
	private List<Employee> employees;
	
	public long getdId() {
		return dId;
	}
	public void setdId(long dId) {
		this.dId = dId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getHodId() {
		return hodId;
	}
	public void setHodId(long hodId) {
		this.hodId = hodId;
	}
	
	
	@Override
	public String toString() {
		return "Department [dId=" + dId + ", deptId=" + deptId + ", deptName=" + deptName + ", location=" + location
				+ ", hodId=" + hodId + "]";
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(long dId, String deptId, String deptName, String location, long hodId) {
		super();
		this.dId = dId;
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
		this.hodId = hodId;
	}
	
	

}
