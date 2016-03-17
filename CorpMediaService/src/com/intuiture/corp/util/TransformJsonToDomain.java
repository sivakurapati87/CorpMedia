package com.intuiture.corp.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.Allowances;
import com.intuiture.corp.entity.BillingRates;
import com.intuiture.corp.entity.Bonuses;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.entity.Clients;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanyBanks;
import com.intuiture.corp.entity.CompanyClientWorkHours;
import com.intuiture.corp.entity.CompanyEmployeeDefaults;
import com.intuiture.corp.entity.CompanyInfo;
import com.intuiture.corp.entity.CompanyLeavePlans;
import com.intuiture.corp.entity.CompanyLeaveType;
import com.intuiture.corp.entity.CompanyLocation;
import com.intuiture.corp.entity.CompanyRoles;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.CustomAllowance;
import com.intuiture.corp.entity.DailyAllowance;
import com.intuiture.corp.entity.Deductions;
import com.intuiture.corp.entity.Department;
import com.intuiture.corp.entity.DeptWorkHours;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.EmployeeAddressInfo;
import com.intuiture.corp.entity.EmployeeEducationalInfo;
import com.intuiture.corp.entity.EmployeeExperienceInfo;
import com.intuiture.corp.entity.EmployeeFamilyInfo;
import com.intuiture.corp.entity.EmployeeOneTimeComponent;
import com.intuiture.corp.entity.EmployeePersonalInfo;
import com.intuiture.corp.entity.EmployeeProfessionalInfo;
import com.intuiture.corp.entity.EmployeeSalaryInfo;
import com.intuiture.corp.entity.ExitSettings;
import com.intuiture.corp.entity.FoodCoupons;
import com.intuiture.corp.entity.GeneralSettings;
import com.intuiture.corp.entity.GratuityContribution;
import com.intuiture.corp.entity.Holidays;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.entity.JobTitles;
import com.intuiture.corp.entity.LeavesNotify;
import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.entity.MedicalReimbursement;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.entity.PayrollCycleSettings;
import com.intuiture.corp.entity.PayrollPeriodCalculation;
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.entity.ProjectDetails;
import com.intuiture.corp.entity.Projects;
import com.intuiture.corp.entity.Reimbursement;
import com.intuiture.corp.entity.Reports;
import com.intuiture.corp.entity.SalaryComponent;
import com.intuiture.corp.entity.Shifts;
import com.intuiture.corp.entity.Tags;
import com.intuiture.corp.entity.TaskAssignToEmployee;
import com.intuiture.corp.entity.TaskAssignToHr;
import com.intuiture.corp.entity.TaskBilling;
import com.intuiture.corp.entity.TimeSheetApprovers;
import com.intuiture.corp.entity.TransportAllowance;
import com.intuiture.corp.entity.TravelReimbursement;
import com.intuiture.corp.json.AddLeaveTypeJson;
import com.intuiture.corp.json.AllowancesJson;
import com.intuiture.corp.json.BillingRatesJson;
import com.intuiture.corp.json.BonusesJson;
//github.com/sivakurapati87/CorpMedia.git
import com.intuiture.corp.json.CategoriesJson;
import com.intuiture.corp.json.CityCompensatoryAllowanceJson;
import com.intuiture.corp.json.ClientWorkHoursJson;
import com.intuiture.corp.json.ClientsJson;
import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.json.CompanyEmployeeDefaultsJson;
import com.intuiture.corp.json.CompanyJson;
import com.intuiture.corp.json.CompanyLeavePlansJson;
import com.intuiture.corp.json.CompanyLeaveTypeJson;
import com.intuiture.corp.json.CompanyLocationJson;
import com.intuiture.corp.json.CompanyRolesJson;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.CustomAllowanceJson;
import com.intuiture.corp.json.DailyAllowanceJson;
import com.intuiture.corp.json.DeductionsJson;
import com.intuiture.corp.json.DepartmentJson;
import com.intuiture.corp.json.DeptWorkHoursJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.EmployeeEducationalInfoJson;
import com.intuiture.corp.json.EmployeeExperienceInfoJson;
import com.intuiture.corp.json.EmployeeFamilyInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeeOneTimeComponentJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
import com.intuiture.corp.json.EmployeeSalaryInfoJson;
import com.intuiture.corp.json.ExitSettingsJson;
import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.json.GratuityContributionJson;
import com.intuiture.corp.json.HolidaysJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.json.LeavesNotifyJson;
import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.json.PayrollPeriodCalculationJson;
import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.json.ProjectDetailsJson;
import com.intuiture.corp.json.ProjectsJson;
import com.intuiture.corp.json.ReimbursementJson;
import com.intuiture.corp.json.ReportsJson;
import com.intuiture.corp.json.SalaryComponentJson;
import com.intuiture.corp.json.ShiftsJson;
import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.json.TaskAssignToEmployeeJson;
import com.intuiture.corp.json.TaskAssignToHrJson;
import com.intuiture.corp.json.TaskBillingJson;
import com.intuiture.corp.json.TimeSheetApproverJson;
import com.intuiture.corp.json.TransportAllowanceJson;
import com.intuiture.corp.json.TravelReimbursementJson;

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
		companyLocation.setIsDeleted(Boolean.FALSE);
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

	public static void getDeductions(Deductions deductions, DeductionsJson deductionsJson) {
		deductions.setCreatedOn(new Date());
		deductions.setCompanyId(deductionsJson.getCompanyId());
		deductions.setDeductionName(deductionsJson.getDeductionName());
		deductions.setDeductionDescription(deductionsJson.getDeductionDescription());
	}

	public static void getReimbursement(Reimbursement reimbursement, ReimbursementJson reimbursementJson) {
		reimbursement.setCreatedOn(new Date());
		reimbursement.setCompanyId(reimbursementJson.getCompanyId());
		reimbursement.setReimbursementName(reimbursementJson.getReimbursementName());
		reimbursement.setReimbursementDescription(reimbursementJson.getReimbursementDescription());
		reimbursement.setIsDeleted(Boolean.FALSE);
	}

	public static void getBonuses(Bonuses bonuses, BonusesJson bonusesJson) {
		bonuses.setCreatedOn(new Date());
		bonuses.setCompanyId(bonusesJson.getCompanyId());
		bonuses.setBonusesName(bonusesJson.getBonusesName());
		bonuses.setBonusesDescription(bonusesJson.getBonusesDescription());
		bonuses.setIsDeleted(Boolean.FALSE);
	}

	public static void getAllowances(Allowances allowances, AllowancesJson allowancesJson) {
		allowances.setCreatedOn(new Date());
		allowances.setCompanyId(allowancesJson.getCompanyId());
		allowances.setAllowancesName(allowancesJson.getAllowancesName());
		allowances.setAllowancesDescription(allowancesJson.getAllowancesDescription());
		allowances.setHasTaxBenefits(allowancesJson.getHasTaxBenefits());
		allowances.setIsDeleted(Boolean.FALSE);
	}

	public static void getMedicalReimbursement(MedicalReimbursement medicalReimbursement, MedicalReimbursementJson medicalReimbursementJson) {
		medicalReimbursement.setCreatedOn(new Date());
		medicalReimbursement.setCompanyId(medicalReimbursementJson.getCompanyId());
		medicalReimbursement.setMaxAnnualLimit(medicalReimbursementJson.getMaxAnnualLimit());
		medicalReimbursement.setRequireSubmissionId(medicalReimbursementJson.getRequireSubmissionId());
		medicalReimbursement.setIsDeleted(Boolean.FALSE);
	}

	public static void getTransportAllowance(TransportAllowance transportAllowance, TransportAllowanceJson transportAllowanceJson) {
		transportAllowance.setCreatedOn(new Date());
		transportAllowance.setCompanyId(transportAllowanceJson.getCompanyId());
		transportAllowance.setMaxAnnualLimit(transportAllowanceJson.getMaxAnnualLimit());
		transportAllowance.setRequireSubmissionId(transportAllowanceJson.getRequireSubmissionId());
		transportAllowance.setIsDeleted(Boolean.FALSE);
	}

	public static void getProfessionalAllowance(ProfessionalAllowance professionalAllowance, ProfessionalAllowanceJson professionalAllowanceJson) {
		professionalAllowance.setCreatedOn(new Date());
		professionalAllowance.setCompanyId(professionalAllowanceJson.getCompanyId());
		professionalAllowance.setMaxAnnualLimit(professionalAllowanceJson.getMaxAnnualLimit());
		professionalAllowance.setRequireSubmissionId(professionalAllowanceJson.getRequireSubmissionId());
		professionalAllowance.setIsDeleted(Boolean.FALSE);
	}

	public static void getTravelReimbursement(TravelReimbursement travelReimbursement, TravelReimbursementJson travelReimbursementJson) {
		travelReimbursement.setCreatedOn(new Date());
		travelReimbursement.setCompanyId(travelReimbursementJson.getCompanyId());
		travelReimbursement.setMaxAnnualLimit(travelReimbursementJson.getMaxAnnualLimit());
		travelReimbursement.setRequireSubmissionId(travelReimbursementJson.getRequireSubmissionId());
		travelReimbursement.setIsDeleted(Boolean.FALSE);
	}

	public static void getCityCompensatoryAllowance(CityCompensatoryAllowance cityCompensatoryAllowance, CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson) {
		cityCompensatoryAllowance.setCreatedOn(new Date());
		cityCompensatoryAllowance.setCompanyId(cityCompensatoryAllowanceJson.getCompanyId());
		cityCompensatoryAllowance.setMaxAnnualLimit(cityCompensatoryAllowanceJson.getMaxAnnualLimit());
		cityCompensatoryAllowance.setRequireSubmissionId(cityCompensatoryAllowanceJson.getRequireSubmissionId());
		cityCompensatoryAllowance.setIsDeleted(Boolean.FALSE);
	}

	public static void getDailyAllowance(DailyAllowance dailyAllowance, DailyAllowanceJson dailyAllowanceJson) {
		dailyAllowance.setCreatedOn(new Date());
		dailyAllowance.setCompanyId(dailyAllowanceJson.getCompanyId());
		dailyAllowance.setMaxAnnualLimit(dailyAllowanceJson.getMaxAnnualLimit());
		dailyAllowance.setRequireSubmissionId(dailyAllowanceJson.getRequireSubmissionId());
		dailyAllowance.setIsDeleted(Boolean.FALSE);
	}

	public static void getFoodCoupons(FoodCoupons foodCoupons, FoodCouponsJson foodCouponsJson) {
		foodCoupons.setCreatedOn(new Date());
		foodCoupons.setCompanyId(foodCouponsJson.getCompanyId());
		foodCoupons.setMaxAnnualLimit(foodCouponsJson.getMaxAnnualLimit());
		foodCoupons.setRequireSubmissionId(foodCouponsJson.getRequireSubmissionId());
		foodCoupons.setIsDeleted(Boolean.FALSE);
	}

	public static void getGratuityContribution(GratuityContribution gratuityContribution, GratuityContributionJson gratuityContributionJson) {
		gratuityContribution.setCreatedOn(new Date());
		gratuityContribution.setCompanyId(gratuityContributionJson.getCompanyId());
		gratuityContribution.setMaxAnnualLimit(gratuityContributionJson.getMaxAnnualLimit());
		gratuityContribution.setIsDeleted(Boolean.FALSE);
	}

	public static void getCustomAllowance(CustomAllowance customAllowance, CustomAllowanceJson customAllowanceJson) {
		customAllowance.setCreatedOn(new Date());
		customAllowance.setCompanyId(customAllowanceJson.getCompanyId());
		customAllowance.setName(customAllowanceJson.getName());
		customAllowance.setMaxAnnualLimit(customAllowanceJson.getMaxAnnualLimit());
		customAllowance.setSubmitBillId(customAllowanceJson.getSubmitBillId());
		customAllowance.setTaxBenefitId(customAllowanceJson.getTaxBenefitId());
		customAllowance.setIsDeleted(Boolean.FALSE);
	}

	public static void getPayrollCycleSettings(PayrollCycleSettings payrollCycleSettings, PayrollCycleSettingsJson payrollCycleSettingsJson) {
		if (payrollCycleSettings.getPayrollCycleSettingsId() != null) {
			payrollCycleSettings.setUpdatedOn(new Date());
		} else {
			payrollCycleSettings.setCreatedOn(new Date());
		}
		payrollCycleSettings.setCompanyId(payrollCycleSettingsJson.getCompanyId());
		payrollCycleSettings.setPayFrequency(payrollCycleSettingsJson.getPayFrequency());
		payrollCycleSettings.setPayCycleMonthId(payrollCycleSettingsJson.getPayCycleMonthId());
		payrollCycleSettings.setPayPeriodEndDayId(MethodUtil.convertStringToInteger(payrollCycleSettingsJson.getStrPayPeriodEndDayId()));
		payrollCycleSettings.setPayDay(payrollCycleSettingsJson.getPayDay());
		payrollCycleSettings.setIsDeleted(Boolean.FALSE);
	}

	public static void getPayrollPeriodCalculation(PayrollPeriodCalculation payrollPeriodCalculation, PayrollPeriodCalculationJson payrollPeriodCalculationJson) {
		payrollPeriodCalculation.setCreatedOn(new Date());
		payrollPeriodCalculation.setCompanyId(payrollPeriodCalculationJson.getCompanyId());
		payrollPeriodCalculation.setPayDaysInAMonthId(payrollPeriodCalculationJson.getPayDaysInAMonthId());
		payrollPeriodCalculation.setExcludeWeeklyOffsId(payrollPeriodCalculationJson.getExcludeWeeklyOffsId());
		payrollPeriodCalculation.setExcludeHolidaysId(payrollPeriodCalculationJson.getExcludeHolidaysId());
		payrollPeriodCalculation.setIsDeleted(Boolean.FALSE);
	}

	public static void getClients(Clients clients, ClientsJson clientsJson) {
		clients.setCreatedOn(new Date());
		clients.setCompanyId(clientsJson.getCompanyId());
		clients.setClientName(clientsJson.getClientName());
		clients.setManagerName(clientsJson.getManagerName());
		clients.setNotes(clientsJson.getNotes());
		clients.setIsDeleted(Boolean.FALSE);
	}

	public static void getBillingRates(BillingRates billingRates, BillingRatesJson billingRatesJson) {
		billingRates.setCreatedOn(new Date());
		billingRates.setCompanyId(billingRatesJson.getCompanyId());
		billingRates.setBillingCurrencyId(billingRatesJson.getBillingCurrencyId());
		billingRates.setBillingRole(billingRatesJson.getBillingRole());
		billingRates.setHourlyRate(billingRatesJson.getHourlyRate());
		billingRates.setWeeklyRate(billingRatesJson.getWeeklyRate());
		billingRates.setMonthlyRate(billingRatesJson.getMonthlyRate());
		billingRates.setIsDeleted(Boolean.FALSE);
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

	public static void getEmployeeFamilyInfo(EmployeeFamilyInfo employeeFamilyInfo, EmployeeFamilyInfoJson employeeFamilyInfoJson) {
		employeeFamilyInfo.setCompanyId(employeeFamilyInfoJson.getCompanyId());
		if (employeeFamilyInfoJson.getEmployeeFamilyInfoId() != null) {
			employeeFamilyInfo.setUpdatedOn(new Date());
		} else {
			employeeFamilyInfo.setCreatedOn(new Date());
		}
		employeeFamilyInfo.setIsDeleted(Boolean.FALSE);
		employeeFamilyInfo.setEmployeeId(employeeFamilyInfoJson.getEmployeeId());
		employeeFamilyInfo.setEmail(employeeFamilyInfoJson.getEmail());
		employeeFamilyInfo.setFirstName(employeeFamilyInfoJson.getFirstName());
		employeeFamilyInfo.setLastName(employeeFamilyInfoJson.getLastName());
		employeeFamilyInfo.setMobileNumber(employeeFamilyInfoJson.getMobileNumber());
		employeeFamilyInfo.setRelationId(employeeFamilyInfoJson.getRelationId());
	}

	public static void getEmployeeProfessionalInfo(EmployeeProfessionalInfo employeeProfessionalInfo, EmployeeProfessionalInfoJson employeeProfessionalInfoJson) {
		employeeProfessionalInfo.setCompanyId(employeeProfessionalInfoJson.getCompanyId());
		if (employeeProfessionalInfoJson.getEmployeeProfessionalInfoId() != null) {
			employeeProfessionalInfo.setUpdatedOn(new Date());
		} else {
			employeeProfessionalInfo.setCreatedOn(new Date());
		}
		employeeProfessionalInfo.setIsDeleted(Boolean.FALSE);
		employeeProfessionalInfo.setEmployeeId(employeeProfessionalInfoJson.getEmployeeId());
		employeeProfessionalInfo.setProfessionalSummery(employeeProfessionalInfoJson.getProfessionalSummery());
		employeeProfessionalInfo.setStatusMessage(employeeProfessionalInfoJson.getStatusMessage());
	}

	public static void getEmployeeExperienceInfo(EmployeeExperienceInfo employeeExperienceInfo, EmployeeExperienceInfoJson employeeExperienceInfoJson) {
		employeeExperienceInfo.setCompanyId(employeeExperienceInfoJson.getCompanyId());
		if (employeeExperienceInfoJson.getEmployeeExperienceInfoId() != null) {
			employeeExperienceInfo.setUpdatedOn(new Date());
		} else {
			employeeExperienceInfo.setCreatedOn(new Date());
		}
		employeeExperienceInfo.setIsDeleted(Boolean.FALSE);
		employeeExperienceInfo.setEmployeeId(employeeExperienceInfoJson.getEmployeeId());
		employeeExperienceInfo.setCompanyName(employeeExperienceInfoJson.getCompanyName());
		employeeExperienceInfo.setJobTitle(employeeExperienceInfoJson.getJobTitle());
		employeeExperienceInfo.setLocation(employeeExperienceInfoJson.getLocation());
		employeeExperienceInfo.setFromDate(employeeExperienceInfoJson.getFromDate());
		employeeExperienceInfo.setToDate(employeeExperienceInfoJson.getToDate());
		employeeExperienceInfo.setDescription(employeeExperienceInfoJson.getDescription());
	}

	public static void getEmployeeEducationalInfo(EmployeeEducationalInfo employeeEducationalInfo, EmployeeEducationalInfoJson employeeEducationalInfoJson) {
		employeeEducationalInfo.setCompanyId(employeeEducationalInfoJson.getCompanyId());
		if (employeeEducationalInfoJson.getEmployeeEducationalInfoId() != null) {
			employeeEducationalInfo.setUpdatedOn(new Date());
		} else {
			employeeEducationalInfo.setCreatedOn(new Date());
		}
		employeeEducationalInfo.setIsDeleted(Boolean.FALSE);
		employeeEducationalInfo.setEmployeeId(employeeEducationalInfoJson.getEmployeeId());
		employeeEducationalInfo.setFromDate(employeeEducationalInfoJson.getFromDate());
		employeeEducationalInfo.setToDate(employeeEducationalInfoJson.getToDate());
		employeeEducationalInfo.setDegree(employeeEducationalInfoJson.getDegree());
		employeeEducationalInfo.setSpecialization(employeeEducationalInfoJson.getSpecialization());
		employeeEducationalInfo.setUniversity(employeeEducationalInfoJson.getUniversity());
	}

	public static void getCompanyLeavePlans(CompanyLeavePlans companyLeavePlans, CompanyLeavePlansJson companyLeavePlansJson) {
		companyLeavePlans.setCompanyId(companyLeavePlansJson.getCompanyId());
		if (companyLeavePlansJson.getCompanyLeavePlansId() != null) {
			companyLeavePlans.setUpdatedOn(new Date());
		} else {
			companyLeavePlans.setCreatedOn(new Date());
		}
		companyLeavePlans.setIsDeleted(Boolean.FALSE);
		companyLeavePlans.setDescription(companyLeavePlansJson.getDescription());
		companyLeavePlans.setLeavePlanName(companyLeavePlansJson.getLeavePlanName());
	}

	public static void getReports(Reports reports, ReportsJson reportsJson) {
		reports.setCompanyId(reportsJson.getCompanyId());
		if (reports.getReportsId() != null) {
			reports.setUpdatedOn(new Date());
		} else {
			reports.setCreatedOn(new Date());
		}
		reports.setIsDeleted(Boolean.FALSE);
		reports.setFromDate(reportsJson.getFromDate());
		reports.setToDate(reportsJson.getToDate());
	}

	public static void getProjectDetails(ProjectDetails projectDetails, ProjectDetailsJson projectDetailsJson) {
		projectDetails.setCompanyId(projectDetailsJson.getCompanyId());
		if (projectDetails.getProjectDetailsId() != null) {
			projectDetails.setUpdatedOn(new Date());
		} else {
			projectDetails.setCreatedOn(new Date());
		}
		projectDetails.setIsDeleted(Boolean.FALSE);
		projectDetails.setFromDate(projectDetailsJson.getFromDate());
		projectDetails.setToDate(projectDetailsJson.getToDate());
	}

	public static void getTaskBilling(TaskBilling taskBilling, TaskBillingJson taskBillingJson) {
		taskBilling.setCompanyId(taskBillingJson.getCompanyId());
		if (taskBilling.getTaskBillingId() != null) {
			taskBilling.setUpdatedOn(new Date());
		} else {
			taskBilling.setCreatedOn(new Date());
		}
		taskBilling.setIsDeleted(Boolean.FALSE);
		taskBilling.setFromDate(taskBillingJson.getFromDate());
		taskBilling.setToDate(taskBillingJson.getToDate());
	}

	public static void getShifts(Shifts shifts, ShiftsJson shiftsJson) {
		shifts.setCompanyId(shiftsJson.getCompanyId());
		if (shiftsJson.getShiftsId() != null) {
			shifts.setUpdatedOn(new Date());
		} else {
			shifts.setCreatedOn(new Date());
		}
		shifts.setIsDeleted(Boolean.FALSE);
		shifts.setBreakDuratation(shiftsJson.getBreakDuratation());
		shifts.setShiftName(shiftsJson.getShiftName());
		shifts.setStartTimeHrs(shiftsJson.getStartTimeHrs());
		shifts.setStartTimeMns(shiftsJson.getStartTimeMns());
		shifts.setStartTimeType(shiftsJson.getStartTimeType());
		shifts.setToTimeHrs(shiftsJson.getToTimeHrs());
		shifts.setToTimeMns(shiftsJson.getToTimeMns());
		shifts.setToTimeType(shiftsJson.getToTimeType());
	}

	public static void getTaskAssignToHr(TaskAssignToHr taskAssignToHr, TaskAssignToHrJson taskAssignToHrJson) {
		taskAssignToHr.setCreatedOn(new Date());
		taskAssignToHr.setCompanyId(taskAssignToHrJson.getCompanyId());
		taskAssignToHr.setTaskName(taskAssignToHrJson.getTaskName());
		taskAssignToHr.setIsDeleted(Boolean.FALSE);
	}

	public static void getTaskAssignToEmployee(TaskAssignToEmployee taskAssignToEmployee, TaskAssignToEmployeeJson taskAssignToEmployeeJson) {
		taskAssignToEmployee.setCreatedOn(new Date());
		taskAssignToEmployee.setCompanyId(taskAssignToEmployeeJson.getCompanyId());
		taskAssignToEmployee.setTaskName(taskAssignToEmployeeJson.getTaskName());
		taskAssignToEmployee.setIsDeleted(Boolean.FALSE);
	}

	public static void getProjects(Projects projects, ProjectsJson projectsJson) {
		projects.setCompanyId(projectsJson.getCompanyId());
		projects.setCreatedOn(new Date());
		projects.setIsDeleted(Boolean.FALSE);
		projects.setProjectName(projectsJson.getProjectName());
		// projects.setClient(projectsJson.getClient());
		projects.setClientsId(projectsJson.getClientsId());
		projects.setStartDate(projectsJson.getStartDate());
		projects.setEndDate(projectsJson.getEndDate());
		projects.setDescription(projectsJson.getDescription());
		projects.setIsProjectAssignToAllEmployees(projectsJson.getIsProjectAssignToAllEmployees());
		projects.setStatusId(projectsJson.getStatusId());
	}

	public static void getExitSettings(ExitSettings exitSettings, ExitSettingsJson exitSettingsJson) {
		exitSettings.setCreatedOn(new Date());
		exitSettings.setCompanyId(exitSettingsJson.getCompanyId());
		exitSettings.setIsDeleted(Boolean.FALSE);
		exitSettings.setReason(exitSettingsJson.getReason());
		exitSettings.setReasonTypeId(exitSettingsJson.getReasonTypeId());
	}

	public static void getAddLeaveType(AddLeaveType addLeaveType, AddLeaveTypeJson addLeaveTypeJson) {
		addLeaveType.setCompanyId(addLeaveTypeJson.getCompanyId());
		if (addLeaveTypeJson.getAddLeaveTypeId() != null) {
			addLeaveType.setUpdatedOn(new Date());
		} else {
			addLeaveType.setCreatedOn(new Date());
		}
		addLeaveType.setIsDeleted(Boolean.FALSE);
		addLeaveType.setAccrualStartFromTypeId(addLeaveTypeJson.getAccrualStartFromTypeId());
		addLeaveType.setAccruedLeaveLapseAfter(addLeaveTypeJson.getAccruedLeaveLapseAfter());
		addLeaveType.setAccruedLeaveLapseTypeId(addLeaveTypeJson.getAccruedLeaveLapseTypeId());
		addLeaveType.setAccruedRateId(addLeaveTypeJson.getAccruedRateId());
		addLeaveType.setAccruedRateOn(addLeaveTypeJson.getAccruedRateOn());
		addLeaveType.setAnnualQuota(addLeaveTypeJson.getAnnualQuota());
		addLeaveType.setAnnualQuotaTypeId(addLeaveTypeJson.getAnnualQuotaTypeId());
		addLeaveType.setCarryForwardMaxValue(addLeaveTypeJson.getCarryForwardMaxValue());
		addLeaveType.setCompanyLeavePlanId(addLeaveTypeJson.getCompanyLeavePlanId());
		addLeaveType.setConsecutiveBtPaidLeavesHoliday(addLeaveTypeJson.getConsecutiveBtPaidLeavesHoliday());
		addLeaveType.setConsecutiveBtPaidLeavesWeekOff(addLeaveTypeJson.getConsecutiveBtPaidLeavesWeekOff());
		addLeaveType.setEndOfLeaveCalenderTypeId(addLeaveTypeJson.getEndOfLeaveCalenderTypeId());
		addLeaveType.setFrequencyOfLeaves(addLeaveTypeJson.getFrequencyOfLeaves());
		addLeaveType.setIsAllowUtilizationOfLeaves(addLeaveTypeJson.getIsAllowUtilizationOfLeaves());
		addLeaveType.setIsProrate(addLeaveTypeJson.getIsProrate());
		addLeaveType.setLeaveAvailabilityTypeId(addLeaveTypeJson.getLeaveAvailabilityTypeId());
		addLeaveType.setLeavesAvailedFrom(addLeaveTypeJson.getLeavesAvailedFrom());
		addLeaveType.setLeavesAvailedFromTypeId(addLeaveTypeJson.getLeavesAvailedFromTypeId());
		addLeaveType.setLeaveTypeId(addLeaveTypeJson.getLeaveTypeId());
		addLeaveType.setPayMaximumValue(addLeaveTypeJson.getPayMaximumValue());
		addLeaveType.setProrateFrom(addLeaveTypeJson.getProrateFrom());
	}

	public static void getCompanyLeaveType(CompanyLeaveType companyLeaveType, CompanyLeaveTypeJson companyLeaveTypeJson) {
		companyLeaveType.setCompanyId(companyLeaveTypeJson.getCompanyId());
		if (companyLeaveTypeJson.getCompanyLeaveTypeId() != null) {
			companyLeaveType.setUpdatedOn(new Date());
		} else {
			companyLeaveType.setCreatedOn(new Date());
		}
		companyLeaveType.setIsDeleted(Boolean.FALSE);
		companyLeaveType.setDocumentNeeded_After(companyLeaveTypeJson.getDocumentNeeded_After());
		companyLeaveType.setIsCommentRequired(companyLeaveTypeJson.getIsCommentRequired());
		companyLeaveType.setIsDocumentProofRequired(companyLeaveTypeJson.getIsDocumentProofRequired());
		companyLeaveType.setIsHalfDayLeaveAllowed(companyLeaveTypeJson.getIsHalfDayLeaveAllowed());
		companyLeaveType.setIsPaidLeave(companyLeaveTypeJson.getIsPaidLeave());
		companyLeaveType.setIsPriorNoticeRequired(companyLeaveTypeJson.getIsPriorNoticeRequired());
		companyLeaveType.setIsRestricted(companyLeaveTypeJson.getIsRestricted());
		companyLeaveType.setIsSickLeave(companyLeaveTypeJson.getIsSickLeave());
		companyLeaveType.setIsStatutoryLeave(companyLeaveTypeJson.getIsStatutoryLeave());
		companyLeaveType.setLeaveTypeDescription(companyLeaveTypeJson.getLeaveTypeDescription());
		companyLeaveType.setLeaveTypeName(companyLeaveTypeJson.getLeaveTypeName());
		companyLeaveType.setPriorNoticeRequered_After(companyLeaveTypeJson.getPriorNoticeRequered_After());
		companyLeaveType.setRestrictToId(companyLeaveTypeJson.getRestrictToId());
	}

	public static void getHolidays(Holidays holidays, HolidaysJson holidaysJson) {
		holidays.setCompanyId(holidaysJson.getCompanyId());
		if (holidaysJson.getHolidaysId() != null) {
			holidays.setUpdatedOn(new Date());
		} else {
			holidays.setCreatedOn(new Date());
		}
		holidays.setIsDeleted(Boolean.FALSE);
		holidays.setDescription(holidaysJson.getDescription());
		holidays.setHolidayDate(holidaysJson.getHolidayDate());
		holidays.setHolidayName(holidaysJson.getHolidayName());
		holidays.setIsFloatingHoliday(holidaysJson.getIsFloatingHoliday());
	}

	public static void getLeavesNotify(LeavesNotify leavesNotify, LeavesNotifyJson leavesNotifyJson) {
		leavesNotify.setCompanyId(leavesNotifyJson.getCompanyId());
		if (leavesNotifyJson.getLeavesNotifyId() != null) {
			leavesNotify.setUpdatedOn(new Date());
		} else {
			leavesNotify.setCreatedOn(new Date());
		}
		leavesNotify.setIsDeleted(Boolean.FALSE);
		leavesNotify.setNotifyEmpId(leavesNotifyJson.getNotifyEmpId());
	}

	public static void getClientWorkHours(CompanyClientWorkHours clientWorkHours, ClientWorkHoursJson clientWorkHoursJson) {
		if (clientWorkHoursJson.getClientWorkHourId() == null) {
			clientWorkHours.setCreateOn(new Date());
		} else {
			clientWorkHours.setUpdatedOn(new Date());
		}
		clientWorkHours.setCompanyId(clientWorkHoursJson.getCompanyId());
		clientWorkHours.setClientId(clientWorkHoursJson.getClientsId());
		clientWorkHours.setClientFrom(clientWorkHoursJson.getFrom());
		clientWorkHours.setClientTo(clientWorkHoursJson.getFrom());
		clientWorkHours.setIsDeleted(Boolean.FALSE);
	}

	public static void getDeptWorkHours(DeptWorkHours deptWorkHours, DeptWorkHoursJson deptWorkHoursJson) {
		if (deptWorkHoursJson.getDeptWorkHourId() == null) {
			deptWorkHours.setCreateOn(new Date());
		} else {
			deptWorkHours.setUpdatedOn(new Date());
		}
		deptWorkHours.setCompanyId(deptWorkHoursJson.getCompanyId());
		deptWorkHours.setDepartmentId(deptWorkHoursJson.getDepartmentId());
		deptWorkHours.setGroupById(deptWorkHoursJson.getGroupById());
		deptWorkHours.setDeptFrom(deptWorkHoursJson.getFrom());
		deptWorkHours.setDeptTo(deptWorkHoursJson.getFrom());
		deptWorkHours.setIncludeNonbillableHours(deptWorkHoursJson.getIncludeNonbillableHours());

		deptWorkHours.setIsDeleted(Boolean.FALSE);
	}

	public static void getSalaryComponent(SalaryComponent salaryComponent, SalaryComponentJson salaryComponentJson) {
		if (salaryComponentJson.getSalaryComponentId() == null) {
			salaryComponent.setCreatedOn(new Date());
		} else {
			salaryComponent.setUpdatedOn(new Date());
		}
		salaryComponent.setCompanyId(salaryComponentJson.getCompanyId());
		salaryComponent.setIsDeleted(Boolean.FALSE);
		salaryComponent.setBasic(salaryComponentJson.getBasic());
		salaryComponent.setHra(salaryComponentJson.getHra());

		salaryComponent.getCityCompensatoryAllowance().setMaxAnnualLimit(salaryComponentJson.getCityCompensatoryAllowance());
		salaryComponent.getDailyAllowance().setMaxAnnualLimit(salaryComponentJson.getDailyAllowance());
		salaryComponent.getFoodCoupons().setMaxAnnualLimit(salaryComponentJson.getFoodCoupons());
		salaryComponent.getGratuityContribution().setMaxAnnualLimit(salaryComponentJson.getGratuityContribution());
		salaryComponent.getMedicalReimbursement().setMaxAnnualLimit(salaryComponentJson.getMedicalReimbursement());
		salaryComponent.getProfessionalAllowance().setMaxAnnualLimit(salaryComponentJson.getProfessionalAllowance());
		salaryComponent.getTransportAllowance().setMaxAnnualLimit(salaryComponentJson.getTransportAllowance());
		salaryComponent.getTravelReimbursement().setMaxAnnualLimit(salaryComponentJson.getTravelReimbursement());
	}

	public static void getEmployeeSalaryInfo(EmployeeSalaryInfo employeeSalaryInfo, EmployeeSalaryInfoJson employeeSalaryInfoJson) {
		if (employeeSalaryInfoJson.getEmployeeSalaryInfoId() == null) {
			employeeSalaryInfo.setCreatedOn(new Date());
		} else {
			employeeSalaryInfo.setUpdatedOn(new Date());
		}
		employeeSalaryInfo.setCompanyId(employeeSalaryInfoJson.getCompanyId());
		employeeSalaryInfo.setIsDeleted(Boolean.FALSE);
		employeeSalaryInfo.setEmployeeId(employeeSalaryInfoJson.getEmployeeId());
		employeeSalaryInfo.setAnnualSalary(employeeSalaryInfoJson.getAnnualSalary());
		employeeSalaryInfo.setEffectiveFrom(employeeSalaryInfoJson.getEffectiveFrom());
	}

	public static void getEmployeeOneTimeComponent(EmployeeOneTimeComponent employeeOneTimeComponent, EmployeeOneTimeComponentJson employeeOneTimeComponentJson) {
		if (employeeOneTimeComponentJson.getEmployeeOneTimeComponentId() == null) {
			employeeOneTimeComponent.setCreatedOn(new Date());
		} else {
			employeeOneTimeComponent.setUpdatedOn(new Date());
		}
		employeeOneTimeComponent.setCompanyId(employeeOneTimeComponentJson.getCompanyId());
		employeeOneTimeComponent.setIsDeleted(Boolean.FALSE);
		employeeOneTimeComponent.setEmployeeId(employeeOneTimeComponentJson.getEmployeeId());
		employeeOneTimeComponent.setAmount(employeeOneTimeComponentJson.getAmount());
		employeeOneTimeComponent.setMonthPayable(employeeOneTimeComponentJson.getMonthPayable());
		employeeOneTimeComponent.setNote(employeeOneTimeComponentJson.getNote());
		employeeOneTimeComponent.setOneTimeComponentName(employeeOneTimeComponentJson.getOneTimeComponentName());
		employeeOneTimeComponent.setStatusId(employeeOneTimeComponentJson.getStatusId());
	}

	public static void getCompanyInfo(Company company, CompanyJson companyJson) {
		if (company.getCompanyInfo() != null) {
			company.getCompanyInfo().setShortName(companyJson.getShortName());
			company.getCompanyInfo().setLogoImageName(companyJson.getLogoImageName());
		}
	}
}
