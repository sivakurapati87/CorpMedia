package com.intuiture.corp.json;

import java.util.Date;

public class EmployeeLeaveJson {
	private Integer employeeId;
	private Integer leaveId;
	private Integer statusId;
	private Integer projectId;
	private String leaveTime;
	private String strLeaveStartDate;
	private String strLeaveEndDate;
	private String strTotalLeaveTime;
	private Integer leaveTypeId;
	private String note;
	private Date leaveStartDate;
	private Date leaveEndDate;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	public String getStrLeaveStartDate() {
		return strLeaveStartDate;
	}

	public void setStrLeaveStartDate(String strLeaveStartDate) {
		this.strLeaveStartDate = strLeaveStartDate;
	}

	public String getStrLeaveEndDate() {
		return strLeaveEndDate;
	}

	public void setStrLeaveEndDate(String strLeaveEndDate) {
		this.strLeaveEndDate = strLeaveEndDate;
	}

	public String getStrTotalLeaveTime() {
		return strTotalLeaveTime;
	}

	public void setStrTotalLeaveTime(String strTotalLeaveTime) {
		this.strTotalLeaveTime = strTotalLeaveTime;
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

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

}
