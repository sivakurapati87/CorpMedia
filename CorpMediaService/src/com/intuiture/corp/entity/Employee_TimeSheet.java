package com.intuiture.corp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_timesheet")
@IdClass(Employee_TimeSheetId.class)
public class Employee_TimeSheet implements Serializable {
	private static final long serialVersionUID = 3506400680737930849L;
	@Id
	private Integer employeeId;
	@Id
	private Integer timesheetId;
	private Integer statusId;
	private Integer projectId;
	private String spendedTime;

	@ManyToOne
	@JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "employeeId")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "timesheetId", updatable = false, insertable = false, referencedColumnName = "timesheetId")
	private TimeSheet timesheet;

	public TimeSheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(TimeSheet timesheet) {
		this.timesheet = timesheet;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSpendedTime() {
		return spendedTime;
	}

	public void setSpendedTime(String spendedTime) {
		this.spendedTime = spendedTime;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
