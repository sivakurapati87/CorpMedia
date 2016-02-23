package com.intuiture.corp.json;


public class MedicalReimbursementJson {
	
	private Integer medicalReimbursementId;
	private String maxAnnualLimit;
	private String requireSubmission;
	private Integer companyId;
	
	public Integer getMedicalReimbursementId() {
		return medicalReimbursementId;
	}
	public void setMedicalReimbursementId(Integer medicalReimbursementId) {
		this.medicalReimbursementId = medicalReimbursementId;
	}
	public String getMaxAnnualLimit() {
		return maxAnnualLimit;
	}
	public void setMaxAnnualLimit(String maxAnnualLimit) {
		this.maxAnnualLimit = maxAnnualLimit;
	}
	public String getRequireSubmission() {
		return requireSubmission;
	}
	public void setRequireSubmission(String requireSubmission) {
		this.requireSubmission = requireSubmission;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	

}
