package com.intuiture.corp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "companysignator")
//@NamedQueries({ @NamedQuery(name = "CompanySignator.findByCompanyIds", query = "select c from CompanySignator c where c.companyId in ?1"),
//		@NamedQuery(name = "CompanySignator.findByCompanyId", query = "select c from CompanySignator c where c.companyId = ?1") })
public class CompanySignator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companySignatorId;
	private Integer companyId;
	@ManyToOne
	@JoinColumn(name = "companyId", insertable = false, updatable = false)
	private Company company;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
