package com.intuiture.corp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_leavesheet")
@IdClass(Employee_LeaveId.class)
public class Employee_Leave implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer employeeId;
	@Id
	private Integer leaveId;
	private Integer statusId;
	private Integer projectId;
	private String leaveTime;
	private Integer leaveTypeId;
	private String note;
	private Date appliedOn;
	private String comment;
	private Integer approvedOrRejectedById;
	@ManyToOne
	@JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "employeeId")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "leaveId", updatable = false, insertable = false, referencedColumnName = "leaveId")
	private Leave leave;
	@ManyToOne
	@JoinColumn(name = "leaveTypeId", insertable = false, updatable = false)
	private CompanyLeaveType companyLeaveType;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CompanyLeaveType getCompanyLeaveType() {
		return companyLeaveType;
	}

	public void setCompanyLeaveType(CompanyLeaveType companyLeaveType) {
		this.companyLeaveType = companyLeaveType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Integer getApprovedOrRejectedById() {
		return approvedOrRejectedById;
	}

	public void setApprovedOrRejectedById(Integer approvedOrRejectedById) {
		this.approvedOrRejectedById = approvedOrRejectedById;
	}

}
