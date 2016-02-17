package com.intuiture.corp.bean;

import java.util.List;

import com.intuiture.corp.json.LookUpDetailJson;

public class LookupBean {

	private List<LookUpDetailJson> banksList;
	private List<LookUpDetailJson> typeOfBusinessList;
	private List<LookUpDetailJson> statesList;

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
