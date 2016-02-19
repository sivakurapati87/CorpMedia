package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyBankRepository;
import com.intuiture.corp.entity.CompanyBanks;
import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.util.TransformDomainToJson;
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
				companyBanks = (CompanyBanks) commonRepository.findById(companyBankJson.getCompanyBankId(), CompanyBanks.class);
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

	@SuppressWarnings("unchecked")
	public List<CompanyBankJson> getAllSignatoriesList(Integer companyId) {
		List<CompanyBankJson> companyBankJsonList = null;
		try {
			List<CompanyBanks> companySignatorList = (List<CompanyBanks>) commonRepository.getAllRecordsByCompanyId(companyId, CompanyBanks.class);
			if (companySignatorList != null && companySignatorList.size() > 0) {
				companyBankJsonList = new ArrayList<CompanyBankJson>();
				for (CompanyBanks companyBanks : companySignatorList) {
					companyBankJsonList.add(TransformDomainToJson.getCompanyBankJson(companyBanks));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyBankJsonList;
	}

	public Boolean deleteBank(Integer companyBankId) {
		try {
			CompanyBanks companyBanks = (CompanyBanks) commonRepository.findById(companyBankId, CompanyBanks.class);
			if (companyBanks != null) {
				companyBanks.setIsDeleted(Boolean.TRUE);
				commonRepository.update(companyBanks);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
