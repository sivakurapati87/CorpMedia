package com.intuiture.corp.json;

public class CompanyLocationJson {
	private Integer companyLocationId;
	private Integer companyId;
	private Integer stateId;
	private String address;
	private String city;
	private Long zipcode;
	private String locationName;

	public Integer getCompanyLocationId() {
		return companyLocationId;
	}

	public void setCompanyLocationId(Integer companyLocationId) {
		this.companyLocationId = companyLocationId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
