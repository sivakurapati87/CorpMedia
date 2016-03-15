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
@Table(name = "employeeonetimecomponent")
public class EmployeeOneTimeComponent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeOneTimeComponentId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private String oneTimeComponentName;
	private Double amount;
	private Date monthPayable;
	private Integer statusId;
	private String note;
	@ManyToOne
	@JoinColumn(name = "statusId", insertable = false, updatable = false)
	private LookUpDetails status;

	public Integer getEmployeeOneTimeComponentId() {
		return employeeOneTimeComponentId;
	}

	public void setEmployeeOneTimeComponentId(Integer employeeOneTimeComponentId) {
		this.employeeOneTimeComponentId = employeeOneTimeComponentId;
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

	public String getOneTimeComponentName() {
		return oneTimeComponentName;
	}

	public void setOneTimeComponentName(String oneTimeComponentName) {
		this.oneTimeComponentName = oneTimeComponentName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getMonthPayable() {
		return monthPayable;
	}

	public void setMonthPayable(Date monthPayable) {
		this.monthPayable = monthPayable;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LookUpDetails getStatus() {
		return status;
	}

	public void setStatus(LookUpDetails status) {
		this.status = status;
	}

}
