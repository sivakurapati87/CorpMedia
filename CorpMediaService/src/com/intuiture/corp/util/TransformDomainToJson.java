package com.intuiture.corp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.Allowances;
import com.intuiture.corp.entity.Bonuses;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.entity.Clients;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanyBanks;
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
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.EmployeeAddressInfo;
import com.intuiture.corp.entity.EmployeeEducationalInfo;
import com.intuiture.corp.entity.EmployeeExperienceInfo;
import com.intuiture.corp.entity.EmployeeFamilyInfo;
import com.intuiture.corp.entity.EmployeePersonalInfo;
import com.intuiture.corp.entity.EmployeeProfessionalInfo;
import com.intuiture.corp.entity.FoodCoupons;
import com.intuiture.corp.entity.GeneralSettings;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.entity.JobTitles;
import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.entity.MedicalReimbursement;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.entity.Reimbursement;
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
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.EmployeeEducationalInfoJson;
import com.intuiture.corp.json.EmployeeExperienceInfoJson;
import com.intuiture.corp.json.EmployeeFamilyInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.json.ReimbursementJson;
import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.json.TaskAssignToEmployeeJson;
import com.intuiture.corp.json.TaskAssignToHrJson;
import com.intuiture.corp.json.TimeSheetApproverJson;
import com.intuiture.corp.json.TransportAllowanceJson;
import com.intuiture.corp.json.TravelReimbursementJson;

