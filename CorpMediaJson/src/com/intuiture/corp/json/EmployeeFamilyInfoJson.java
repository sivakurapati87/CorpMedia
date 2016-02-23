package com.intuiture.corp.json;

public class EmployeeFamilyInfoJson {
	private Integer employeeFamilyInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private Integer relationId;
	private String email;
	private String firstName;
	private Long mobileNumber;
	private String lastName;
	private String relation;

	public Integer getEmployeeFamilyInfoId() {
		return employeeFamilyInfoId;
	}

	public void setEmployeeFamilyInfoId(Integer employeeFamilyInfoId) {
		this.employeeFamilyInfoId = employeeFamilyInfoId;
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

	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
