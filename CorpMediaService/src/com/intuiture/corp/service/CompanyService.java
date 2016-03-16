package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyRepository;
import com.intuiture.corp.entity.Company;
import com.intuiture.corp.json.CompanyJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyRepository companyRepository;

	public List<CompanyJson> findAllCompanies() {
		List<CompanyJson> companyJsonList = new ArrayList<CompanyJson>();
		List<Company> companiesList = (List<Company>) companyRepository.getAllRecords();
		if (companiesList != null && companiesList.size() > 0) {
			for (Company company : companiesList) {
				CompanyJson companyJson = TransformDomainToJson.getAllCompanyJsonByCompany(company);
				companyJsonList.add(companyJson);
			}
		}
		return companyJsonList;
	}

	public CompanyJson getCompanyInfoByCompanyId(Integer companyId) {
		CompanyJson companyJson = null;
		Company company = (Company) commonRepository.getRecordByCompanyId(companyId, Company.class);
		if (company != null) {
			companyJson = TransformDomainToJson.getAllCompanyJsonByCompany(company);
		}
		return companyJson;
	}

	public List<CompanyJson> findCompanyByName(String compName) {
		List<CompanyJson> companyJsonList = new ArrayList<CompanyJson>();
		List<Company> companiesList = companyRepository.findCompanyByName(compName.trim());
		if (companiesList != null && companiesList.size() > 0) {
			List<Integer> companyIds = new ArrayList<Integer>();
			for (Company company : companiesList) {
				companyIds.add(company.getCompanyId());
			}
			for (Company company : companiesList) {
				CompanyJson companyJson = TransformDomainToJson.getAllCompanyJsonByCompany(company);
				companyJsonList.add(companyJson);
			}
		}
		return companyJsonList;
	}

	public CompanyJson saveCompanyGeneralInfo(CompanyJson companyJson) {
		Company company = null;
		try {
			if (companyJson.getCompanyId() != null) {
				company = (Company) commonRepository.findById(companyJson.getCompanyId(), Company.class);
			} else {
				company = new Company();
			}
			TransformJsonToDomain.getCompanyInfo(company, companyJson);
			if (companyJson.getCompanyId() != null) {
				commonRepository.update(company);
			} else {
				commonRepository.persist(company);
			}
			companyJson = TransformDomainToJson.getAllCompanyJsonByCompany(company);
		} catch (Exception e) {
		}
		return companyJson;
	}

}
