package com.intuiture.corp.json;

import java.util.Date;

public class EmployeeEducationalInfoJson {
	private Integer employeeEducationalInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private String degree;
	private String specialization;
	private String university;
	private Date fromDate;
	private Date toDate;
	private String strFromDate;
	private String strToDate;

	public Integer getEmployeeEducationalInfoId() {
		return employeeEducationalInfoId;
	}

	public void setEmployeeEducationalInfoId(Integer employeeEducationalInfoId) {
		this.employeeEducationalInfoId = employeeEducationalInfoId;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStrFromDate() {
		return strFromDate;
	}

	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	public String getStrToDate() {
		return strToDate;
	}

	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

}
