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
@Table(name = "timesheetapprovers")
public class TimeSheetApprovers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timeSheetApproverId;
	private Integer roleId;
	private Integer employeeId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	@ManyToOne
	@JoinColumn(name = "roleId", insertable = false, updatable = false)
	private CompanyRoles companyRoles;
	private Boolean isDeleted;

	public Integer getTimeSheetApproverId() {
		return timeSheetApproverId;
	}

	public void setTimeSheetApproverId(Integer timeSheetApproverId) {
		this.timeSheetApproverId = timeSheetApproverId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public CompanyRoles getCompanyRoles() {
		return companyRoles;
	}

	public void setCompanyRoles(CompanyRoles companyRoles) {
		this.companyRoles = companyRoles;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
