package com.intuiture.corp.json;

public class TransportAllowanceJson {

	private Integer transportAllowanceId;
	private Long maxAnnualLimit;
	private Integer requireSubmissionId;
	private Integer companyId;

	public Integer getTransportAllowanceId() {
		return transportAllowanceId;
	}

	public void setTransportAllowanceId(Integer transportAllowanceId) {
		this.transportAllowanceId = transportAllowanceId;
	}

	public Long getMaxAnnualLimit() {
		return maxAnnualLimit;
	}

	public void setMaxAnnualLimit(Long maxAnnualLimit) {
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
