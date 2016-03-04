package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payrollcyclesettings")
public class PayrollCycleSettings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payrollCyycleSettingsId;
	private String payFrequency;
	private Integer payCycleMonthId;
	private Integer payPeriodEndDayId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	
	
	public String getPayFrequency() {
		return payFrequency;
	}
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	public Integer getPayrollCyycleSettingsId() {
		return payrollCyycleSettingsId;
	}
	public void setPayrollCyycleSettingsId(Integer payrollCyycleSettingsId) {
		this.payrollCyycleSettingsId = payrollCyycleSettingsId;
	}
	public Integer getPayCycleMonthId() {
		return payCycleMonthId;
	}
	public void setPayCycleMonthId(Integer payCycleMonthId) {
		this.payCycleMonthId = payCycleMonthId;
	}
	public Integer getPayPeriodEndDayId() {
		return payPeriodEndDayId;
	}
	public void setPayPeriodEndDayId(Integer payPeriodEndDayId) {
		this.payPeriodEndDayId = payPeriodEndDayId;
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
