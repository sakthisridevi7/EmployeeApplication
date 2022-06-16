package com.edu.EmployeeApplication.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Projects {
	@Id
	private long id;
	private String projectId;
	private String title;
	private Date startDate;
	private Date endDate;
	
	@ManyToMany(mappedBy="projects")
	@JsonIgnoreProperties("projects")
	private List<Employee> employee;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	public Projects(long id, String projectId, String title, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
