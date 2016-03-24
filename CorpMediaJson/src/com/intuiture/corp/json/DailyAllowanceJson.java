package com.intuiture.corp.json;

public class DailyAllowanceJson {

	private Integer dailyAllowanceId;
	private Long maxAnnualLimit;
	private Integer requireSubmissionId;
	private Integer companyId;

	public Integer getDailyAllowanceId() {
		return dailyAllowanceId;
	}

	public void setDailyAllowanceId(Integer dailyAllowanceId) {
		this.dailyAllowanceId = dailyAllowanceId;
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
