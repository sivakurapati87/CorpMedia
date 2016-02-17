package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyLocationRepository;
import com.intuiture.corp.entity.CompanyLocation;
import com.intuiture.corp.json.CompanyLocationJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyLocationService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyLocationRepository companyLocationRepository;

	public Boolean saveLocation(CompanyLocationJson companyLocationJson) {
		CompanyLocation companyLocation = null;
		try {
			if (companyLocationJson.getCompanyLocationId() != null) {
				companyLocation = companyLocationRepository.findById(companyLocationJson.getCompanyLocationId());
			} else {
				companyLocation = new CompanyLocation();
			}
			TransformJsonToDomain.getCompanyLocation(companyLocation, companyLocationJson);
			if (companyLocationJson.getCompanyLocationId() != null) {
				commonRepository.update(companyLocation);
			} else {
				commonRepository.persist(companyLocation);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
