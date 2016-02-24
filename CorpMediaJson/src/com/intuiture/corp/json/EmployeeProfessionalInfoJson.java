package com.intuiture.corp.json;


public class EmployeeProfessionalInfoJson {
	private Integer employeeProfessionalInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private String professionalSummery;
	private String statusMessage;

	public Integer getEmployeeProfessionalInfoId() {
		return employeeProfessionalInfoId;
	}

	public void setEmployeeProfessionalInfoId(Integer employeeProfessionalInfoId) {
		this.employeeProfessionalInfoId = employeeProfessionalInfoId;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getProfessionalSummery() {
		return professionalSummery;
	}

	public void setProfessionalSummery(String professionalSummery) {
		this.professionalSummery = professionalSummery;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
