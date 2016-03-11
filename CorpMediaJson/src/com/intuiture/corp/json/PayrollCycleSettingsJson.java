package com.intuiture.corp.json;

public class PayrollCycleSettingsJson {

	private Integer payrollCycleSettingsId;
	private String payFrequency;
	private Integer payCycleMonthId;
	private Integer payPeriodEndDayId;
	private Integer companyId;
	private String payDay;
	private String strPayPeriodEndDayId;

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

	public Integer getPayPeriodEndDayId() {
		return payPeriodEndDayId;
	}

	public void setPayPeriodEndDayId(Integer payPeriodEndDayId) {
		this.payPeriodEndDayId = payPeriodEndDayId;
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

	public String getStrPayPeriodEndDayId() {
		return strPayPeriodEndDayId;
	}

	public void setStrPayPeriodEndDayId(String strPayPeriodEndDayId) {
		this.strPayPeriodEndDayId = strPayPeriodEndDayId;
	}

}
