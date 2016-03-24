package com.intuiture.corp.json;

public class PayrollCycleSettingsJson {

	private Integer payrollCycleSettingsId;
	private String payFrequency;
	private Integer payCycleMonthId;
	private Integer companyId;
	private String payDay;
	private String strPayPeriodEndDay;
	private String strPayDate;
	private Integer noOfDaysOfTheMonth;
	private String strPayCycleStartDate;
	private String strPayCycleEndDate;

	public String getPayFrequency() {
		return payFrequency;
	}

	public String getStrPayDate() {
		return strPayDate;
	}

	public void setStrPayDate(String strPayDate) {
		this.strPayDate = strPayDate;
	}

	public String getStrPayCycleStartDate() {
		return strPayCycleStartDate;
	}

	public void setStrPayCycleStartDate(String strPayCycleStartDate) {
		this.strPayCycleStartDate = strPayCycleStartDate;
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

	public String getStrPayCycleEndDate() {
		return strPayCycleEndDate;
	}

	public void setStrPayCycleEndDate(String strPayCycleEndDate) {
		this.strPayCycleEndDate = strPayCycleEndDate;
	}

	public String getStrPayPeriodEndDay() {
		return strPayPeriodEndDay;
	}

	public void setStrPayPeriodEndDay(String strPayPeriodEndDay) {
		this.strPayPeriodEndDay = strPayPeriodEndDay;
	}

	public Integer getNoOfDaysOfTheMonth() {
		return noOfDaysOfTheMonth;
	}

	public void setNoOfDaysOfTheMonth(Integer noOfDaysOfTheMonth) {
		this.noOfDaysOfTheMonth = noOfDaysOfTheMonth;
	}

}
