package com.intuiture.corp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timesheet")
public class TimeSheet implements Serializable {
	private static final long serialVersionUID = -2249145954130817901L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timesheetId;
	private Boolean isDeleted;
	private Date timeSheetDate;

	// @OneToMany(mappedBy = "timesheet")
	// private List<Employee_TimeSheet> employee_TimeSheets;

	public Integer getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getTimeSheetDate() {
		return timeSheetDate;
	}

	public void setTimeSheetDate(Date timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}

	// public List<Employee_TimeSheet> getEmployee_TimeSheets() {
	// return employee_TimeSheets;
	// }
	//
	// public void setEmployee_TimeSheets(List<Employee_TimeSheet>
	// employee_TimeSheets) {
	// this.employee_TimeSheets = employee_TimeSheets;
	// }

}
