package com.intuiture.corp.json;

public class MedicalReimbursementJson {

	private Integer medicalReimbursementId;
	private Double maxAnnualLimit;
	private Integer requireSubmissionId;
	private Integer companyId;

	public Integer getMedicalReimbursementId() {
		return medicalReimbursementId;
	}

	public void setMedicalReimbursementId(Integer medicalReimbursementId) {
		this.medicalReimbursementId = medicalReimbursementId;
	}

	public Double getMaxAnnualLimit() {
		return maxAnnualLimit;
	}

	public void setMaxAnnualLimit(Double maxAnnualLimit) {
		this.maxAnnualLimit = maxAnnualLimit;
	}

	public Integer getRequireSubmissionId() {
		return requireSubmissionId;
	}

	public void setRequireSubmissionId(Integer requireSubmissionId) {
		this.requireSubmissionId = requireSubmissionId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
