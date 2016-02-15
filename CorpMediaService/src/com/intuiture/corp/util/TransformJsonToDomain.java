package com.intuiture.corp.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intuiture.corp.entity.Banks;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanyInfo;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.PFInfoJson;

public class TransformJsonToDomain {
	private static Logger LOG = Logger.getLogger(TransformJsonToDomain.class);

	public static List<Company> getCompanyFromJson() {
		List<Company> companiesList = new ArrayList<Company>();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.COMPANYJSONFILE));
			JsonArray mainArray = (JsonArray) obj;
			for (int i = 0; i < mainArray.size(); i++) {
				Company company = new Company();
				JsonObject companyInfoObj = (JsonObject) mainArray.get(i);
				company.setCompanyName(companyInfoObj.get("company name").getAsString());
				company.setCin(companyInfoObj.get("CIN").getAsString());
				company.setCreatedOn(new Date());
				companiesList.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getCompanyFromJson():" + e.getMessage(), e);
		}
		return companiesList;
	}

	public static List<Banks> getBanksJson() {
		List<Banks> banksList = new ArrayList<Banks>();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.BANKJSONFILE));
			JsonArray mainArray = (JsonArray) obj;
			for (int i = 0; i < mainArray.size(); i++) {
				Banks bank = new Banks();
				JsonObject bankObj = (JsonObject) mainArray.get(i);
				bank.setBankName(bankObj.get("name").getAsString());
				banksList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getBanksJson():" + e.getMessage(), e);
		}
		return banksList;
	}

	public static CompanyInfo getCompanyInfoFromJson(String companyName) {
		CompanyInfo companyInfo = new CompanyInfo();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.COMPANYJSONFILE));
			JsonArray mainArray = (JsonArray) obj;
			for (int i = 0; i < mainArray.size(); i++) {
				JsonObject companyInfoObj = (JsonObject) mainArray.get(i);
				if (companyInfoObj.get("Company Name").getAsString().trim().equalsIgnoreCase(companyName.trim())) {
					companyInfo.setAddress1(companyInfoObj.get("Address 1").getAsString());
					companyInfo.setAddress2(companyInfoObj.get("Address 2").getAsString());
					companyInfo.setBoardNumber(companyInfoObj.get("Number of Members(Applicable only in case of company without Share Capital)").getAsString());
					companyInfo.setCity(companyInfoObj.get("City").getAsString());
					companyInfo.setCompanyType(companyInfoObj.get("Class of Company").getAsString());
					companyInfo.setD_o_incorporation(CorpoMediaUtil.convertStringToDate(companyInfoObj.get("Date of Incorporation").getAsString()));
					companyInfo.setEmail(companyInfoObj.get("Email Id").getAsString());
					companyInfo.setDateOfLastAGM(CorpoMediaUtil.convertStringToDate(companyInfoObj.get("Date of Last AGM").getAsString()));
					companyInfo.setIsListed(CorpoMediaUtil.getBooleanValues(companyInfoObj.get("Whether listed or not").getAsString()));
					companyInfo.setIsRegisteredWithRoc(CorpoMediaUtil.getBooleanValues(companyInfoObj.get("ROC Code").getAsString()));
					companyInfo.setRegistrationNumber(companyInfoObj.get("Registration Number").getAsString());
					companyInfo.setState(companyInfoObj.get("State").getAsString());
					companyInfo.setPincode(companyInfoObj.get("Pin").getAsString());
					companyInfo.setCountry(companyInfoObj.get("Country").getAsString());
					companyInfo.setDateOfBalanceSheet(CorpoMediaUtil.convertStringToDate(companyInfoObj.get("Date of Balance sheet").getAsString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getCompanyInfoFromJson():" + e.getMessage(), e);
		}
		return companyInfo;
	}

	public static List<CompanySignator> getCompanyCompanySignatorFromJson(String companyName) {
		List<CompanySignator> companySignatorsList = new ArrayList<CompanySignator>();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.SIGNATORSJSONFILE));
			JsonArray mainArray = (JsonArray) obj;
			for (int i = 0; i < mainArray.size(); i++) {
				JsonObject companyInfoObj = (JsonObject) mainArray.get(i);
				if (companyInfoObj.get("company name").getAsString().trim().equalsIgnoreCase(companyName.trim())) {
					JsonArray signatorArray = (JsonArray) companyInfoObj.get("signators");
					if (signatorArray != null) {
						for (int j = 0; j < signatorArray.size(); j++) {
							CompanySignator companySignator = new CompanySignator();
							JsonObject signatorInfoObj = (JsonObject) signatorArray.get(j);
							companySignator.setAddress(signatorInfoObj.get("Address").getAsString());
							companySignator.setDinNumber(signatorInfoObj.get("DIN").getAsString());
							companySignator.setIsManagingDirector(CorpoMediaUtil.isDirector(signatorInfoObj.get("Designation").getAsString()));
							companySignator.setSignatorName(signatorInfoObj.get("Director Name").getAsString());
							companySignator.setIsSecretory(CorpoMediaUtil.isSecretory(signatorInfoObj.get("Designation").getAsString()));
							companySignator.setDesignation(signatorInfoObj.get("Designation").getAsString());
							companySignatorsList.add(companySignator);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getCompanyCompanySignatorFromJson():" + e.getMessage(), e);
		}
		return companySignatorsList;
	}

	public static void getPFInfoByJson(PFInfoJson pfInfoJson, PFInfo pfInfo) {
		pfInfo.setCompanyId(pfInfoJson.getCompanyId());
		pfInfo.setCompanySignatorId(pfInfoJson.getCompanySignatorId());
		if (pfInfo.getPfInfoId() != null) {
			pfInfo.setUpdatedOn(CorpoMediaUtil.convertStringToDate(CorpoMediaUtil.convertDateToString(new Date())));
		} else {
			pfInfo.setCreatedOn(new Date());
		}
		pfInfo.setRegistrationDate(pfInfoJson.getRegistrationDate());
		pfInfo.setIsSameForAll(pfInfoJson.getIsSameForAll());
		pfInfo.setPfNumber(pfInfoJson.getPfNumber());
		pfInfo.setRegistrationDate(pfInfoJson.getRegistrationDate());
	}

	public static void getITInfoByJson(ITInfoJson itInfoJson, ITInfo itInfo) {
		itInfo.setCompanyId(itInfoJson.getCompanyId());
		itInfo.setCompanySignatorId(itInfoJson.getCompanySignatorId());
		itInfo.setPan(itInfoJson.getPan());
		itInfo.setTan(itInfoJson.getTan());
		itInfo.setCitLocation(itInfoJson.getCitLocation());
		itInfo.setTanCircleNumber(itInfoJson.getTanCircleNumber());
		if (itInfo.getItInfoId() != null) {
			itInfo.setUpdatedOn(CorpoMediaUtil.convertStringToDate(CorpoMediaUtil.convertDateToString(new Date())));
		} else {
			itInfo.setCreatedOn(new Date());
		}
	}

	public static void getESIInfoByJson(ESIInfoJson esiInfoJson, ESIInfo esiInfo) {
		esiInfo.setCompanyId(esiInfoJson.getCompanyId());
		esiInfo.setCompanySignatorId(esiInfoJson.getCompanySignatorId());
		esiInfo.setEsiNumber(esiInfoJson.getEsiNumber());
		esiInfo.setRegistrationDate(esiInfoJson.getRegistrationDate());

		if (esiInfo.getEsiInfoId() != null) {
			esiInfo.setUpdatedOn(CorpoMediaUtil.convertStringToDate(CorpoMediaUtil.convertDateToString(new Date())));
		} else {
			esiInfo.setCreatedOn(new Date());
		}

	}

	public static void getCmpSignatorByJson(CompanySignatorJson companySignatorJson, CompanySignator companySignator) {
		companySignator.setAddress(companySignatorJson.getAddress());
		companySignator.setCompanyId(companySignatorJson.getCompanyId());
		companySignator.setDesignation(companySignatorJson.getDesignation());
		companySignator.setDinNumber(companySignatorJson.getDinNumber());
		companySignator.setEmail(companySignatorJson.getEmail());
		companySignator.setFatherName(companySignatorJson.getFatherName());
		companySignator.setIsManagingDirector(companySignatorJson.getIsManagingDirector());
		companySignator.setIsSecretory(companySignatorJson.getIsSecretory());
		companySignator.setMobile(companySignatorJson.getMobile());
		companySignator.setPanNumber(companySignatorJson.getPanNumber());
		companySignator.setPhone(companySignatorJson.getPhone());
		companySignator.setSignatorName(companySignatorJson.getSignatorName());

	}

}
