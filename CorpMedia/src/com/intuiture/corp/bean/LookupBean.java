package com.intuiture.corp.bean;

import java.util.List;

import com.intuiture.corp.json.LookUpDetailJson;

public class LookupBean {

	private List<LookUpDetailJson> banksList;
	private List<LookUpDetailJson> typeOfBusinessList;
	private List<LookUpDetailJson> statesList;
	private List<LookUpDetailJson> daysWeeksMonthsList;
	private List<LookUpDetailJson> workerTypeList;
	private List<LookUpDetailJson> timeTypeList;
	private List<LookUpDetailJson> genderList;
	private List<LookUpDetailJson> maritalStatusList;
	private List<LookUpDetailJson> bloodGroupList;

	public List<LookUpDetailJson> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<LookUpDetailJson> genderList) {
		this.genderList = genderList;
	}

	public List<LookUpDetailJson> getMaritalStatusList() {
		return maritalStatusList;
	}

	public void setMaritalStatusList(List<LookUpDetailJson> maritalStatusList) {
		this.maritalStatusList = maritalStatusList;
	}

	public List<LookUpDetailJson> getBloodGroupList() {
		return bloodGroupList;
	}

	public void setBloodGroupList(List<LookUpDetailJson> bloodGroupList) {
		this.bloodGroupList = bloodGroupList;
	}

	public List<LookUpDetailJson> getDaysWeeksMonthsList() {
		return daysWeeksMonthsList;
	}

	public void setDaysWeeksMonthsList(List<LookUpDetailJson> daysWeeksMonthsList) {
		this.daysWeeksMonthsList = daysWeeksMonthsList;
	}

	public List<LookUpDetailJson> getWorkerTypeList() {
		return workerTypeList;
	}

	public void setWorkerTypeList(List<LookUpDetailJson> workerTypeList) {
		this.workerTypeList = workerTypeList;
	}

	public List<LookUpDetailJson> getTimeTypeList() {
		return timeTypeList;
	}

	public void setTimeTypeList(List<LookUpDetailJson> timeTypeList) {
		this.timeTypeList = timeTypeList;
	}

	public List<LookUpDetailJson> getBanksList() {
		return banksList;
	}

	public void setBanksList(List<LookUpDetailJson> banksList) {
		this.banksList = banksList;
	}

	public List<LookUpDetailJson> getTypeOfBusinessList() {
		return typeOfBusinessList;
	}

	public void setTypeOfBusinessList(List<LookUpDetailJson> typeOfBusinessList) {
		this.typeOfBusinessList = typeOfBusinessList;
	}

	public List<LookUpDetailJson> getStatesList() {
		return statesList;
	}

	public void setStatesList(List<LookUpDetailJson> statesList) {
		this.statesList = statesList;
	}
}
