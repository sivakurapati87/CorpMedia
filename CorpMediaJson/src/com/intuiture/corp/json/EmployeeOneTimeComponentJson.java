package com.intuiture.corp.json;

import java.util.Date;

public class EmployeeOneTimeComponentJson {
	private Integer employeeOneTimeComponentId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private String oneTimeComponentName;
	private Double amount;
	private Date monthPayable;
	private String strMonthPayable;
	private Integer statusId;
	private String note;
	private String status;

	public Integer getEmployeeOneTimeComponentId() {
		return employeeOneTimeComponentId;
	}

	public void setEmployeeOneTimeComponentId(Integer employeeOneTimeComponentId) {
		this.employeeOneTimeComponentId = employeeOneTimeComponentId;
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

	public String getOneTimeComponentName() {
		return oneTimeComponentName;
	}

	public void setOneTimeComponentName(String oneTimeComponentName) {
		this.oneTimeComponentName = oneTimeComponentName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getMonthPayable() {
		return monthPayable;
	}

	public void setMonthPayable(Date monthPayable) {
		this.monthPayable = monthPayable;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStrMonthPayable() {
		return strMonthPayable;
	}

	public void setStrMonthPayable(String strMonthPayable) {
		this.strMonthPayable = strMonthPayable;
	}

}
