package com.intuiture.corp.entity;

//@Embeddable
public class Employee_LeaveId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer employeeId;
	private Integer leaveId;

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

	public boolean equals(Object object) {
		if (object instanceof Employee_LeaveId) {
			Employee_LeaveId otherId = (Employee_LeaveId) object;
			return (otherId.employeeId == this.employeeId) && (otherId.leaveId == this.leaveId);
		}
		return false;
	}

	public int hashCode() {
		return (int) (employeeId + leaveId);
	}

}
