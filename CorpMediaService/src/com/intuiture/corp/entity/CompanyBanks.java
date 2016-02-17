package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "companybanks")
public class CompanyBanks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyBankId;
	private Integer bankId;
	private String accountNumber;
	private String ifscCode;
	private String branch;
	private Integer companyId;
	@ManyToOne
	@JoinColumn(name = "bankId", insertable = false, updatable = false)
	private LookUpDetails lookUpDetails;
	private Date createOn;

	public Integer getCompanyBankId() {
		return companyBankId;
	}

	public void setCompanyBankId(Integer companyBankId) {
		this.companyBankId = companyBankId;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LookUpDetails getLookUpDetails() {
		return lookUpDetails;
	}

	public void setLookUpDetails(LookUpDetails lookUpDetails) {
		this.lookUpDetails = lookUpDetails;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

}
