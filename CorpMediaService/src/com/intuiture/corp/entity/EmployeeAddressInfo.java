package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeaddressinfo")
public class EmployeeAddressInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeAddressInfoId;
	private Integer employeeId;
	private Integer companyId;
	private Boolean isDeleted;
	private String currAddress;
	private String permAddress;
	private String currCity;
	private String permCity;
	private String currState;
	private String permState;
	private String currCountry;
	private String permCountry;
	private Boolean isPermSameAsCurr;
	private Date createdOn;
	private Date updatedOn;

	public Integer getEmployeeAddressInfoId() {
		return employeeAddressInfoId;
	}

	public void setEmployeeAddressInfoId(Integer employeeAddressInfoId) {
		this.employeeAddressInfoId = employeeAddressInfoId;
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

	public String getCurrAddress() {
		return currAddress;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getCurrCity() {
		return currCity;
	}

	public void setCurrCity(String currCity) {
		this.currCity = currCity;
	}

	public String getPermCity() {
		return permCity;
	}

	public void setPermCity(String permCity) {
		this.permCity = permCity;
	}

	public String getCurrState() {
		return currState;
	}

	public void setCurrState(String currState) {
		this.currState = currState;
	}

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getCurrCountry() {
		return currCountry;
	}

	public void setCurrCountry(String currCountry) {
		this.currCountry = currCountry;
	}

	public String getPermCountry() {
		return permCountry;
	}

	public void setPermCountry(String permCountry) {
		this.permCountry = permCountry;
	}

	public Boolean getIsPermSameAsCurr() {
		return isPermSameAsCurr;
	}

	public void setIsPermSameAsCurr(Boolean isPermSameAsCurr) {
		this.isPermSameAsCurr = isPermSameAsCurr;
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
