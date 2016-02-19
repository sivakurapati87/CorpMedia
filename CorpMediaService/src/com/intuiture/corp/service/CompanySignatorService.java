package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanySignatorRepository;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.util.TransformDomainToJson;
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

	@SuppressWarnings("unchecked")
	public List<CompanySignatorJson> getAllSignatoriesList(Integer companyId) {
		List<CompanySignatorJson> signatorJsonList = null;
		try {
			List<CompanySignator> companySignatorList = (List<CompanySignator>) commonRepository.getAllRecordsByCompanyId(companyId, CompanySignator.class);
			if (companySignatorList != null && companySignatorList.size() > 0) {
				signatorJsonList = new ArrayList<CompanySignatorJson>();
				for (CompanySignator companySignator : companySignatorList) {
					signatorJsonList.add(TransformDomainToJson.getCompanySignatorJson(companySignator));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signatorJsonList;
	}

	public Boolean deleteSignator(Integer companySignatorId) {
		try {
			CompanySignator companySignator = cmpSignatorRepository.findById(companySignatorId);
			if (companySignator != null) {
				companySignator.setIsDeleted(Boolean.TRUE);
				commonRepository.update(companySignator);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
