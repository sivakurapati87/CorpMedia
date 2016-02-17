package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyBankRepository;
import com.intuiture.corp.entity.CompanyBanks;
import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyBankService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyBankRepository companyBankRepository;

	public Boolean saveBank(CompanyBankJson companyBankJson) {
		CompanyBanks companyBanks = null;
		try {
			if (companyBankJson.getCompanyBankId() != null) {
				companyBanks = companyBankRepository.getCompanyBanksById(companyBankJson.getCompanyBankId());
			} else {
				companyBanks = new CompanyBanks();
			}
			TransformJsonToDomain.getCmpBanksByJson(companyBanks, companyBankJson);
			if (companyBankJson.getCompanyBankId() != null) {
				commonRepository.update(companyBanks);
			} else {
				commonRepository.persist(companyBanks);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
