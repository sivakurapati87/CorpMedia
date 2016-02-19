package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ptinfo")
// @NamedQueries({ @NamedQuery(name = "Company.findBycompanyName", query =
// "select c from Company c where c.companyName = ?1") })
public class PTInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ptInfoId;
	private String ptNumber;
	private Date registrationDate;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;

	public Integer getPtInfoId() {
		return ptInfoId;
	}

	public void setPtInfoId(Integer ptInfoId) {
		this.ptInfoId = ptInfoId;
	}

	public String getPtNumber() {
		return ptNumber;
	}

	public void setPtNumber(String ptNumber) {
		this.ptNumber = ptNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
