package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class RecordInsertionService {
	@Autowired
	private CommonRepository commonRepository;

	public void insertData() {
		List<?> list = TransformJsonToDomain.getLookup();
		for (Object object : list) {
			commonRepository.persist(object);
		}

		// List<Company> companyList =
		// TransformJsonToDomain.getCompanyFromJson();
		// for (Company company : companyList) {
		// commonRepository.persist(company);
		// CompanyInfo companyInfo =
		// TransformJsonToDomain.getCompanyInfoFromJson(company.getCompanyName());
		// companyInfo.setCompanyId(company.getCompanyId());
		// commonRepository.persist(companyInfo);
		// List<CompanySignator> companySignatorList =
		// TransformJsonToDomain.getCompanyCompanySignatorFromJson(company.getCompanyName());
		// for (CompanySignator companySignator : companySignatorList) {
		// companySignator.setCompanyId(company.getCompanyId());
		// commonRepository.persist(companySignator);
		// }
		// }
	}
}
