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
@Table(name = "leavenotify")
public class LeavesNotify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leavesNotifyId;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private Boolean isDeleted;
	private Integer notifyEmpId;
	@ManyToOne
	@JoinColumn(name = "notifyEmpId", insertable = false, updatable = false)
	private Employee employee;

	public Integer getLeavesNotifyId() {
		return leavesNotifyId;
	}

	public void setLeavesNotifyId(Integer leavesNotifyId) {
		this.leavesNotifyId = leavesNotifyId;
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

	public Integer getNotifyEmpId() {
		return notifyEmpId;
	}

	public void setNotifyEmpId(Integer notifyEmpId) {
		this.notifyEmpId = notifyEmpId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
