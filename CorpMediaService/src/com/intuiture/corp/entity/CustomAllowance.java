package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customallowance")
public class CustomAllowance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customAllowanceId;
	private String  Name;
	private Integer maxAnnualLimit;
	private Integer taxBenefitId;
	private Integer submitBillId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	public Integer getCustomAllowanceId() {
		return customAllowanceId;
	}
	public void setCustomAllowanceId(Integer customAllowanceId) {
		this.customAllowanceId = customAllowanceId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getMaxAnnualLimit() {
		return maxAnnualLimit;
	}
	public void setMaxAnnualLimit(Integer maxAnnualLimit) {
		this.maxAnnualLimit = maxAnnualLimit;
	}
	public Integer getTaxBenefitId() {
		return taxBenefitId;
	}
	public void setTaxBenefitId(Integer taxBenefitId) {
		this.taxBenefitId = taxBenefitId;
	}
	public Integer getSubmitBillId() {
		return submitBillId;
	}
	public void setSubmitBillId(Integer submitBillId) {
		this.submitBillId = submitBillId;
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
