package com.intuiture.corp.json;

public class EmployeeLeaveJson {
	private Integer employeeId;
	private Integer leaveId;
	private Integer statusId;
	private Integer projectId;
	private String leaveTime;
	private String strLeaveStartTime;
	private String strLeaveEndTime;
	private String strTotalLeaveTime;

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

	public String getStrLeaveStartTime() {
		return strLeaveStartTime;
	}

	public void setStrLeaveStartTime(String strLeaveStartTime) {
		this.strLeaveStartTime = strLeaveStartTime;
	}

	public String getStrLeaveEndTime() {
		return strLeaveEndTime;
	}

	public void setStrLeaveEndTime(String strLeaveEndTime) {
		this.strLeaveEndTime = strLeaveEndTime;
	}

	public String getStrTotalLeaveTime() {
		return strTotalLeaveTime;
	}

	public void setStrTotalLeaveTime(String strTotalLeaveTime) {
		this.strTotalLeaveTime = strTotalLeaveTime;
	}

}
