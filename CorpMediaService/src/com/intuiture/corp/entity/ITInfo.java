package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itinfo")
public class ITInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itInfoId;
	private String pan;
	private String tan;
	private String tanCircleNumber;
	private String citLocation;
	private Integer companySignatorId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;

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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
