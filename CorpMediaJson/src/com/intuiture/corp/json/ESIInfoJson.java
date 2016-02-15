package com.intuiture.corp.json;

import java.util.Date;
import java.util.List;

public class ESIInfoJson {
	
	private Integer esiInfoId;
	private String esiNumber;
	private Date registrationDate;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private List<CompanySignatorJson> companySignatorJsonList;
	private String strRegistrationDate;
	private CompanySignatorJson signator;
	
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
	public List<CompanySignatorJson> getCompanySignatorJsonList() {
		return companySignatorJsonList;
	}
	public void setCompanySignatorJsonList(
			List<CompanySignatorJson> companySignatorJsonList) {
		this.companySignatorJsonList = companySignatorJsonList;
	}
	public String getStrRegistrationDate() {
		return strRegistrationDate;
	}
	public void setStrRegistrationDate(String strRegistrationDate) {
		this.strRegistrationDate = strRegistrationDate;
	}
	public CompanySignatorJson getSignator() {
		return signator;
	}
	public void setSignator(CompanySignatorJson signator) {
		this.signator = signator;
	}

}
