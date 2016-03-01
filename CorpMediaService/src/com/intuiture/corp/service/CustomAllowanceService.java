package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CustomAllowanceRepository;
import com.intuiture.corp.entity.CustomAllowance;
import com.intuiture.corp.json.CustomAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CustomAllowanceService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CustomAllowanceRepository customAllowanceRepository;
	
	
	
	public Boolean saveCustomAllowance(CustomAllowanceJson customAllowanceJson) {
		CustomAllowance customAllowance = null;

		
		try {
			if (customAllowanceJson.getCustomAllowanceId() != null) {
				customAllowance = customAllowanceRepository.findbyId(customAllowanceJson.getCustomAllowanceId());
			} else {
				customAllowance = new CustomAllowance();
			}
			TransformJsonToDomain.getCustomAllowance(customAllowance, customAllowanceJson);
			if (customAllowanceJson.getCustomAllowanceId() != null) {
				commonRepository.update(customAllowance);
			} else {
				commonRepository.persist(customAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CustomAllowanceJson> getAllCustomAllowanceList(Integer companyId) {
		List<CustomAllowanceJson> customAllowanceJsonList = null;
		try {
			List<CustomAllowance> customAllowanceList = (List<CustomAllowance>) commonRepository.getAllRecordsByCompanyId(companyId, CustomAllowance.class);
			if (customAllowanceList != null && customAllowanceList.size() > 0) {
				customAllowanceJsonList = new ArrayList<CustomAllowanceJson>();
				for (CustomAllowance customAllowance : customAllowanceList) {
					customAllowanceJsonList.add(TransformDomainToJson.getCustomAllowanceJson(customAllowance));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customAllowanceJsonList;
	}
	
	
	public Boolean deleteCustomAllowance(Integer customAllowanceId) {
		try {
			CustomAllowance customAllowance = (CustomAllowance) commonRepository.findById(customAllowanceId, CustomAllowance.class);
			if (customAllowance != null) {
				customAllowance.setIsDeleted(Boolean.TRUE);
				commonRepository.update(customAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
