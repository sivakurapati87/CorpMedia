package com.intuiture.corp.json;


public class AllowancesJson {
	
	private Integer allowancesId;
	private String allowancesName;
	private String allowancesDescription;
	private String hasTaxBenefits;
	private Integer companyId;
	
	public Integer getAllowancesId() {
		return allowancesId;
	}
	public void setAllowancesId(Integer allowancesId) {
		this.allowancesId = allowancesId;
	}
	public String getAllowancesName() {
		return allowancesName;
	}
	public void setAllowancesName(String allowancesName) {
		this.allowancesName = allowancesName;
	}
	public String getAllowancesDescription() {
		return allowancesDescription;
	}
	public void setAllowancesDescription(String allowancesDescription) {
		this.allowancesDescription = allowancesDescription;
	}
	public String getHasTaxBenefits() {
		return hasTaxBenefits;
	}
	public void setHasTaxBenefits(String hasTaxBenefits) {
		this.hasTaxBenefits = hasTaxBenefits;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
