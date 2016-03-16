package com.intuiture.corp.json;

import java.util.Date;

public class EmployeeTimeSheetJson {
	private Integer employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private String email;
	private Integer locationId;
	private String strDateOfJoining;
	private Integer roleId;
	private Integer companyId;
	private Date dateOfJoining;
	private String role;
	private Integer timesheetId;
	private Date timeSheetDate;
	private String strTimeSheetDate;
	private Integer statusId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getStrDateOfJoining() {
		return strDateOfJoining;
	}

	public void setStrDateOfJoining(String strDateOfJoining) {
		this.strDateOfJoining = strDateOfJoining;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
	}

	public Date getTimeSheetDate() {
		return timeSheetDate;
	}

	public void setTimeSheetDate(Date timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}

	public String getStrTimeSheetDate() {
		return strTimeSheetDate;
	}

	public void setStrTimeSheetDate(String strTimeSheetDate) {
		this.strTimeSheetDate = strTimeSheetDate;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

}
