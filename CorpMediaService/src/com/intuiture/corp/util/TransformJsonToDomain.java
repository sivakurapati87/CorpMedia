package com.intuiture.corp.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanyBanks;
import com.intuiture.corp.entity.CompanyEmployeeDefaults;
import com.intuiture.corp.entity.CompanyInfo;
import com.intuiture.corp.entity.CompanyLocation;
import com.intuiture.corp.entity.CompanyRoles;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.Department;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.EmployeeAddressInfo;
import com.intuiture.corp.entity.EmployeePersonalInfo;
import com.intuiture.corp.entity.GeneralSettings;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.entity.JobTitles;
import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.entity.Tags;
import com.intuiture.corp.entity.TimeSheetApprovers;
//github.com/sivakurapati87/CorpMedia.git
import com.intuiture.corp.json.CategoriesJson;
import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.json.CompanyEmployeeDefaultsJson;
import com.intuiture.corp.json.CompanyLocationJson;
import com.intuiture.corp.json.CompanyRolesJson;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.DepartmentJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.json.TimeSheetApproverJson;

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

	public static List<LookUpDetails> getLookup() {
		List<LookUpDetails> banksList = new ArrayList<LookUpDetails>();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(Constants.STATESJSONFILE));
			JsonArray mainArray = (JsonArray) obj;
			for (int i = 0; i < mainArray.size(); i++) {
				LookUpDetails bank = new LookUpDetails();
				JsonObject bankObj = (JsonObject) mainArray.get(i);
				bank.setLookupMasterId(9);
				bank.setDescription(bankObj.get("name").getAsString());
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
		companySignator.setIsDeleted(Boolean.FALSE);
	}

	public static void getCmpBanksByJson(CompanyBanks companyBanks, CompanyBankJson companyBankJson) {
		companyBanks.setAccountNumber(companyBankJson.getAccountNumber());
		companyBanks.setBankId(companyBankJson.getBankId());
		companyBanks.setBranch(companyBankJson.getBranch());
		companyBanks.setIfscCode(companyBankJson.getIfscCode());
		companyBanks.setCreateOn(new Date());
		companyBanks.setCompanyId(companyBankJson.getCompanyId());
		companyBanks.setIsDeleted(Boolean.FALSE);
	}

	public static void getDepartment(Department department, DepartmentJson departmentJson) {
		department.setCreatedOn(new Date());
		department.setCompanyId(departmentJson.getCompanyId());
		department.setDepartmentName(departmentJson.getDepartmentName());
	}

	public static void getCompanyLocation(CompanyLocation companyLocation, CompanyLocationJson companyLocationJson) {
		companyLocation.setAddress(companyLocationJson.getAddress());
		companyLocation.setCity(companyLocationJson.getCity());
		companyLocation.setCompanyId(companyLocationJson.getCompanyId());
		companyLocation.setCreatedOn(new Date());
		companyLocation.setLocationName(companyLocationJson.getLocationName());
		companyLocation.setStateId(companyLocationJson.getStateId());
		companyLocation.setZipcode(companyLocationJson.getZipcode());
	}

	public static void getTimeSheetGeneralSettings(GeneralSettings generalSettings, GeneralSettingsJson generalSettingsJson) {
		generalSettings.setCompanyId(generalSettingsJson.getCompanyId());
		generalSettings.setCreatedOn(new Date());
		generalSettings.setHoursPerMonth(generalSettingsJson.getHoursPerMonth());
		generalSettings.setHoursPerWeek(generalSettingsJson.getHoursPerWeek());
	}

	public static void getTags(Tags tags, TagsJson tagsJson) {
		tags.setCreatedOn(new Date());
		tags.setCompanyId(tagsJson.getCompanyId());
		tags.setTagName(tagsJson.getTagName());
	}

	public static void getCategories(Categories categories, CategoriesJson categoriesJson) {
		categories.setCreatedOn(new Date());
		categories.setCompanyId(categoriesJson.getCompanyId());
		categories.setExpenseName(categoriesJson.getExpenseName());
		categories.setDescription(categoriesJson.getDescription());
	}

	public static void getJobTitles(JobTitles jobTitles, JobTitlesJson jobTitlesJson) {
		jobTitles.setCreatedOn(new Date());
		jobTitles.setJobtitle(jobTitlesJson.getJobtitle());
		jobTitles.setCompanyId(jobTitlesJson.getCompanyId());
		jobTitles.setDescription(jobTitlesJson.getDescription());
	}

	public static void getCompanyRoles(CompanyRoles companyRoles, CompanyRolesJson companyRolesJson) {
		companyRoles.setCompanyId(companyRolesJson.getCompanyId());
		if (companyRolesJson.getRoleId() != null) {
			companyRoles.setUpdatedOn(new Date());
		} else {
			companyRoles.setCreatedOn(new Date());
		}
		companyRoles.setRoleName(companyRolesJson.getRoleName());
	}

	public static void getTimeSheetApprover(TimeSheetApprovers timeSheetApprovers, TimeSheetApproverJson timeSheetApproverJson) {
		timeSheetApprovers.setCompanyId(timeSheetApproverJson.getCompanyId());
		if (timeSheetApproverJson.getTimeSheetApproverId() != null) {
			timeSheetApprovers.setUpdatedOn(new Date());
		} else {
			timeSheetApprovers.setCreatedOn(new Date());
		}
		timeSheetApprovers.setEmployeeId(timeSheetApproverJson.getEmployeeId());
		timeSheetApprovers.setRoleId(timeSheetApproverJson.getRoleId());
	}

	public static void getEmployee(Employee employee, EmployeeJson employeeJson) {
		employee.setCompanyId(employeeJson.getCompanyId());
		if (employeeJson.getEmployeeId() != null) {
			employee.setUpdatedOn(new Date());
		} else {
			employee.setCreatedOn(new Date());
		}
		employee.setRoleId(employeeJson.getRoleId());
		employee.setDateOfJoining(employeeJson.getDateOfJoining());
		employee.setDisplayName(employeeJson.getDisplayName());
		employee.setEmail(employeeJson.getEmail());
		employee.setFirstName(employeeJson.getFirstName());
		employee.setLastName(employeeJson.getLastName());
		employee.setLocationId(employeeJson.getLocationId());
		employee.setMiddleName(employeeJson.getMiddleName());
	}

	public static void getCompanyEmployeeDefaults(CompanyEmployeeDefaults companyEmployeeDefaults, CompanyEmployeeDefaultsJson companyEmployeeDefaultsJson) {
		companyEmployeeDefaults.setCompanyId(companyEmployeeDefaultsJson.getCompanyId());
		if (companyEmployeeDefaultsJson.getCompanyEmployeeDefaultsId() != null) {
			companyEmployeeDefaults.setUpdatedOn(new Date());
		} else {
			companyEmployeeDefaults.setCreatedOn(new Date());
		}
		companyEmployeeDefaults.setIsDeleted(Boolean.FALSE);
		companyEmployeeDefaults.setIsEmpAllowedToUpdate(companyEmployeeDefaultsJson.getIsEmpAllowedToUpdate());
		companyEmployeeDefaults.setIsDeleted(companyEmployeeDefaultsJson.getIsDeleted());
		companyEmployeeDefaults.setNoticePeriod(companyEmployeeDefaultsJson.getNoticePeriod());
		companyEmployeeDefaults.setNoticePeriodId(companyEmployeeDefaultsJson.getNoticePeriodId());
		companyEmployeeDefaults.setProbationPeriod(companyEmployeeDefaultsJson.getProbationPeriod());
		companyEmployeeDefaults.setProbatioPeriodTypeId(companyEmployeeDefaultsJson.getProbatioPeriodTypeId());
		companyEmployeeDefaults.setTimeTypeId(companyEmployeeDefaultsJson.getTimeTypeId());
		companyEmployeeDefaults.setWorkerTypeId(companyEmployeeDefaultsJson.getWorkerTypeId());
	}

	public static void getEmployeePersonalInfo(EmployeePersonalInfo employeePersonalInfo, EmployeePersonalInfoJson employeePersonalInfoJson) {
		employeePersonalInfo.setCompanyId(employeePersonalInfoJson.getCompanyId());
		if (employeePersonalInfoJson.getEmployeePersonalInfoId() != null) {
			employeePersonalInfo.setUpdatedOn(new Date());
		} else {
			employeePersonalInfo.setCreatedOn(new Date());
		}
		employeePersonalInfo.setDateOfBirth(employeePersonalInfoJson.getDateOfBirth());
		employeePersonalInfo.setBloodGroupId(employeePersonalInfoJson.getBloodGroupId());
		employeePersonalInfo.setEmployeeId(employeePersonalInfoJson.getEmployeeId());
		employeePersonalInfo.setGenderId(employeePersonalInfoJson.getGenderId());
		employeePersonalInfo.setIsDeleted(Boolean.FALSE);
		employeePersonalInfo.setMaritalStatusId(employeePersonalInfoJson.getMaritalStatusId());
		employeePersonalInfo.setMobileNumber(employeePersonalInfoJson.getMobileNumber());
		employeePersonalInfo.setPersonalEmail(employeePersonalInfoJson.getPersonalEmail());
		employeePersonalInfo.setResidenceNumber(employeePersonalInfoJson.getResidenceNumber());
		employeePersonalInfo.setSkypeId(employeePersonalInfoJson.getSkypeId());
		employeePersonalInfo.setWorkNumber(employeePersonalInfoJson.getWorkNumber());
	}

	public static void getEmployeeAddressInfo(EmployeeAddressInfo employeeAddressInfo, EmployeePersonalInfoJson employeePersonalInfoJson) {
		employeeAddressInfo.setCompanyId(employeePersonalInfoJson.getCompanyId());
		if (employeePersonalInfoJson.getEmployeePersonalInfoId() != null) {
			employeeAddressInfo.setUpdatedOn(new Date());
		} else {
			employeeAddressInfo.setCreatedOn(new Date());
		}
		employeeAddressInfo.setIsDeleted(Boolean.FALSE);
		employeeAddressInfo.setIsPermSameAsCurr(employeePersonalInfoJson.getIsPermSameAsCurr());
		employeeAddressInfo.setCurrAddress(employeePersonalInfoJson.getCurrAddress());
		employeeAddressInfo.setCurrCity(employeePersonalInfoJson.getCurrCity());
		employeeAddressInfo.setCurrCountry(employeePersonalInfoJson.getCurrCountry());
		employeeAddressInfo.setCurrState(employeePersonalInfoJson.getCurrState());
		employeeAddressInfo.setEmployeeId(employeePersonalInfoJson.getEmployeeId());
		employeeAddressInfo.setPermAddress(employeePersonalInfoJson.getPermAddress());
		employeeAddressInfo.setPermCity(employeePersonalInfoJson.getPermCity());
		employeeAddressInfo.setPermCountry(employeePersonalInfoJson.getPermCountry());
		employeeAddressInfo.setPermState(employeePersonalInfoJson.getPermState());
	}
}
