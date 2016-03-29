package com.intuiture.corp.entity;

//@Embeddable
public class Employee_RunPayRollId implements java.io.Serializable {
	private static final long serialVersionUID = 5641038427315265009L;
	private Integer employeeId;
	private Integer runPayRollId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRunPayRollId() {
		return runPayRollId;
	}

	public void setRunPayRollId(Integer runPayRollId) {
		this.runPayRollId = runPayRollId;
	}

	public boolean equals(Object object) {
		if (object instanceof Employee_RunPayRollId) {
			Employee_RunPayRollId otherId = (Employee_RunPayRollId) object;
			return (otherId.employeeId == this.employeeId) && (otherId.runPayRollId == this.runPayRollId);
		}
		return false;
	}

	public int hashCode() {
		return (int) (employeeId + runPayRollId);
	}

}