public class TransformDomainToJson {
	private static Logger LOG = Logger.getLogger(TransformDomainToJson.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static List<Integer> splitStringInList(String idsInString) {
		Integer[] ids = splitString(idsInString);
		List<Integer> listOfIds = ids != null ? Arrays.asList(ids) : null;
		return listOfIds;
	}

	public static Integer[] splitString(String idsInString) {
		Integer[] ids = null;
		if (idsInString != null && idsInString.length() > 0) {
			String[] strIds = idsInString.split(",");
			ids = new Integer[strIds.length];
			for (int i = 0; i < strIds.length; i++) {
				ids[i] = Integer.parseInt(strIds[i]);
			}
		}
		return ids;
	}

	public static Date convertDiffferentFormatString(String str) {
		Date date = null;
		try {
			if (str != null && str.length() > 9) {
				// SimpleDateFormat dateformat = null;
				String s1 = null;
				if (str.length() == 11) {
					// dateformat = new SimpleDateFormat("dd-MMM-yyyy");
					s1 = str.subSequence(0, 11).toString();
				} else {
					// dateformat = new SimpleDateFormat("yyyy-MM-dd");
					s1 = str.subSequence(0, 10).toString();
				}

				date = sdf.parse(s1);
				date = convertStringToDate(convertDateToString(date));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return date;
	}

	public static LookUpDetailJson getLookUpDetailJson(LookUpDetails lookUpDetails) {
		LookUpDetailJson json = new LookUpDetailJson();
		if (lookUpDetails != null) {
			json.setDescription(lookUpDetails.getDescription());
			json.setLookupDetailId(lookUpDetails.getLookupDetailId());
			json.setParent(lookUpDetails.getParent());
			json.setLookupMasterId(lookUpDetails.getLookupMasterId());
		}
		return json;
	}

	// public static BankJson getBankJson(Banks banks) {
	// BankJson json = new BankJson();
	// json.setBankId(banks.getBankId());
	// json.setBankName(banks.getBankName());
	// return json;
	// }

	public static String convertDoubleToMoney(Double dbl) {
		String str = null;
		if (dbl != null) {
			Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			str = format.format(new BigDecimal(dbl));
		}
		return str;
	}

	public static String concateStringValues(String[] strArray) {
		if (strArray != null && strArray.length > 0) {
			String strValue = null;
			for (String str : strArray) {
				if (strValue == null) {
					strValue = str;
				} else {
					strValue += "," + str;
				}
			}
			return strValue;
		}
		return null;
	}

	public static String getInputStream(String fileName, String filePath) {
		String inputStreamToString = null;
		try {
			File initialFile = new File(filePath + "\\" + fileName);
			InputStream inputStream = new FileInputStream(initialFile);
			inputStreamToString = IOUtils.toString(inputStream, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	public static String[] getListOfStringsByIntArray(Integer[] listOfIds, Map<Integer, String> idWithDescriptionMap) {
		String[] strAmenities = null;
		if (listOfIds != null && listOfIds.length > 0) {
			strAmenities = new String[listOfIds.length];
			for (int i = 0; i < listOfIds.length; i++) {
				strAmenities[i] = idWithDescriptionMap.get(listOfIds[i]);
			}
		}
		return strAmenities;

	}

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && strDate.trim().length() > 0) {
				date = sdf.parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertStringToDate() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return date;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date) {
		String strDate = null;
		try {
			if (date != null) {
				strDate = sdf.format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return strDate;
	}

	public static CompanyJson getAllCompanyJsonByCompany(Company company) {
		CompanyJson companyJson = new CompanyJson();
		try {
			companyJson.setCin(company.getCin());
			companyJson.setCompanyId(company.getCompanyId());
			companyJson.setCompanyName(company.getCompanyName());
			companyJson.setCreatedOn(company.getCreatedOn());
			companyJson.setCst(company.getCst());
			companyJson.setTin(company.getTin());
			companyJson.setUpdatedOn(company.getUpdatedOn());

			if (company.getCompanyInfo() != null) {
				companyJson.setAddress1(company.getCompanyInfo().getAddress1());
				companyJson.setAddress2(company.getCompanyInfo().getAddress2());
				companyJson.setBoardNumber(company.getCompanyInfo().getBoardNumber());
				companyJson.setArea(company.getCompanyInfo().getArea());
				companyJson.setCity(company.getCompanyInfo().getCity());
				companyJson.setCompanyLogo(company.getCompanyInfo().getCompanyLogo());
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
			pfInfoJson.setStrRegistrationDate(CorpoMediaUtil.convertDateToString(pfInfo.getRegistrationDate()));
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
			esiInfoJson.setStrRegistrationDate(CorpoMediaUtil.convertDateToString(esiInfo.getRegistrationDate()));

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
		employeeJson.setStrDateOfJoining(convertDateToString(employee.getDateOfJoining()));
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

	public static EmployeePersonalInfoJson getEmployeePersonalInfoJson(EmployeeAddressInfo employeeAddressInfo, EmployeePersonalInfo employeePersonalInfo) {
		EmployeePersonalInfoJson employeePersonalInfoJson = new EmployeePersonalInfoJson();
		employeePersonalInfoJson.setCompanyId(employeePersonalInfo.getCompanyId());
		employeePersonalInfoJson.setEmployeeId(employeePersonalInfo.getEmployeeId());
		employeePersonalInfoJson.setMobileNumber(employeePersonalInfo.getMobileNumber());
		employeePersonalInfoJson.setGenderId(employeePersonalInfo.getGenderId());
		employeePersonalInfoJson.setEmployeePersonalInfoId(employeePersonalInfo.getEmployeePersonalInfoId());
		employeePersonalInfoJson.setStrDateOfBirth(convertDateToString(employeePersonalInfo.getDateOfBirth()));
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
		employeeExperienceInfoJson.setStrFromDate(convertDateToString(employeeExperienceInfo.getFromDate()));
		employeeExperienceInfoJson.setStrToDate(convertDateToString(employeeExperienceInfo.getToDate()));
		employeeExperienceInfoJson.setDescription(employeeExperienceInfo.getDescription());
		employeeExperienceInfoJson.setEmployeeExperienceInfoId(employeeExperienceInfo.getEmployeeExperienceInfoId());
		return employeeExperienceInfoJson;
	}

	public static EmployeeEducationalInfoJson getEmployeeEducationalInfoJson(EmployeeEducationalInfo employeeEducationalInfo) {
		EmployeeEducationalInfoJson employeeEducationalInfoJson = new EmployeeEducationalInfoJson();
		employeeEducationalInfoJson.setCompanyId(employeeEducationalInfo.getCompanyId());
		employeeEducationalInfoJson.setEmployeeId(employeeEducationalInfo.getEmployeeId());
		employeeEducationalInfoJson.setStrFromDate(convertDateToString(employeeEducationalInfo.getFromDate()));
		employeeEducationalInfoJson.setStrToDate(convertDateToString(employeeEducationalInfo.getToDate()));
		employeeEducationalInfoJson.setDegree(employeeEducationalInfo.getDegree());
		employeeEducationalInfoJson.setSpecialization(employeeEducationalInfo.getSpecialization());
		employeeEducationalInfoJson.setUniversity(employeeEducationalInfo.getUniversity());
		employeeEducationalInfoJson.setEmployeeEducationalInfoId(employeeEducationalInfo.getEmployeeEducationalInfoId());
		return employeeEducationalInfoJson;

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

	public static MedicalReimbursementJson getMedicalReimbursementJson(MedicalReimbursement medicalReimbursement) {
		MedicalReimbursementJson medicalReimbursementJson = new MedicalReimbursementJson();
		medicalReimbursementJson.setCompanyId(medicalReimbursement.getCompanyId());
		medicalReimbursementJson.setMaxAnnualLimit(medicalReimbursement.getMaxAnnualLimit());
		medicalReimbursementJson.setRequireSubmissionId(medicalReimbursement.getRequireSubmissionId());
		return medicalReimbursementJson;
	}

	public static TransportAllowanceJson getTransportAllowanceJson(TransportAllowance transportAllowance) {
		TransportAllowanceJson transportAllowanceJson = new TransportAllowanceJson();
		transportAllowanceJson.setCompanyId(transportAllowance.getCompanyId());
		transportAllowanceJson.setMaxAnnualLimit(transportAllowance.getMaxAnnualLimit());
		transportAllowanceJson.setRequireSubmissionId(transportAllowance.getRequireSubmissionId());
		return transportAllowanceJson;
	}

	public static ProfessionalAllowanceJson getProfessionalAllowanceJson(ProfessionalAllowance professionalAllowance) {
		ProfessionalAllowanceJson professionalAllowanceJson = new ProfessionalAllowanceJson();
		professionalAllowanceJson.setCompanyId(professionalAllowance.getCompanyId());
		professionalAllowanceJson.setMaxAnnualLimit(professionalAllowance.getMaxAnnualLimit());
		professionalAllowanceJson.setRequireSubmissionId(professionalAllowance.getRequireSubmissionId());
		return professionalAllowanceJson;
	}

	public static TravelReimbursementJson getTravelReimbursementJson(TravelReimbursement travelReimbursement) {
		TravelReimbursementJson travelReimbursementJson = new TravelReimbursementJson();
		travelReimbursementJson.setCompanyId(travelReimbursement.getCompanyId());
		travelReimbursementJson.setMaxAnnualLimit(travelReimbursement.getMaxAnnualLimit());
		travelReimbursementJson.setRequireSubmissionId(travelReimbursement.getRequireSubmissionId());
		return travelReimbursementJson;
	}

	public static FoodCouponsJson getFoodCouponsJson(FoodCoupons foodCoupons) {
		FoodCouponsJson foodCouponsJson = new FoodCouponsJson();
		foodCouponsJson.setCompanyId(foodCoupons.getCompanyId());
		foodCouponsJson.setMaxAnnualLimit(foodCoupons.getMaxAnnualLimit());
		foodCouponsJson.setRequireSubmissionId(foodCoupons.getRequireSubmissionId());
		return foodCouponsJson;
	}

	public static CityCompensatoryAllowanceJson getCityCompensatoryAllowanceJson(CityCompensatoryAllowance cityCompensatoryAllowance) {
		CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson = new CityCompensatoryAllowanceJson();
		cityCompensatoryAllowanceJson.setCompanyId(cityCompensatoryAllowance.getCompanyId());
		cityCompensatoryAllowanceJson.setMaxAnnualLimit(cityCompensatoryAllowance.getMaxAnnualLimit());
		cityCompensatoryAllowanceJson.setRequireSubmissionId(cityCompensatoryAllowance.getRequireSubmissionId());
		return cityCompensatoryAllowanceJson;
	}

	public static DailyAllowanceJson getDailyAllowanceJson(DailyAllowance dailyAllowance) {
		DailyAllowanceJson dailyAllowanceJson = new DailyAllowanceJson();
		dailyAllowanceJson.setCompanyId(dailyAllowance.getCompanyId());
		dailyAllowanceJson.setMaxAnnualLimit(dailyAllowance.getMaxAnnualLimit());
		dailyAllowanceJson.setRequireSubmissionId(dailyAllowance.getRequireSubmissionId());
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
}
