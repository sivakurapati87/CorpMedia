package com.intuiture.corp.json;

public class TravelReimbursementJson {

	private Integer travelReimbursementId;
	private Double maxAnnualLimit;
	private Integer requireSubmissionId;
	private Integer companyId;

	public Integer getTravelReimbursementId() {
		return travelReimbursementId;
	}

	public void setTravelReimbursementId(Integer travelReimbursementId) {
		this.travelReimbursementId = travelReimbursementId;
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
