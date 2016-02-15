package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "esiinfo")
//@NamedQueries({ @NamedQuery(name = "ESIInfo.findBycompanyId", query = "select esi from ESIInfo esi where esi.companyId = ?1") })

public class ESIInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer esiInfoId;
	private String esiNumber;
	private Date registrationDate;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;

	public Integer getEsiInfoId() {
		return esiInfoId;
	}

	public void setEsiInfoId(Integer esiInfoId) {
		this.esiInfoId = esiInfoId;
	}

	public String getEsiNumber() {
		return esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
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


}
