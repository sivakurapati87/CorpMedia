package com.intuiture.corp.json;

public class CompanySignatorJson {
	private Integer companySignatorId;
	private Integer companyId;
	private String signatorName;
	private String email;
	private String mobile;
	private String phone;
	private String dinNumber;
	private Boolean isManagingDirector;
	private Boolean isSecretory;
	private String address;
	private String designation;
	private String fatherName;
	private String panNumber;

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Integer getCompanySignatorId() {
		return companySignatorId;
	}

	public void setCompanySignatorId(Integer companySignatorId) {
		this.companySignatorId = companySignatorId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getSignatorName() {
		return signatorName;
	}

	public void setSignatorName(String signatorName) {
		this.signatorName = signatorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDinNumber() {
		return dinNumber;
	}

	public void setDinNumber(String dinNumber) {
		this.dinNumber = dinNumber;
	}

	public Boolean getIsManagingDirector() {
		return isManagingDirector;
	}

	public void setIsManagingDirector(Boolean isManagingDirector) {
		this.isManagingDirector = isManagingDirector;
	}

	public Boolean getIsSecretory() {
		return isSecretory;
	}

	public void setIsSecretory(Boolean isSecretory) {
		this.isSecretory = isSecretory;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
