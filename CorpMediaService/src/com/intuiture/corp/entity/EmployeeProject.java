package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeeproject")
public class EmployeeProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeProjectId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer projectId;
	private Integer roleId;
	@ManyToOne
	@JoinColumn(name = "projectId", insertable = false, updatable = false)
	private Project project;
	@ManyToOne
	@JoinColumn(name = "roleId", insertable = false, updatable = false)
	private CompanyRoles companyRoles;

	public Integer getEmployeeProjectId() {
		return employeeProjectId;
	}

	public void setEmployeeProjectId(Integer employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public CompanyRoles getCompanyRoles() {
		return companyRoles;
	}

	public void setCompanyRoles(CompanyRoles companyRoles) {
		this.companyRoles = companyRoles;
	}

}
