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
	private Integer payrollCycleSettingsId;
	private String payFrequency;
	private Integer payCycleMonthId;
	private String strPayPeriodEndDay;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private String payDay;
	private Date payDate;
	private Date payCycleStartDate;
	private Date payCycleEndDate;

	public Date getPayCycleStartDate() {
		return payCycleStartDate;
	}

	public void setPayCycleStartDate(Date payCycleStartDate) {
		this.payCycleStartDate = payCycleStartDate;
	}

	public Date getPayCycleEndDate() {
		return payCycleEndDate;
	}

	public void setPayCycleEndDate(Date payCycleEndDate) {
		this.payCycleEndDate = payCycleEndDate;
	}

	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public Integer getPayCycleMonthId() {
		return payCycleMonthId;
	}

	public void setPayCycleMonthId(Integer payCycleMonthId) {
		this.payCycleMonthId = payCycleMonthId;
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

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public Integer getPayrollCycleSettingsId() {
		return payrollCycleSettingsId;
	}

	public void setPayrollCycleSettingsId(Integer payrollCycleSettingsId) {
		this.payrollCycleSettingsId = payrollCycleSettingsId;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getStrPayPeriodEndDay() {
		return strPayPeriodEndDay;
	}

	public void setStrPayPeriodEndDay(String strPayPeriodEndDay) {
		this.strPayPeriodEndDay = strPayPeriodEndDay;
	}

}
