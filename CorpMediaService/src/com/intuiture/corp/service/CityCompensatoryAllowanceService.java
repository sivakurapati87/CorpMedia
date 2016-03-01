package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.json.CityCompensatoryAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CityCompensatoryAllowanceService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveCityCompensatoryAllowance(CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson) {
		CityCompensatoryAllowance cityCompensatoryAllowance = null;

		try {
			if (cityCompensatoryAllowanceJson.getCityCompensatoryAllowanceId() != null) {
				cityCompensatoryAllowance = (CityCompensatoryAllowance) commonRepository.findById(cityCompensatoryAllowanceJson.getCityCompensatoryAllowanceId(), CityCompensatoryAllowance.class);
			} else {
				cityCompensatoryAllowance = new CityCompensatoryAllowance();
			}
			TransformJsonToDomain.getCityCompensatoryAllowance(cityCompensatoryAllowance, cityCompensatoryAllowanceJson);
			if (cityCompensatoryAllowanceJson.getCityCompensatoryAllowanceId() != null) {
				commonRepository.update(cityCompensatoryAllowance);
			} else {
				commonRepository.persist(cityCompensatoryAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public CityCompensatoryAllowanceJson getCityCompensatoryAllowanceList(Integer companyId) {
		CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson = null;
		try {
			List<CityCompensatoryAllowance> cityCompensatoryAllowanceList = (List<CityCompensatoryAllowance>) commonRepository.getAllRecordsByCompanyId(companyId, CityCompensatoryAllowance.class);
			if (cityCompensatoryAllowanceList != null && cityCompensatoryAllowanceList.size() > 0) {
				for (CityCompensatoryAllowance cityCompensatoryAllowance : cityCompensatoryAllowanceList) {
					cityCompensatoryAllowanceJson =TransformDomainToJson.getCityCompensatoryAllowanceJson(cityCompensatoryAllowance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cityCompensatoryAllowanceJson;
	}
	
	

}
