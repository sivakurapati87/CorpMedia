package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payrollperiodcalculation")
public class PayrollPeriodCalculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payrollPeriodCalculationId;
	private Integer payDaysInAMonthId;;
	private Integer excludeWeeklyOffsId;
	private Integer excludeHolidaysId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	public Integer getPayrollPeriodCalculationId() {
		return payrollPeriodCalculationId;
	}
	public void setPayrollPeriodCalculationId(Integer payrollPeriodCalculationId) {
		this.payrollPeriodCalculationId = payrollPeriodCalculationId;
	}
	
	public Integer getExcludeWeeklyOffsId() {
		return excludeWeeklyOffsId;
	}
	public void setExcludeWeeklyOffsId(Integer excludeWeeklyOffsId) {
		this.excludeWeeklyOffsId = excludeWeeklyOffsId;
	}
	public Integer getExcludeHolidaysId() {
		return excludeHolidaysId;
	}
	public void setExcludeHolidaysId(Integer excludeHolidaysId) {
		this.excludeHolidaysId = excludeHolidaysId;
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
	public Integer getPayDaysInAMonthId() {
		return payDaysInAMonthId;
	}
	public void setPayDaysInAMonthId(Integer payDaysInAMonthId) {
		this.payDaysInAMonthId = payDaysInAMonthId;
	}
	
	

}
