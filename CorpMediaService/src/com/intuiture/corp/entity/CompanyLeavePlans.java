package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyleaveplans")
public class CompanyLeavePlans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyLeavePlansId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;
	private String leavePlanName;
	private String description;

	public Integer getCompanyLeavePlansId() {
		return companyLeavePlansId;
	}

	public void setCompanyLeavePlansId(Integer companyLeavePlansId) {
		this.companyLeavePlansId = companyLeavePlansId;
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

	public String getLeavePlanName() {
		return leavePlanName;
	}

	public void setLeavePlanName(String leavePlanName) {
		this.leavePlanName = leavePlanName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
