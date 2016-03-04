package com.intuiture.corp.json;


public class PayrollPeriodCalculationJson {
	
	private Integer payrollPeriodCalculationId;
	private Integer payDaysInAMonthId;;
	private Integer excludeWeeklyOffsId;
	private Integer excludeHolidaysId;
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
