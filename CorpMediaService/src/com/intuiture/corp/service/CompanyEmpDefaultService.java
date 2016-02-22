package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.CompanyEmployeeDefaults;
import com.intuiture.corp.json.CompanyEmployeeDefaultsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyEmpDefaultService {
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveCompanyEmpDefault(CompanyEmployeeDefaultsJson companyEmployeeDefaultsJson) {
		CompanyEmployeeDefaults companyEmployeeDefaults = null;
		try {
			if (companyEmployeeDefaultsJson.getCompanyEmployeeDefaultsId() != null) {
				companyEmployeeDefaults = (CompanyEmployeeDefaults) commonRepository.findById(companyEmployeeDefaultsJson.getCompanyEmployeeDefaultsId(), CompanyEmployeeDefaults.class);
			} else {
				companyEmployeeDefaults = new CompanyEmployeeDefaults();
			}
			TransformJsonToDomain.getCompanyEmployeeDefaults(companyEmployeeDefaults, companyEmployeeDefaultsJson);
			if (companyEmployeeDefaultsJson.getCompanyEmployeeDefaultsId() != null) {
				commonRepository.update(companyEmployeeDefaults);
			} else {
				commonRepository.persist(companyEmployeeDefaults);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public CompanyEmployeeDefaultsJson getCompanyEmpDefault(Integer companyId) {
		CompanyEmployeeDefaultsJson companyEmployeeDefaultsJson = null;
		try {
			CompanyEmployeeDefaults companyEmployeeDefaults = (CompanyEmployeeDefaults) commonRepository.getRecordByCompanyId(companyId, CompanyEmployeeDefaults.class);
			if (companyEmployeeDefaults != null) {
				companyEmployeeDefaultsJson = TransformDomainToJson.getCompanyEmployeeDefaults(companyEmployeeDefaults);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyEmployeeDefaultsJson;
	}
}
