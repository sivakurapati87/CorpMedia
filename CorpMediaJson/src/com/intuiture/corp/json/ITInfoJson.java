package com.intuiture.corp.json;

import java.util.Date;
import java.util.List;

public class ITInfoJson {
	
	private Integer itInfoId;
	private String pan;
	private String tan;
	private String tanCircleNumber;
	private String citLocation;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private List<CompanySignatorJson> companySignatorJsonList;
	private CompanySignatorJson signator;
	
	
	public Integer getItInfoId() {
		return itInfoId;
	}
	public void setItInfoId(Integer itInfoId) {
		this.itInfoId = itInfoId;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getTan() {
		return tan;
	}
	public void setTan(String tan) {
		this.tan = tan;
	}
	public String getTanCircleNumber() {
		return tanCircleNumber;
	}
	public void setTanCircleNumber(String tanCircleNumber) {
		this.tanCircleNumber = tanCircleNumber;
	}
	public String getCitLocation() {
		return citLocation;
	}
	public void setCitLocation(String citLocation) {
		this.citLocation = citLocation;
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
	public CompanySignatorJson getSignator() {
		return signator;
	}
	public void setSignator(CompanySignatorJson signator) {
		this.signator = signator;
	}

}
