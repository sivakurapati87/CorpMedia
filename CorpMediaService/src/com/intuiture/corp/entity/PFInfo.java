package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pfinfo")
//@NamedQueries({ @NamedQuery(name = "PFInfo.findBycompanyId", query = "select pf from PFInfo pf where pf.companyId = ?1") })
public class PFInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pfInfoId;
	private String pfNumber;
	private Date registrationDate;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isSameForAll;

	public Integer getPfInfoId() {
		return pfInfoId;
	}

	public void setPfInfoId(Integer pfInfoId) {
		this.pfInfoId = pfInfoId;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
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

	public Boolean getIsSameForAll() {
		return isSameForAll;
	}

	public void setIsSameForAll(Boolean isSameForAll) {
		this.isSameForAll = isSameForAll;
	}

}
