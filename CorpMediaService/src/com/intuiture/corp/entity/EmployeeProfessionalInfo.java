package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeprofessionalinfo")
public class EmployeeProfessionalInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeProfessionalInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private String professionalSummery;
	private String statusMessage;

	public Integer getEmployeeProfessionalInfoId() {
		return employeeProfessionalInfoId;
	}

	public void setEmployeeProfessionalInfoId(Integer employeeProfessionalInfoId) {
		this.employeeProfessionalInfoId = employeeProfessionalInfoId;
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

	public String getProfessionalSummery() {
		return professionalSummery;
	}

	public void setProfessionalSummery(String professionalSummery) {
		this.professionalSummery = professionalSummery;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
