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

	public List<CompanyJson> getCompanyInfo(String compName) {
		List<CompanyJson> companyJsonList = new ArrayList<CompanyJson>();
		List<Company> companiesList = companyRepository.getCompanyInfo(compName.trim());
		if (companiesList != null && companiesList.size() > 0) {
			List<Integer> companyIds = new ArrayList<Integer>();
			for (Company company : companiesList) {
				companyIds.add(company.getCompanyId());
			}
			// List<CompanySignator> companySignatorList =
			// companyRepository.getCompanySignatorsByCompanyId(companyIds);

			for (Company company : companiesList) {
				CompanyJson companyJson = TransformDomainToJson.getAllCompanyJsonByCompany(company);
				// if (companySignatorList != null && companySignatorList.size()
				// > 0) {
				// List<CompanySignatorJson> companySignatorJsonsList = new
				// ArrayList<CompanySignatorJson>();
				// for (CompanySignator signator : companySignatorList) {
				// CompanySignatorJson companySignatorJson =
				// TransformDomainToJson.getCompanySignatorJson(signator);
				// companySignatorJsonsList.add(companySignatorJson);
				// }
				// companyJson.setCompanySignatorJsonsList(companySignatorJsonsList);
				// }
				companyJsonList.add(companyJson);
			}
		}
		return companyJsonList;
	}
}
