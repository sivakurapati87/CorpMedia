package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyLocationRepository;
import com.intuiture.corp.entity.CompanyLocation;
import com.intuiture.corp.json.CompanyLocationJson;
import com.intuiture.corp.util.TransformDomainToJson;
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
				companyLocation = (CompanyLocation) commonRepository.findById(companyLocationJson.getCompanyLocationId(), CompanyLocation.class);
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

	@SuppressWarnings("unchecked")
	public List<CompanyLocationJson> getAllLocationList(Integer companyId) {
		List<CompanyLocationJson> companyLocationJsonList = null;
		try {
			List<CompanyLocation> companyLocationsList = (List<CompanyLocation>) commonRepository.getAllRecordsByCompanyId(companyId, CompanyLocation.class);
			if (companyLocationsList != null && companyLocationsList.size() > 0) {
				companyLocationJsonList = new ArrayList<CompanyLocationJson>();
				for (CompanyLocation companyLocation : companyLocationsList) {
					companyLocationJsonList.add(TransformDomainToJson.getCompanyLocationJson(companyLocation));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyLocationJsonList;
	}

	public Boolean deleteLocation(Integer companyLocationId) {
		try {
			CompanyLocation companyLocation = (CompanyLocation) commonRepository.findById(companyLocationId, CompanyLocation.class);
			if (companyLocation != null) {
				companyLocation.setIsDeleted(Boolean.TRUE);
				commonRepository.update(companyLocation);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
