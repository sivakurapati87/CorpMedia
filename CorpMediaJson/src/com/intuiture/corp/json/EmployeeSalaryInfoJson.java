package com.intuiture.corp.json;

import java.util.Date;
import java.util.List;

public class EmployeeSalaryInfoJson {
	private Integer employeeSalaryInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private Long annualSalary;
	private Date effectiveFrom;
	private String strEffectiveFrom;
	private EmployeeJson employeeJson;
	private SalaryComponentJson salaryComponentJson;
	private List<EmployeeOneTimeComponentJson> employeeOneTimeComponentJsonList;

	public Integer getEmployeeSalaryInfoId() {
		return employeeSalaryInfoId;
	}

	public void setEmployeeSalaryInfoId(Integer employeeSalaryInfoId) {
		this.employeeSalaryInfoId = employeeSalaryInfoId;
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

	public Long getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Long annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	public SalaryComponentJson getSalaryComponentJson() {
		return salaryComponentJson;
	}

	public void setSalaryComponentJson(SalaryComponentJson salaryComponentJson) {
		this.salaryComponentJson = salaryComponentJson;
	}

	public List<EmployeeOneTimeComponentJson> getEmployeeOneTimeComponentJsonList() {
		return employeeOneTimeComponentJsonList;
	}

	public void setEmployeeOneTimeComponentJsonList(List<EmployeeOneTimeComponentJson> employeeOneTimeComponentJsonList) {
		this.employeeOneTimeComponentJsonList = employeeOneTimeComponentJsonList;
	}

	public EmployeeJson getEmployeeJson() {
		return employeeJson;
	}

	public void setEmployeeJson(EmployeeJson employeeJson) {
		this.employeeJson = employeeJson;
	}

}
