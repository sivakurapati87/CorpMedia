package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billingrates")
public class BillingRates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billingRatesId;
	private Integer billingCurrencyId;
	private String billingRole;
	private Integer hourlyRate;
	private Integer weeklyRate;
	private Integer monthlyRate;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	public Integer getBillingRatesId() {
		return billingRatesId;
	}
	public void setBillingRatesId(Integer billingRatesId) {
		this.billingRatesId = billingRatesId;
	}
	public Integer getBillingCurrencyId() {
		return billingCurrencyId;
	}
	public void setBillingCurrencyId(Integer billingCurrencyId) {
		this.billingCurrencyId = billingCurrencyId;
	}
	public String getBillingRole() {
		return billingRole;
	}
	public void setBillingRole(String billingRole) {
		this.billingRole = billingRole;
	}
	public Integer getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public Integer getWeeklyRate() {
		return weeklyRate;
	}
	public void setWeeklyRate(Integer weeklyRate) {
		this.weeklyRate = weeklyRate;
	}
	public Integer getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(Integer monthlyRate) {
		this.monthlyRate = monthlyRate;
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
