package com.intuiture.corp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runpayroll")
public class RunPayRoll implements Serializable {
	private static final long serialVersionUID = -9119525567146423370L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer runPayRollId;
	private Integer companyId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Date payRollExecutedDate;
	private Integer payrollCycleSettingsId;
	private String payDay;
	private Date payDate;
	private Date payCycleStartDate;
	private Date payCycleEndDate;

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

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

	public Integer getRunPayRollId() {
		return runPayRollId;
	}

	public void setRunPayRollId(Integer runPayRollId) {
		this.runPayRollId = runPayRollId;
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

	public Date getPayRollExecutedDate() {
		return payRollExecutedDate;
	}

	public void setPayRollExecutedDate(Date payRollExecutedDate) {
		this.payRollExecutedDate = payRollExecutedDate;
	}

	public Integer getPayrollCycleSettingsId() {
		return payrollCycleSettingsId;
	}

	public void setPayrollCycleSettingsId(Integer payrollCycleSettingsId) {
		this.payrollCycleSettingsId = payrollCycleSettingsId;
	}

}
