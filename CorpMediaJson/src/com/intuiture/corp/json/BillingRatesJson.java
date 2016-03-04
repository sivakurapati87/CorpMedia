package com.intuiture.corp.json;


public class BillingRatesJson {
	
	private Integer billingRatesId;
	private Integer billingCurrencyId;
	private String billingRole;
	private Integer hourlyRate;
	private Integer weeklyRate;
	private Integer monthlyRate;
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
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	

}
