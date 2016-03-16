package com.intuiture.corp.entity;


//@Embeddable
public class Employee_TimeSheetId implements java.io.Serializable {
	private static final long serialVersionUID = 4259433945147616320L;
	private Integer employeeId;
	private Integer timesheetId;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals(Object object) {
		if (object instanceof Employee_TimeSheetId) {
			Employee_TimeSheetId otherId = (Employee_TimeSheetId) object;
			return (otherId.employeeId == this.employeeId) && (otherId.timesheetId == this.timesheetId);
		}
		return false;
	}

	public int hashCode() {
		return (int) (employeeId + timesheetId);
	}

}
