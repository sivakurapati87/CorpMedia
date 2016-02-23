package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allowances")
public class Allowances {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer allowancesId;
	private String allowancesName;
	private String allowancesDescription;
	private String hasTaxBenefits;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	
	public Integer getAllowancesId() {
		return allowancesId;
	}
	public void setAllowancesId(Integer allowancesId) {
		this.allowancesId = allowancesId;
	}
	public String getAllowancesName() {
		return allowancesName;
	}
	public void setAllowancesName(String allowancesName) {
		this.allowancesName = allowancesName;
	}
	public String getAllowancesDescription() {
		return allowancesDescription;
	}
	public void setAllowancesDescription(String allowancesDescription) {
		this.allowancesDescription = allowancesDescription;
	}
	public String getHasTaxBenefits() {
		return hasTaxBenefits;
	}
	public void setHasTaxBenefits(String hasTaxBenefits) {
		this.hasTaxBenefits = hasTaxBenefits;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
