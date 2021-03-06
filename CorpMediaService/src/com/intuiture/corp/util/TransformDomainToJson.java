package com.intuiture.corp.util;

import org.apache.log4j.Logger;

import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.Allowances;
import com.intuiture.corp.entity.Bonuses;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.entity.Clients;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanyBanks;
import com.intuiture.corp.entity.CompanyClientWorkHours;
import com.intuiture.corp.entity.CompanyEmployeeDefaults;
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
import com.intuiture.corp.entity.Designation;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.EmployeeAddressInfo;
import com.intuiture.corp.entity.EmployeeEducationalInfo;
import com.intuiture.corp.entity.EmployeeExperienceInfo;
import com.intuiture.corp.entity.EmployeeFamilyInfo;
import com.intuiture.corp.entity.EmployeeOneTimeComponent;
import com.intuiture.corp.entity.EmployeePersonalInfo;
import com.intuiture.corp.entity.EmployeeProfessionalInfo;
import com.intuiture.corp.entity.EmployeeProject;
import com.intuiture.corp.entity.EmployeeSalaryInfo;
import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Employee_TimeSheet;
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
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.entity.Project;
import com.intuiture.corp.entity.Reimbursement;
import com.intuiture.corp.entity.SalaryComponent;
import com.intuiture.corp.entity.Shifts;
import com.intuiture.corp.entity.Tags;
import com.intuiture.corp.entity.TaskAssignToEmployee;
import com.intuiture.corp.entity.TaskAssignToHr;
import com.intuiture.corp.entity.TimeSheetApprovers;
import com.intuiture.corp.entity.TransportAllowance;
import com.intuiture.corp.entity.TravelReimbursement;
import com.intuiture.corp.json.AddLeaveTypeJson;
import com.intuiture.corp.json.AllowancesJson;
import com.intuiture.corp.json.BonusesJson;
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
import com.intuiture.corp.json.DesignationJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.EmployeeEducationalInfoJson;
import com.intuiture.corp.json.EmployeeExperienceInfoJson;
import com.intuiture.corp.json.EmployeeFamilyInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeeLeaveJson;
import com.intuiture.corp.json.EmployeeOneTimeComponentJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
import com.intuiture.corp.json.EmployeeProjectJson;
import com.intuiture.corp.json.EmployeeSalaryInfoJson;
import com.intuiture.corp.json.EmployeeTimeSheetJson;
import com.intuiture.corp.json.ExitSettingsJson;
import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.json.GratuityContributionJson;
import com.intuiture.corp.json.HolidaysJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.json.LeavesNotifyJson;
import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.json.ProjectJson;
import com.intuiture.corp.json.ReimbursementJson;
import com.intuiture.corp.json.SalaryComponentJson;
import com.intuiture.corp.json.ShiftsJson;
import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.json.TaskAssignToEmployeeJson;
import com.intuiture.corp.json.TaskAssignToHrJson;
import com.intuiture.corp.json.TimeSheetApproverJson;
import com.intuiture.corp.json.TransportAllowanceJson;
import com.intuiture.corp.json.TravelReimbursementJson;

public class TransformDomainToJson {
	private static Logger LOG = Logger.getLogger(TransformDomainToJson.class);

	public static LookUpDetailJson getLookUpDetailJson(LookUpDetails lookUpDetails) {
		LookUpDetailJson json = new LookUpDetailJson();
		if (lookUpDetails != null) {
			json.setDescription(lookUpDetails.getDescription());
			json.setLookupDetailId(lookUpDetails.getLookupDetailId());
			json.setParent(lookUpDetails.getParent());
			json.setLookupMasterId(lookUpDetails.getLookupMasterId());
			json.setIndexOfTheMonth(lookUpDetails.getIndexOfTheMonth());
			json.setDaysOfTheMonth(lookUpDetails.getDaysOfTheMonth());
		}
		return json;
	}

	// public static BankJson getBankJson(Banks banks) {
	// BankJson json = new BankJson();
	// json.setBankId(banks.getBankId());
	// json.setBankName(banks.getBankName());
	// return json;
	// }

