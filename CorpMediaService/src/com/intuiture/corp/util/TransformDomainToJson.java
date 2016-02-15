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

import com.intuiture.corp.entity.Banks;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.json.BankJson;
import com.intuiture.corp.json.CompanyJson;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.json.PFInfoJson;

public class TransformDomainToJson {
	private static Logger LOG = Logger.getLogger(TransformDomainToJson.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

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
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = str.subSequence(0, 10).toString();
				date = dateformat.parse(s1);
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

	public static BankJson getBankJson(Banks banks) {
		BankJson json = new BankJson();
		json.setBankId(banks.getBankId());
		json.setBankName(banks.getBankName());
		return json;
	}

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

}
