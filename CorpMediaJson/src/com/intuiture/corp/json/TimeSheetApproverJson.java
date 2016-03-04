package com.intuiture.corp.json;

import java.util.List;

public class TimeSheetApproverJson {
	private Integer timeSheetApproverId;
	private Integer roleId;
	private Integer employeeId;
	private Integer companyId;
	private List<EmployeeJson> employeeJsonList;

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

	public Integer getTimeSheetApproverId() {
		return timeSheetApproverId;
	}

	public void setTimeSheetApproverId(Integer timeSheetApproverId) {
		this.timeSheetApproverId = timeSheetApproverId;
	}

	public List<EmployeeJson> getEmployeeJsonList() {
		return employeeJsonList;
	}

	public void setEmployeeJsonList(List<EmployeeJson> employeeJsonList) {
		this.employeeJsonList = employeeJsonList;
	}

}