	public static CompanyJson getAllCompanyJsonByCompany(Company company) {
		CompanyJson companyJson = new CompanyJson();
		try {
			companyJson.setCin(company.getCin());
			companyJson.setCompanyId(company.getCompanyId());
			companyJson.setCompanyName(company.getCompanyName());
			// companyJson.setCreatedOn(company.getCreatedOn());
			companyJson.setCst(company.getCst());
			companyJson.setTin(company.getTin());
			// companyJson.setUpdatedOn(company.getUpdatedOn());

			if (company.getCompanyInfo() != null) {
				companyJson.setAddress1(company.getCompanyInfo().getAddress1());
				companyJson.setAddress2(company.getCompanyInfo().getAddress2());
				companyJson.setBoardNumber(company.getCompanyInfo().getBoardNumber());
				companyJson.setArea(company.getCompanyInfo().getArea());
				companyJson.setCity(company.getCompanyInfo().getCity());
				// companyJson.setCompanyLogo(company.getCompanyInfo().getCompanyLogo());
				companyJson.setCompanyType(company.getCompanyInfo().getCompanyType());
				companyJson.setCountry(company.getCompanyInfo().getCountry());
				companyJson.setD_o_incorporation(company.getCompanyInfo().getD_o_incorporation());
				companyJson.setDateOfBalanceSheet(company.getCompanyInfo().getDateOfBalanceSheet());
				companyJson.setDateOfLastAGM(company.getCompanyInfo().getDateOfLastAGM());
				companyJson.setEmail(company.getCompanyInfo().getEmail());
				companyJson.setFacebookLink(company.getCompanyInfo().getFacebookLink());
				companyJson.setFaxNumber(company.getCompanyInfo().getFaxNumber());
				companyJson.setHoPhoto(company.getCompanyInfo().getHoPhoto());
				companyJson.setIndustry(company.getCompanyInfo().getIndustry());
				companyJson.setIsListed(company.getCompanyInfo().getIsListed());
				companyJson.setIsPSU(company.getCompanyInfo().getIsPSU());
				companyJson.setIsRegisteredWithRoc(company.getCompanyInfo().getIsRegisteredWithRoc());
				companyJson.setMobile(company.getCompanyInfo().getMobile());
				companyJson.setNaukri(company.getCompanyInfo().getNaukri());
				companyJson.setPanNumber(company.getCompanyInfo().getPanNumber());
				companyJson.setPhone(company.getCompanyInfo().getPhone());
				companyJson.setPincode(company.getCompanyInfo().getPincode());
				companyJson.setRegistrationNumber(company.getCompanyInfo().getRegistrationNumber());
				companyJson.setState(company.getCompanyInfo().getState());
				companyJson.setTwitterLink(company.getCompanyInfo().getTwitterLink());
				companyJson.setWebsite(company.getCompanyInfo().getWebsite());
				companyJson.setBase64logo(MethodUtil.getStrInputStream(company.getCompanyInfo().getLogoImageName()));
				companyJson.setShortName(company.getCompanyInfo().getShortName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAllCompanyJsonByCompany:" + e.getMessage(), e);
		}
		return companyJson;
	}

	public static CompanySignatorJson getCompanySignatorJson(CompanySignator companySignator) {
		CompanySignatorJson json = new CompanySignatorJson();
		json.setAddress(companySignator.getAddress());
		json.setDinNumber(companySignator.getDinNumber());
		json.setEmail(companySignator.getEmail());
		json.setSignatorName(companySignator.getSignatorName());
		json.setMobile(companySignator.getMobile());
		json.setDesignation(companySignator.getDesignation());
		json.setIsManagingDirector(companySignator.getIsManagingDirector());
		json.setIsSecretory(companySignator.getIsSecretory());
		json.setPhone(companySignator.getPhone());
		json.setCompanySignatorId(companySignator.getCompanySignatorId());
		json.setIsDeleted(companySignator.getIsDeleted());
		json.setFatherName(companySignator.getFatherName());
		json.setEmail(companySignator.getEmail());
		json.setPanNumber(companySignator.getPanNumber());
		return json;
	}

	public static PFInfoJson getpfInfoJson(PFInfo pfInfo) {
		PFInfoJson pfInfoJson = new PFInfoJson();
		if (pfInfo != null) {
			pfInfoJson.setIsSameForAll(pfInfo.getIsSameForAll());
			pfInfoJson.setCompanyId(pfInfo.getCompanyId());
			pfInfoJson.setCompanySignatorId(pfInfo.getCompanySignatorId());
			pfInfoJson.setCreatedOn(pfInfo.getCreatedOn());
			pfInfoJson.setPfInfoId(pfInfo.getPfInfoId());
			pfInfoJson.setPfNumber(pfInfo.getPfNumber());
			pfInfoJson.setRegistrationDate(pfInfo.getRegistrationDate());
			pfInfoJson.setUpdatedOn(pfInfo.getUpdatedOn());
			pfInfoJson.setStrRegistrationDate(MethodUtil.convertDateToString(pfInfo.getRegistrationDate()));
		}
		return pfInfoJson;
	}

	public static ITInfoJson getitInfoJson(ITInfo itInfo) {

		ITInfoJson itInfoJson = new ITInfoJson();
		if (itInfo != null) {
			itInfoJson.setCompanyId(itInfo.getCompanyId());
			itInfoJson.setCompanySignatorId(itInfo.getCompanySignatorId());
			itInfoJson.setCreatedOn(itInfo.getCreatedOn());
			itInfoJson.setUpdatedOn(itInfo.getUpdatedOn());
			itInfoJson.setItInfoId(itInfo.getItInfoId());
			itInfoJson.setPan(itInfo.getPan());
			itInfoJson.setTan(itInfo.getTan());
			itInfoJson.setTanCircleNumber(itInfo.getTanCircleNumber());
			itInfoJson.setCitLocation(itInfo.getCitLocation());

		}
		return itInfoJson;

	}

	public static ESIInfoJson getesiInfoJson(ESIInfo esiInfo) {
		ESIInfoJson esiInfoJson = new ESIInfoJson();
		if (esiInfo != null) {
			esiInfoJson.setCompanyId(esiInfo.getCompanyId());
			esiInfoJson.setCompanySignatorId(esiInfo.getCompanySignatorId());
			esiInfoJson.setCreatedOn(esiInfo.getCreatedOn());
			esiInfoJson.setUpdatedOn(esiInfo.getUpdatedOn());
			esiInfoJson.setEsiInfoId(esiInfo.getEsiInfoId());
			esiInfoJson.setEsiNumber(esiInfo.getEsiNumber());
			esiInfoJson.setRegistrationDate(esiInfo.getRegistrationDate());
			esiInfoJson.setStrRegistrationDate(MethodUtil.convertDateToString(esiInfo.getRegistrationDate()));

		}
		return esiInfoJson;
	}

	public static CompanyRolesJson getCompanyRolesJson(CompanyRoles companyRoles) {
		CompanyRolesJson companyRolesJson = new CompanyRolesJson();
		companyRolesJson.setCompanyId(companyRoles.getCompanyId());
		companyRolesJson.setRoleId(companyRoles.getRoleId());
		companyRolesJson.setRoleName(companyRoles.getRoleName());
		return companyRolesJson;
	}

	public static TimeSheetApproverJson getTimeSheetApproverJson(TimeSheetApprovers timeSheetApprovers) {
		TimeSheetApproverJson timeSheetApproverJson = new TimeSheetApproverJson();
		timeSheetApproverJson.setCompanyId(timeSheetApprovers.getCompanyId());
		timeSheetApproverJson.setRoleId(timeSheetApprovers.getRoleId());
		timeSheetApproverJson.setEmployeeId(timeSheetApprovers.getEmployeeId());
		timeSheetApproverJson.setTimeSheetApproverId(timeSheetApprovers.getTimeSheetApproverId());
		return timeSheetApproverJson;
	}

	public static GeneralSettingsJson getGeneralSettingsJson(GeneralSettings generalSettings) {
		GeneralSettingsJson generalSettingsJson = new GeneralSettingsJson();
		generalSettingsJson.setCompanyId(generalSettings.getCompanyId());
		generalSettingsJson.setGeneralsettingsId(generalSettings.getGeneralsettingsId());
		generalSettingsJson.setHoursPerMonth(generalSettings.getHoursPerMonth());
		generalSettingsJson.setHoursPerWeek(generalSettings.getHoursPerWeek());
		return generalSettingsJson;
	}

	public static EmployeeJson getEmployeeJson(Employee employee) {
		EmployeeJson employeeJson = new EmployeeJson();
		employeeJson.setCompanyId(employee.getCompanyId());
		employeeJson.setDisplayName(employee.getDisplayName());
		employeeJson.setEmail(employee.getEmail());
		employeeJson.setEmployeeId(employee.getEmployeeId());
		employeeJson.setFirstName(employee.getFirstName());
		employeeJson.setLastName(employee.getLastName());
		employeeJson.setLocationId(employee.getLocationId());
		employeeJson.setMiddleName(employee.getMiddleName());
		employeeJson.setRoleId(employee.getRoleId());
		employeeJson.setStrDateOfJoining(MethodUtil.convertDateToString(employee.getDateOfJoining()));
		employeeJson.setGenderId(employee.getGenderId());
		employeeJson.setDesignationId(employee.getDesignationId());
		if (employee.getCompanyRoles() != null) {
			employeeJson.setRole(employee.getCompanyRoles().getRoleName());
		}
		if (employee.getDesignation() != null) {
			employeeJson.setDesignation(employee.getDesignation().getDesignationName());
		}
		if (employee.getGender() != null) {
			employeeJson.setGender(employee.getGender().getDescription());
		}
		return employeeJson;
	}

	public static CompanyBankJson getCompanyBankJson(CompanyBanks companyBanks) {
		CompanyBankJson companyBankJson = new CompanyBankJson();
		companyBankJson.setCompanyId(companyBanks.getCompanyId());
		companyBankJson.setAccountNumber(companyBanks.getAccountNumber());
		companyBankJson.setBankId(companyBanks.getBankId());
		companyBankJson.setBranch(companyBanks.getBranch());
		companyBankJson.setCompanyBankId(companyBanks.getCompanyBankId());
		companyBankJson.setIfscCode(companyBanks.getIfscCode());
		companyBankJson.setIsDeleted(companyBanks.getIsDeleted());
		if (companyBanks.getBank() != null) {
			companyBankJson.setBankName(companyBanks.getBank().getDescription());
		}
		return companyBankJson;
	}

	public static CompanyLocationJson getCompanyLocationJson(CompanyLocation companyLocation) {
		CompanyLocationJson companyLocationJson = new CompanyLocationJson();
		companyLocationJson.setCompanyId(companyLocation.getCompanyId());
		companyLocationJson.setAddress(companyLocation.getAddress());
		companyLocationJson.setCity(companyLocation.getCity());
		companyLocationJson.setCompanyLocationId(companyLocation.getCompanyLocationId());
		companyLocationJson.setLocationName(companyLocation.getLocationName());
		companyLocationJson.setStateId(companyLocation.getStateId());
		companyLocationJson.setZipcode(companyLocation.getZipcode());
		if (companyLocation.getState() != null) {
			companyLocationJson.setState(companyLocation.getState().getDescription());
		}
		return companyLocationJson;
	}

	public static DepartmentJson getDepartmentJson(Department department) {
		DepartmentJson departmentJson = new DepartmentJson();
		departmentJson.setCompanyId(department.getCompanyId());
		departmentJson.setDepartmentId(department.getDepartmentId());
		departmentJson.setDepartmentName(department.getDepartmentName());
		return departmentJson;
	}

	public static DesignationJson getDesignationJson(Designation designation) {
		DesignationJson designationJson = new DesignationJson();
		designationJson.setCompanyId(designation.getCompanyId());
		designationJson.setDesignationId(designation.getDesignationId());
		designationJson.setDesignationName(designation.getDesignationName());
		return designationJson;
	}

	public static JobTitlesJson getJobTitlesJson(JobTitles jobTitles) {
		JobTitlesJson jobTitlesJson = new JobTitlesJson();
		jobTitlesJson.setCompanyId(jobTitles.getCompanyId());
		jobTitlesJson.setDescription(jobTitles.getDescription());
		jobTitlesJson.setJobtitle(jobTitles.getJobtitle());
		jobTitlesJson.setJobtitlesId(jobTitles.getJobtitlesId());
		return jobTitlesJson;
	}

	public static CompanyEmployeeDefaultsJson getCompanyEmployeeDefaults(CompanyEmployeeDefaults companyEmployeeDefaults) {
		CompanyEmployeeDefaultsJson companyEmployeeDefaultsJson = new CompanyEmployeeDefaultsJson();
		companyEmployeeDefaultsJson.setCompanyId(companyEmployeeDefaults.getCompanyId());
		companyEmployeeDefaultsJson.setIsDeleted(companyEmployeeDefaults.getIsDeleted());
		companyEmployeeDefaultsJson.setIsEmpAllowedToUpdate(companyEmployeeDefaults.getIsEmpAllowedToUpdate());
		companyEmployeeDefaultsJson.setCompanyEmployeeDefaultsId(companyEmployeeDefaults.getCompanyEmployeeDefaultsId());
		companyEmployeeDefaultsJson.setNoticePeriod(companyEmployeeDefaults.getNoticePeriod());
		companyEmployeeDefaultsJson.setNoticePeriodId(companyEmployeeDefaults.getNoticePeriodId());
		companyEmployeeDefaultsJson.setProbationPeriod(companyEmployeeDefaults.getProbationPeriod());
		companyEmployeeDefaultsJson.setProbatioPeriodTypeId(companyEmployeeDefaults.getProbatioPeriodTypeId());
		companyEmployeeDefaultsJson.setTimeTypeId(companyEmployeeDefaults.getTimeTypeId());
		companyEmployeeDefaultsJson.setWorkerTypeId(companyEmployeeDefaults.getWorkerTypeId());
		if (companyEmployeeDefaults.getProbationPeriodType() != null)
			companyEmployeeDefaultsJson.setProbationPeriodType(companyEmployeeDefaults.getProbationPeriodType().getDescription());
		if (companyEmployeeDefaults.getWorkerType() != null)
			companyEmployeeDefaultsJson.setWorkerType(companyEmployeeDefaults.getWorkerType().getDescription());
		if (companyEmployeeDefaults.getTimeType() != null)
			companyEmployeeDefaultsJson.setTimeType(companyEmployeeDefaults.getTimeType().getDescription());
		if (companyEmployeeDefaults.getNoticePeriodType() != null)
			companyEmployeeDefaultsJson.setNoticePeriodType(companyEmployeeDefaults.getNoticePeriodType().getDescription());
		return companyEmployeeDefaultsJson;
	}

	public static EmployeeFamilyInfoJson getEmployeeFamilyJson(EmployeeFamilyInfo employeeFamilyInfo) {
		EmployeeFamilyInfoJson employeeFamilyInfoJson = new EmployeeFamilyInfoJson();
		employeeFamilyInfoJson.setCompanyId(employeeFamilyInfo.getCompanyId());
		employeeFamilyInfoJson.setEmail(employeeFamilyInfo.getEmail());
		employeeFamilyInfoJson.setEmployeeId(employeeFamilyInfo.getEmployeeId());
		employeeFamilyInfoJson.setFirstName(employeeFamilyInfo.getFirstName());
		employeeFamilyInfoJson.setLastName(employeeFamilyInfo.getLastName());
		employeeFamilyInfoJson.setEmployeeFamilyInfoId(employeeFamilyInfo.getEmployeeFamilyInfoId());
		employeeFamilyInfoJson.setMobileNumber(employeeFamilyInfo.getMobileNumber());
		employeeFamilyInfoJson.setRelationId(employeeFamilyInfo.getRelationId());
		if (employeeFamilyInfo.getRelation() != null) {
			employeeFamilyInfoJson.setRelation(employeeFamilyInfo.getRelation().getDescription());
		}
		return employeeFamilyInfoJson;
	}

	public static EmployeeSalaryInfoJson getEmployeeSalaryInfoJson(EmployeeSalaryInfo employeeSalaryInfo) {
		EmployeeSalaryInfoJson employeeSalaryInfoJson = new EmployeeSalaryInfoJson();
		employeeSalaryInfoJson.setCompanyId(employeeSalaryInfo.getCompanyId());
		employeeSalaryInfoJson.setEmployeeId(employeeSalaryInfo.getEmployeeId());
		employeeSalaryInfoJson.setAnnualSalary(employeeSalaryInfo.getAnnualSalary());
		employeeSalaryInfoJson.setEmployeeSalaryInfoId(employeeSalaryInfo.getEmployeeSalaryInfoId());
		employeeSalaryInfoJson.setStrEffectiveFrom(MethodUtil.convertDateToString(employeeSalaryInfo.getEffectiveFrom()));
		if (employeeSalaryInfo.getEmployee() != null) {
			employeeSalaryInfoJson.setEmployeeJson(getEmployeeJson(employeeSalaryInfo.getEmployee()));
		}
		return employeeSalaryInfoJson;
	}

	public static EmployeePersonalInfoJson getEmployeePersonalInfoJson(EmployeeAddressInfo employeeAddressInfo,
			EmployeePersonalInfo employeePersonalInfo) {
		EmployeePersonalInfoJson employeePersonalInfoJson = new EmployeePersonalInfoJson();
		employeePersonalInfoJson.setCompanyId(employeePersonalInfo.getCompanyId());
		employeePersonalInfoJson.setEmployeeId(employeePersonalInfo.getEmployeeId());
		employeePersonalInfoJson.setMobileNumber(employeePersonalInfo.getMobileNumber());
		employeePersonalInfoJson.setGenderId(employeePersonalInfo.getGenderId());
		employeePersonalInfoJson.setEmployeePersonalInfoId(employeePersonalInfo.getEmployeePersonalInfoId());
		employeePersonalInfoJson.setStrDateOfBirth(MethodUtil.convertDateToString(employeePersonalInfo.getDateOfBirth()));
		employeePersonalInfoJson.setMaritalStatusId(employeePersonalInfo.getMaritalStatusId());
		employeePersonalInfoJson.setBloodGroupId(employeePersonalInfo.getBloodGroupId());
		employeePersonalInfoJson.setWorkNumber(employeePersonalInfo.getWorkNumber());
		employeePersonalInfoJson.setResidenceNumber(employeePersonalInfo.getResidenceNumber());
		employeePersonalInfoJson.setPersonalEmail(employeePersonalInfo.getPersonalEmail());
		employeePersonalInfoJson.setSkypeId(employeePersonalInfo.getSkypeId());
		employeePersonalInfoJson.setEmployeeAddressInfoId(employeeAddressInfo.getEmployeeAddressInfoId());
		employeePersonalInfoJson.setIsPermSameAsCurr(employeeAddressInfo.getIsPermSameAsCurr());
		employeePersonalInfoJson.setCurrAddress(employeeAddressInfo.getCurrAddress());
		employeePersonalInfoJson.setCurrCity(employeeAddressInfo.getCurrCity());
		employeePersonalInfoJson.setCurrCountry(employeeAddressInfo.getCurrCountry());
		employeePersonalInfoJson.setCurrState(employeeAddressInfo.getCurrState());
		employeePersonalInfoJson.setPermAddress(employeeAddressInfo.getPermAddress());
		employeePersonalInfoJson.setPermCity(employeeAddressInfo.getPermCity());
		employeePersonalInfoJson.setPermCountry(employeeAddressInfo.getPermCountry());
		employeePersonalInfoJson.setPermState(employeeAddressInfo.getPermState());
		return employeePersonalInfoJson;
	}

	public static CategoriesJson getCategoriesJson(Categories categories) {
		CategoriesJson categoriesJson = new CategoriesJson();
		categoriesJson.setCompanyId(categories.getCompanyId());
		categoriesJson.setDescription(categories.getDescription());
		categoriesJson.setExpenseName(categories.getExpenseName());
		categoriesJson.setCategoriesId(categories.getCategoriesId());
		return categoriesJson;
	}

	public static EmployeeProfessionalInfoJson getEmployeeProfessionalInfoJson(EmployeeProfessionalInfo employeeProfessionalInfo) {
		EmployeeProfessionalInfoJson employeeProfessionalInfoJson = new EmployeeProfessionalInfoJson();
		employeeProfessionalInfoJson.setCompanyId(employeeProfessionalInfo.getCompanyId());
		employeeProfessionalInfoJson.setEmployeeId(employeeProfessionalInfo.getEmployeeId());
		employeeProfessionalInfoJson.setEmployeeProfessionalInfoId(employeeProfessionalInfo.getEmployeeProfessionalInfoId());
		employeeProfessionalInfoJson.setProfessionalSummery(employeeProfessionalInfo.getProfessionalSummery());
		employeeProfessionalInfoJson.setStatusMessage(employeeProfessionalInfo.getStatusMessage());
		return employeeProfessionalInfoJson;
	}

	public static EmployeeExperienceInfoJson getEmployeeExperienceInfoJson(EmployeeExperienceInfo employeeExperienceInfo) {
		EmployeeExperienceInfoJson employeeExperienceInfoJson = new EmployeeExperienceInfoJson();
		employeeExperienceInfoJson.setCompanyId(employeeExperienceInfo.getCompanyId());
		employeeExperienceInfoJson.setEmployeeId(employeeExperienceInfo.getEmployeeId());
		employeeExperienceInfoJson.setCompanyName(employeeExperienceInfo.getCompanyName());
		employeeExperienceInfoJson.setJobTitle(employeeExperienceInfo.getJobTitle());
		employeeExperienceInfoJson.setLocation(employeeExperienceInfo.getLocation());
		employeeExperienceInfoJson.setStrFromDate(MethodUtil.convertDateToString(employeeExperienceInfo.getFromDate()));
		employeeExperienceInfoJson.setStrToDate(MethodUtil.convertDateToString(employeeExperienceInfo.getToDate()));
		employeeExperienceInfoJson.setDescription(employeeExperienceInfo.getDescription());
		employeeExperienceInfoJson.setEmployeeExperienceInfoId(employeeExperienceInfo.getEmployeeExperienceInfoId());
		return employeeExperienceInfoJson;
	}

	public static EmployeeEducationalInfoJson getEmployeeEducationalInfoJson(EmployeeEducationalInfo employeeEducationalInfo) {
		EmployeeEducationalInfoJson employeeEducationalInfoJson = new EmployeeEducationalInfoJson();
		employeeEducationalInfoJson.setCompanyId(employeeEducationalInfo.getCompanyId());
		employeeEducationalInfoJson.setEmployeeId(employeeEducationalInfo.getEmployeeId());
		employeeEducationalInfoJson.setStrFromDate(MethodUtil.convertDateToString(employeeEducationalInfo.getFromDate()));
		employeeEducationalInfoJson.setStrToDate(MethodUtil.convertDateToString(employeeEducationalInfo.getToDate()));
		employeeEducationalInfoJson.setDegree(employeeEducationalInfo.getDegree());
		employeeEducationalInfoJson.setSpecialization(employeeEducationalInfo.getSpecialization());
		employeeEducationalInfoJson.setUniversity(employeeEducationalInfo.getUniversity());
		employeeEducationalInfoJson.setEmployeeEducationalInfoId(employeeEducationalInfo.getEmployeeEducationalInfoId());
		return employeeEducationalInfoJson;

	}

	public static EmployeeOneTimeComponentJson getEmployeeOneTimeComponentJson(EmployeeOneTimeComponent employeeOneTimeComponent) {
		EmployeeOneTimeComponentJson employeeOneTimeComponentJson = new EmployeeOneTimeComponentJson();
		employeeOneTimeComponentJson.setCompanyId(employeeOneTimeComponent.getCompanyId());
		employeeOneTimeComponentJson.setEmployeeId(employeeOneTimeComponent.getEmployeeId());
		employeeOneTimeComponentJson.setAmount(employeeOneTimeComponent.getAmount());
		employeeOneTimeComponentJson.setEmployeeOneTimeComponentId(employeeOneTimeComponent.getEmployeeOneTimeComponentId());
		employeeOneTimeComponentJson.setNote(employeeOneTimeComponent.getNote());
		employeeOneTimeComponentJson.setOneTimeComponentName(employeeOneTimeComponent.getOneTimeComponentName());
		employeeOneTimeComponentJson.setStatusId(employeeOneTimeComponent.getStatusId());
		employeeOneTimeComponentJson.setStrMonthPayable(MethodUtil.convertDateToString(employeeOneTimeComponent.getMonthPayable()));
		if (employeeOneTimeComponent.getStatus() != null) {
			employeeOneTimeComponentJson.setStatus(employeeOneTimeComponent.getStatus().getDescription());
		}
		return employeeOneTimeComponentJson;

	}

	public static EmployeeProjectJson getEmployeeProjectJson(EmployeeProject employeeProject) {
		EmployeeProjectJson employeeProjectJson = new EmployeeProjectJson();
		employeeProjectJson.setCompanyId(employeeProject.getCompanyId());
		employeeProjectJson.setEmployeeId(employeeProject.getEmployeeId());
		employeeProjectJson.setEmployeeProjectId(employeeProject.getEmployeeProjectId());
		employeeProjectJson.setProjectId(employeeProject.getProjectId());
		employeeProjectJson.setRoleId(employeeProject.getRoleId());
		if (employeeProject.getProject() != null) {
			employeeProjectJson.setProjectName(employeeProject.getProject().getProjectName());
		}
		if (employeeProject.getCompanyRoles() != null) {
			employeeProjectJson.setRole(employeeProject.getCompanyRoles().getRoleName());
		}
		return employeeProjectJson;

	}

	public static TagsJson getTagsJson(Tags tags) {
		TagsJson tagsJson = new TagsJson();
		tagsJson.setCompanyId(tags.getCompanyId());
		tagsJson.setTagId(tags.getTagId());
		tagsJson.setTagName(tags.getTagName());
		return tagsJson;
	}

	public static ClientsJson getClientsJson(Clients clients) {
		ClientsJson clientsJson = new ClientsJson();
		clientsJson.setCompanyId(clients.getCompanyId());
		clientsJson.setClientName(clients.getClientName());
		clientsJson.setClientsId(clients.getClientsId());
		clientsJson.setManagerName(clients.getManagerName());
		clientsJson.setNotes(clients.getNotes());
		return clientsJson;
	}

	public static ClientWorkHoursJson getClientWorkHoursJson(CompanyClientWorkHours companyClientWorkHours) {
		ClientWorkHoursJson clientWorkHoursJson = new ClientWorkHoursJson();
		clientWorkHoursJson.setCompanyId(companyClientWorkHours.getCompanyId());
		clientWorkHoursJson.setStrFrom(MethodUtil.convertDateToString(companyClientWorkHours.getClientFrom()));
		clientWorkHoursJson.setStrTo(MethodUtil.convertDateToString(companyClientWorkHours.getClientTo()));
		clientWorkHoursJson.setClientWorkHourId(companyClientWorkHours.getClientWorkHourId());
		clientWorkHoursJson.setClientsId(companyClientWorkHours.getClientId());
		if (companyClientWorkHours.getClients() != null) {
			clientWorkHoursJson.setClient(companyClientWorkHours.getClients().getClientName());
		}

		return clientWorkHoursJson;
	}

	public static DeptWorkHoursJson getDeptWorkHoursJson(DeptWorkHours deptWorkHours) {
		DeptWorkHoursJson deptWorkHoursJson = new DeptWorkHoursJson();
		deptWorkHoursJson.setCompanyId(deptWorkHours.getCompanyId());
		deptWorkHoursJson.setGroupById(deptWorkHours.getGroupById());
		deptWorkHoursJson.setStrFrom(MethodUtil.convertDateToString(deptWorkHours.getDeptFrom()));
		deptWorkHoursJson.setStrTo(MethodUtil.convertDateToString(deptWorkHours.getDeptTo()));
		deptWorkHoursJson.setDeptWorkHourId(deptWorkHours.getDeptWorkHourId());
		deptWorkHoursJson.setDepartmentId(deptWorkHours.getDepartmentId());
		deptWorkHoursJson.setIncludeNonbillableHours(deptWorkHours.getIncludeNonbillableHours());
		if (deptWorkHours.getGroupBy() != null) {
			deptWorkHoursJson.setGroupBy(deptWorkHours.getGroupBy().getDescription());
		}
		if (deptWorkHours.getDepartment() != null) {
			deptWorkHoursJson.setDepartment(deptWorkHours.getDepartment().getDepartmentName());

		}

		return deptWorkHoursJson;
	}

	public static MedicalReimbursementJson getMedicalReimbursementJson(MedicalReimbursement medicalReimbursement) {
		MedicalReimbursementJson medicalReimbursementJson = new MedicalReimbursementJson();
		medicalReimbursementJson.setCompanyId(medicalReimbursement.getCompanyId());
		medicalReimbursementJson.setMaxAnnualLimit(medicalReimbursement.getMaxAnnualLimit());
		medicalReimbursementJson.setRequireSubmissionId(medicalReimbursement.getRequireSubmissionId());
		medicalReimbursementJson.setMedicalReimbursementId(medicalReimbursement.getMedicalReimbursementId());
		return medicalReimbursementJson;
	}

	public static TransportAllowanceJson getTransportAllowanceJson(TransportAllowance transportAllowance) {
		TransportAllowanceJson transportAllowanceJson = new TransportAllowanceJson();
		transportAllowanceJson.setCompanyId(transportAllowance.getCompanyId());
		transportAllowanceJson.setMaxAnnualLimit(transportAllowance.getMaxAnnualLimit());
		transportAllowanceJson.setRequireSubmissionId(transportAllowance.getRequireSubmissionId());
		transportAllowanceJson.setTransportAllowanceId(transportAllowance.getTransportAllowanceId());
		return transportAllowanceJson;
	}

	public static ProfessionalAllowanceJson getProfessionalAllowanceJson(ProfessionalAllowance professionalAllowance) {
		ProfessionalAllowanceJson professionalAllowanceJson = new ProfessionalAllowanceJson();
		professionalAllowanceJson.setCompanyId(professionalAllowance.getCompanyId());
		professionalAllowanceJson.setMaxAnnualLimit(professionalAllowance.getMaxAnnualLimit());
		professionalAllowanceJson.setRequireSubmissionId(professionalAllowance.getRequireSubmissionId());
		professionalAllowanceJson.setProfessionalAllowanceId(professionalAllowance.getProfessionalAllowanceId());
		return professionalAllowanceJson;
	}

	public static TravelReimbursementJson getTravelReimbursementJson(TravelReimbursement travelReimbursement) {
		TravelReimbursementJson travelReimbursementJson = new TravelReimbursementJson();
		travelReimbursementJson.setCompanyId(travelReimbursement.getCompanyId());
		travelReimbursementJson.setMaxAnnualLimit(travelReimbursement.getMaxAnnualLimit());
		travelReimbursementJson.setRequireSubmissionId(travelReimbursement.getRequireSubmissionId());
		travelReimbursementJson.setTravelReimbursementId(travelReimbursement.getTravelReimbursementId());
		return travelReimbursementJson;
	}

	public static FoodCouponsJson getFoodCouponsJson(FoodCoupons foodCoupons) {
		FoodCouponsJson foodCouponsJson = new FoodCouponsJson();
		foodCouponsJson.setCompanyId(foodCoupons.getCompanyId());
		foodCouponsJson.setMaxAnnualLimit(foodCoupons.getMaxAnnualLimit());
		foodCouponsJson.setRequireSubmissionId(foodCoupons.getRequireSubmissionId());
		foodCouponsJson.setFoodCouponsId(foodCoupons.getFoodCouponsId());
		return foodCouponsJson;
	}

	public static CityCompensatoryAllowanceJson getCityCompensatoryAllowanceJson(CityCompensatoryAllowance cityCompensatoryAllowance) {
		CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson = new CityCompensatoryAllowanceJson();
		cityCompensatoryAllowanceJson.setCompanyId(cityCompensatoryAllowance.getCompanyId());
		cityCompensatoryAllowanceJson.setMaxAnnualLimit(cityCompensatoryAllowance.getMaxAnnualLimit());
		cityCompensatoryAllowanceJson.setRequireSubmissionId(cityCompensatoryAllowance.getRequireSubmissionId());
		cityCompensatoryAllowanceJson.setCityCompensatoryAllowanceId(cityCompensatoryAllowance.getCityCompensatoryAllowanceId());
		return cityCompensatoryAllowanceJson;
	}

	public static DailyAllowanceJson getDailyAllowanceJson(DailyAllowance dailyAllowance) {
		DailyAllowanceJson dailyAllowanceJson = new DailyAllowanceJson();
		dailyAllowanceJson.setCompanyId(dailyAllowance.getCompanyId());
		dailyAllowanceJson.setMaxAnnualLimit(dailyAllowance.getMaxAnnualLimit());
		dailyAllowanceJson.setRequireSubmissionId(dailyAllowance.getRequireSubmissionId());
		dailyAllowanceJson.setDailyAllowanceId(dailyAllowance.getDailyAllowanceId());
		return dailyAllowanceJson;
	}

	public static CustomAllowanceJson getCustomAllowanceJson(CustomAllowance customAllowance) {
		CustomAllowanceJson customAllowanceJson = new CustomAllowanceJson();
		customAllowanceJson.setCompanyId(customAllowance.getCompanyId());
		customAllowanceJson.setMaxAnnualLimit(customAllowance.getMaxAnnualLimit());
		customAllowanceJson.setName(customAllowance.getName());
		customAllowanceJson.setSubmitBillId(customAllowance.getSubmitBillId());
		customAllowanceJson.setTaxBenefitId(customAllowance.getTaxBenefitId());
		customAllowanceJson.setCustomAllowanceId(customAllowance.getCustomAllowanceId());
		return customAllowanceJson;
	}

	public static AllowancesJson getAllowancesJson(Allowances allowances) {
		AllowancesJson allowancesJson = new AllowancesJson();
		allowancesJson.setCompanyId(allowances.getCompanyId());
		allowancesJson.setAllowancesName(allowances.getAllowancesName());
		allowancesJson.setAllowancesDescription(allowances.getAllowancesDescription());
		allowancesJson.setHasTaxBenefits(allowances.getHasTaxBenefits());
		allowancesJson.setAllowancesId(allowances.getAllowancesId());
		return allowancesJson;
	}

	public static DeductionsJson getDeductionsJson(Deductions deductions) {
		DeductionsJson deductionsJson = new DeductionsJson();
		deductionsJson.setCompanyId(deductions.getCompanyId());
		deductionsJson.setDeductionName(deductions.getDeductionName());
		deductionsJson.setDeductionDescription(deductions.getDeductionDescription());
		deductionsJson.setDeductionId(deductions.getDeductionId());
		return deductionsJson;
	}

	public static ReimbursementJson getReimbursementJson(Reimbursement reimbursement) {
		ReimbursementJson reimbursementJson = new ReimbursementJson();
		reimbursementJson.setCompanyId(reimbursement.getCompanyId());
		reimbursementJson.setReimbursementName(reimbursement.getReimbursementName());
		reimbursementJson.setReimbursementDescription(reimbursement.getReimbursementDescription());
		reimbursementJson.setReimbursementId(reimbursement.getReimbursementId());
		return reimbursementJson;
	}

	public static BonusesJson getBonusesJson(Bonuses bonuses) {
		BonusesJson bonusesJson = new BonusesJson();
		bonusesJson.setCompanyId(bonuses.getCompanyId());
		bonusesJson.setBonusesName(bonuses.getBonusesName());
		bonusesJson.setBonusesDescription(bonuses.getBonusesDescription());
		bonusesJson.setBonusesId(bonuses.getBonusesId());
		return bonusesJson;
	}

	public static TaskAssignToHrJson getTaskAssignToHrJson(TaskAssignToHr taskAssignToHr) {
		TaskAssignToHrJson taskAssignToHrJson = new TaskAssignToHrJson();
		taskAssignToHrJson.setCompanyId(taskAssignToHr.getCompanyId());
		taskAssignToHrJson.setTaskName(taskAssignToHr.getTaskName());
		taskAssignToHrJson.setTaskAssignToHrId(taskAssignToHr.getTaskAssignToHrId());
		return taskAssignToHrJson;
	}

	public static TaskAssignToEmployeeJson getTaskAssignToEmployeeJson(TaskAssignToEmployee taskAssignToEmployee) {
		TaskAssignToEmployeeJson taskAssignToEmployeeJson = new TaskAssignToEmployeeJson();
		taskAssignToEmployeeJson.setCompanyId(taskAssignToEmployee.getCompanyId());
		taskAssignToEmployeeJson.setTaskName(taskAssignToEmployee.getTaskName());
		taskAssignToEmployeeJson.setTaskAssignToEmployeeId(taskAssignToEmployee.getTaskAssignToEmployeeId());
		return taskAssignToEmployeeJson;
	}

	public static CompanyLeavePlansJson getCompanyLeavePlansJson(CompanyLeavePlans companyLeavePlans) {
		CompanyLeavePlansJson companyLeavePlansJson = new CompanyLeavePlansJson();
		companyLeavePlansJson.setCompanyId(companyLeavePlans.getCompanyId());
		companyLeavePlansJson.setCompanyLeavePlansId(companyLeavePlans.getCompanyLeavePlansId());
		companyLeavePlansJson.setDescription(companyLeavePlans.getDescription());
		companyLeavePlansJson.setLeavePlanName(companyLeavePlans.getLeavePlanName());
		return companyLeavePlansJson;
	}

	public static AddLeaveTypeJson getAddLeaveTypeJson(AddLeaveType addLeaveType) {
		AddLeaveTypeJson addLeaveTypeJson = new AddLeaveTypeJson();
		addLeaveTypeJson.setCompanyId(addLeaveType.getCompanyId());
		addLeaveTypeJson.setIsDeleted(addLeaveTypeJson.getIsDeleted());
		addLeaveTypeJson.setAccrualStartFromTypeId(addLeaveType.getAccrualStartFromTypeId());
		addLeaveTypeJson.setAccruedLeaveLapseAfter(addLeaveType.getAccruedLeaveLapseAfter());
		addLeaveTypeJson.setAccruedLeaveLapseTypeId(addLeaveType.getAccruedLeaveLapseTypeId());
		addLeaveTypeJson.setAccruedRateId(addLeaveType.getAccruedRateId());
		addLeaveTypeJson.setAccruedRateOn(addLeaveType.getAccruedRateOn());
		addLeaveTypeJson.setAnnualQuota(addLeaveType.getAnnualQuota());
		addLeaveTypeJson.setAnnualQuotaTypeId(addLeaveType.getAnnualQuotaTypeId());
		addLeaveTypeJson.setCarryForwardMaxValue(addLeaveType.getCarryForwardMaxValue());
		addLeaveTypeJson.setCompanyLeavePlanId(addLeaveType.getCompanyLeavePlanId());
		addLeaveTypeJson.setConsecutiveBtPaidLeavesHoliday(addLeaveType.getConsecutiveBtPaidLeavesHoliday());
		addLeaveTypeJson.setConsecutiveBtPaidLeavesWeekOff(addLeaveType.getConsecutiveBtPaidLeavesWeekOff());
		addLeaveTypeJson.setEndOfLeaveCalenderTypeId(addLeaveType.getEndOfLeaveCalenderTypeId());
		addLeaveTypeJson.setFrequencyOfLeaves(addLeaveType.getFrequencyOfLeaves());
		addLeaveTypeJson.setIsAllowUtilizationOfLeaves(addLeaveType.getIsAllowUtilizationOfLeaves());
		addLeaveTypeJson.setIsProrate(addLeaveType.getIsProrate());
		addLeaveTypeJson.setLeaveAvailabilityTypeId(addLeaveType.getLeaveAvailabilityTypeId());
		addLeaveTypeJson.setLeavesAvailedFrom(addLeaveType.getLeavesAvailedFrom());
		addLeaveTypeJson.setLeavesAvailedFromTypeId(addLeaveType.getLeavesAvailedFromTypeId());
		addLeaveTypeJson.setLeaveTypeId(addLeaveType.getLeaveTypeId());
		addLeaveTypeJson.setPayMaximumValue(addLeaveType.getPayMaximumValue());
		addLeaveTypeJson.setProrateFrom(addLeaveType.getProrateFrom());
		addLeaveTypeJson.setAddLeaveTypeId(addLeaveType.getAddLeaveTypeId());
		if (addLeaveType.getCompanyLeaveType() != null)
			addLeaveTypeJson.setLeaveType(addLeaveType.getCompanyLeaveType().getLeaveTypeName());
		return addLeaveTypeJson;

	}

	public static CompanyLeaveTypeJson getCompanyLeaveTypeJson(CompanyLeaveType companyLeaveType) {
		CompanyLeaveTypeJson companyLeaveTypeJson = new CompanyLeaveTypeJson();
		companyLeaveTypeJson.setCompanyId(companyLeaveType.getCompanyId());
		companyLeaveTypeJson.setIsDeleted(companyLeaveType.getIsDeleted());
		companyLeaveTypeJson.setDocumentNeeded_After(companyLeaveType.getDocumentNeeded_After());
		companyLeaveTypeJson.setIsCommentRequired(companyLeaveType.getIsCommentRequired());
		companyLeaveTypeJson.setIsDocumentProofRequired(companyLeaveType.getIsDocumentProofRequired());
		companyLeaveTypeJson.setIsHalfDayLeaveAllowed(companyLeaveType.getIsHalfDayLeaveAllowed());
		companyLeaveTypeJson.setIsPaidLeave(companyLeaveType.getIsPaidLeave());
		companyLeaveTypeJson.setIsPriorNoticeRequired(companyLeaveType.getIsPriorNoticeRequired());
		companyLeaveTypeJson.setIsRestricted(companyLeaveType.getIsRestricted());
		companyLeaveTypeJson.setIsSickLeave(companyLeaveType.getIsSickLeave());
		companyLeaveTypeJson.setIsStatutoryLeave(companyLeaveType.getIsStatutoryLeave());
		companyLeaveTypeJson.setLeaveTypeDescription(companyLeaveType.getLeaveTypeDescription());
		companyLeaveTypeJson.setLeaveTypeName(companyLeaveType.getLeaveTypeName());
		companyLeaveTypeJson.setPriorNoticeRequered_After(companyLeaveType.getPriorNoticeRequered_After());
		companyLeaveTypeJson.setRestrictToId(companyLeaveType.getRestrictToId());
		companyLeaveTypeJson.setCompanyLeaveTypeId(companyLeaveType.getCompanyLeaveTypeId());
		return companyLeaveTypeJson;

	}

	public static ExitSettingsJson getExitSettingsJson(ExitSettings exitSettings) {
		ExitSettingsJson exitSettingsJson = new ExitSettingsJson();
		exitSettingsJson.setCompanyId(exitSettings.getCompanyId());
		exitSettingsJson.setReason(exitSettings.getReason());
		exitSettingsJson.setReasonTypeId(exitSettings.getReasonTypeId());
		exitSettingsJson.setExitSettingsId(exitSettings.getExitSettingsId());
		return exitSettingsJson;
	}

	public static HolidaysJson getHolidaysJson(Holidays holidays) {
		HolidaysJson holidaysJson = new HolidaysJson();
		holidaysJson.setCompanyId(holidays.getCompanyId());
		holidaysJson.setDescription(holidays.getDescription());
		holidaysJson.setStrHolidayDate(MethodUtil.convertDateToString(holidays.getHolidayDate()));
		holidaysJson.setHolidayName(holidays.getHolidayName());
		holidaysJson.setIsFloatingHoliday(holidays.getIsFloatingHoliday());
		holidaysJson.setHolidaysId(holidays.getHolidaysId());
		return holidaysJson;
	}

	public static LeavesNotifyJson getNotifyJson(LeavesNotify leavesNotify) {
		LeavesNotifyJson leavesNotifyJson = new LeavesNotifyJson();
		leavesNotifyJson.setCompanyId(leavesNotify.getCompanyId());
		leavesNotifyJson.setLeavesNotifyId(leavesNotify.getLeavesNotifyId());
		leavesNotifyJson.setNotifyEmpId(leavesNotify.getNotifyEmpId());
		if (leavesNotify.getEmployee() != null) {
			leavesNotifyJson.setNotifierName(leavesNotify.getEmployee().getDisplayName());
		}
		return leavesNotifyJson;
	}

	public static PayrollCycleSettingsJson getPayrollCycleSettingsJson(PayrollCycleSettings payrollCycleSettings) {
		PayrollCycleSettingsJson payrollCycleSettingsJson = new PayrollCycleSettingsJson();
		payrollCycleSettingsJson.setCompanyId(payrollCycleSettings.getCompanyId());
		payrollCycleSettingsJson.setPayCycleMonthId(payrollCycleSettings.getPayCycleMonthId());
		payrollCycleSettingsJson.setPayDay(payrollCycleSettings.getPayDay());
		payrollCycleSettingsJson.setPayFrequency(payrollCycleSettings.getPayFrequency());
		payrollCycleSettingsJson.setPayrollCycleSettingsId(payrollCycleSettings.getPayrollCycleSettingsId());
		payrollCycleSettingsJson.setStrPayDate(MethodUtil.convertDateToString(payrollCycleSettings.getPayDate()));
		payrollCycleSettingsJson.setStrPayCycleStartDate(MethodUtil.convertDateToString(payrollCycleSettings.getPayCycleStartDate()));
		payrollCycleSettingsJson.setStrPayCycleEndDate(MethodUtil.convertDateToString(payrollCycleSettings.getPayCycleEndDate()));
		payrollCycleSettingsJson.setStrPayPeriodEndDay(payrollCycleSettings.getStrPayPeriodEndDay());
		return payrollCycleSettingsJson;
	}

	public static ProjectJson getProjectJson(Project projects) {
		ProjectJson projectsJson = new ProjectJson();
		projectsJson.setCompanyId(projects.getCompanyId());
		projectsJson.setProjectId(projects.getProjectId());
		projectsJson.setProjectName(projects.getProjectName());
		projectsJson.setStatusId(projects.getStatusId());
		projectsJson.setStrEndDate(MethodUtil.convertDateToString(projects.getEndDate()));
		projectsJson.setStrStartDate(MethodUtil.convertDateToString(projects.getStartDate()));
		projectsJson.setDescription(projects.getDescription());
		projectsJson.setIsProjectAssignToAllEmployees(projects.getIsProjectAssignToAllEmployees());
		projectsJson.setClientsId(projects.getClientsId());
		if (projects.getStatus() != null) {
			projectsJson.setStatus(projects.getStatus().getDescription());
		}
		if (projects.getClients() != null) {
			projectsJson.setClient(projects.getClients().getClientName());
		}
		return projectsJson;
	}

	public static ShiftsJson getShiftsJson(Shifts shifts) {
		ShiftsJson shiftsJson = new ShiftsJson();
		shiftsJson.setCompanyId(shifts.getCompanyId());
		shiftsJson.setShiftsId(shifts.getShiftsId());
		shiftsJson.setShiftName(shifts.getShiftName());
		shiftsJson.setStartTimeHrs(shifts.getStartTimeHrs());
		shiftsJson.setStartTimeMns(shifts.getStartTimeMns());
		shiftsJson.setStartTimeType(shifts.getStartTimeType());
		shiftsJson.setToTimeHrs(shifts.getToTimeHrs());
		shiftsJson.setToTimeMns(shifts.getToTimeMns());
		shiftsJson.setToTimeType(shifts.getToTimeType());
		shiftsJson.setBreakDuratation(shifts.getBreakDuratation());
		return shiftsJson;
	}

	public static GratuityContributionJson getGratuityContributionJson(GratuityContribution gratuityContribution) {
		GratuityContributionJson gratuityContributionJson = new GratuityContributionJson();
		gratuityContributionJson.setCompanyId(gratuityContribution.getCompanyId());
		gratuityContributionJson.setGratuityContributionId(gratuityContribution.getGratuityContributionId());
		gratuityContributionJson.setMaxAnnualLimit(gratuityContribution.getMaxAnnualLimit());
		return gratuityContributionJson;
	}

	public static SalaryComponentJson getSalaryComponentJson(SalaryComponent salaryComponent) {
		SalaryComponentJson salaryComponentJson = new SalaryComponentJson();
		salaryComponentJson.setCompanyId(salaryComponent.getCompanyId());
		salaryComponentJson.setBasic(salaryComponent.getBasic());
		salaryComponentJson.setHra(salaryComponent.getHra());
		if (salaryComponent.getCityCompensatoryAllowance() != null) {
			salaryComponentJson.setCityCompensatoryAllowance(salaryComponent.getCityCompensatoryAllowance().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setCityCompensatoryAllowance(0l);
		}
		if (salaryComponent.getDailyAllowance() != null) {
			salaryComponentJson.setDailyAllowance(salaryComponent.getDailyAllowance().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setDailyAllowance(0l);
		}
		if (salaryComponent.getFoodCoupons() != null) {
			salaryComponentJson.setFoodCoupons(salaryComponent.getFoodCoupons().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setFoodCoupons(0l);
		}
		if (salaryComponent.getGratuityContribution() != null) {
			salaryComponentJson.setGratuityContribution(salaryComponent.getGratuityContribution().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setGratuityContribution(0l);
		}
		if (salaryComponent.getMedicalReimbursement() != null) {
			salaryComponentJson.setMedicalReimbursement(salaryComponent.getMedicalReimbursement().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setMedicalReimbursement(0l);
		}
		if (salaryComponent.getProfessionalAllowance() != null) {
			salaryComponentJson.setProfessionalAllowance(salaryComponent.getProfessionalAllowance().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setProfessionalAllowance(0l);
		}
		if (salaryComponent.getTransportAllowance() != null) {
			salaryComponentJson.setTransportAllowance(salaryComponent.getTransportAllowance().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setTransportAllowance(0l);
		}
		if (salaryComponent.getTravelReimbursement() != null) {
			salaryComponentJson.setTravelReimbursement(salaryComponent.getTravelReimbursement().getMaxAnnualLimit());
		} else {
			salaryComponentJson.setTravelReimbursement(0l);
		}
		salaryComponentJson.setSalaryComponentId(salaryComponent.getSalaryComponentId());
		salaryComponentJson.setPf(salaryComponent.getPf());
		return salaryComponentJson;
	}

	public static EmployeeTimeSheetJson getEmployeeTimeSheetJson(Employee_TimeSheet employee_TimeSheet) {
		EmployeeTimeSheetJson employeeTimeSheetJson = new EmployeeTimeSheetJson();
		employeeTimeSheetJson.setTimesheetId(employee_TimeSheet.getTimesheetId());
		employeeTimeSheetJson.setEmployeeId(employee_TimeSheet.getEmployeeId());
		employeeTimeSheetJson.setStatusId(employee_TimeSheet.getStatusId());
		employeeTimeSheetJson.setProjectId(employee_TimeSheet.getProjectId());
		if (employee_TimeSheet.getTimesheet() != null) {
			employeeTimeSheetJson.setSpendedTime(employee_TimeSheet.getSpendedTime());
		}
		if (employee_TimeSheet.getEmployee() != null) {
			employeeTimeSheetJson.setDisplayName(employee_TimeSheet.getEmployee().getDisplayName());
			employeeTimeSheetJson.setEmail(employee_TimeSheet.getEmployee().getEmail());
		}
		if (employee_TimeSheet.getTimesheet() != null) {
			employeeTimeSheetJson.setStrTimeSheetDate(MethodUtil.convertDateToString(employee_TimeSheet.getTimesheet().getTimeSheetDate()));
		}
		return employeeTimeSheetJson;
	}

	public static EmployeeLeaveJson getEmployeeLeaveJson(Employee_Leave employee_Leave) {
		EmployeeLeaveJson employeeLeaveJson = new EmployeeLeaveJson();
		employeeLeaveJson.setLeaveId(employee_Leave.getLeaveId());
		employeeLeaveJson.setEmployeeId(employee_Leave.getEmployeeId());
		employeeLeaveJson.setStatusId(employee_Leave.getStatusId());
		employeeLeaveJson.setProjectId(employee_Leave.getProjectId());
		employeeLeaveJson.setNote(employee_Leave.getNote());
		employeeLeaveJson.setStrLeaveIds(MethodUtil.convertIntegerToString(employee_Leave.getLeaveId()));
		employeeLeaveJson.setLeaveTypeId(employee_Leave.getLeaveTypeId());
		employeeLeaveJson.setAppliedOn(MethodUtil.convertDateToString(employee_Leave.getAppliedOn()));
		employeeLeaveJson.setComment(employee_Leave.getComment());
		employeeLeaveJson.setApprovedOrRejectedById(employee_Leave.getApprovedOrRejectedById());
		if (employee_Leave.getLeaveTime() != null) {
			employeeLeaveJson.setLeaveTime(employee_Leave.getLeaveTime());
		}
		if (employee_Leave.getLeave() != null) {
			employeeLeaveJson.setStrLeaveDate(MethodUtil.convertDateToString(employee_Leave.getLeave().getLeaveDate()));
			employeeLeaveJson.setStrLeaveDates(employeeLeaveJson.getStrLeaveDate());
		}
		if (employee_Leave.getCompanyLeaveType() != null) {
			employeeLeaveJson.setLeaveType(employee_Leave.getCompanyLeaveType().getLeaveTypeName());
		}
		if (employee_Leave.getEmployee() != null) {
			employeeLeaveJson.setEmployeeName(employee_Leave.getEmployee().getDisplayName());
		}
		return employeeLeaveJson;
	}
}
