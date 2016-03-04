package com.intuiture.corp.json;


public class CustomAllowanceJson {
	private Integer customAllowanceId;
	private String  Name;
	private Integer maxAnnualLimit;
	private Integer taxBenefitId;
	private Integer submitBillId;
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
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	

}
