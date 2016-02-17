package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CompanySignatorRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanySignatorService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanySignatorRepository cmpSignatorRepository;

	public Boolean saveSignatory(CompanySignatorJson companySignatorJson) {
		CompanySignator companySignator = null;
		try {
			if (companySignatorJson.getCompanySignatorId() != null) {
				companySignator = cmpSignatorRepository.findById(companySignatorJson.getCompanySignatorId());
			} else {
				companySignator = new CompanySignator();
			}
			TransformJsonToDomain.getCmpSignatorByJson(companySignatorJson, companySignator);
			if (companySignatorJson.getCompanySignatorId() != null) {
				commonRepository.update(companySignator);
			} else {
				commonRepository.persist(companySignator);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
