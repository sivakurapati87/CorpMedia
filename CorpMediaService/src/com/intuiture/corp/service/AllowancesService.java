package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.AllowancesRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Allowances;
import com.intuiture.corp.json.AllowancesJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class AllowancesService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private AllowancesRepository allowancesRepository;
	
	
	public Boolean saveAllowances(AllowancesJson allowancesJson) {
		Allowances allowances = null;

		
		try {
			if (allowancesJson.getAllowancesId() != null) {
				allowances = allowancesRepository.findbyId(allowancesJson.getAllowancesId());
			} else {
				allowances = new Allowances();
			}
			TransformJsonToDomain.getAllowances(allowances, allowancesJson);
			if (allowancesJson.getAllowancesId() != null) {
				commonRepository.update(allowances);
			} else {
				commonRepository.persist(allowances);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<AllowancesJson> getAllAllowancesList(Integer companyId) {
		List<AllowancesJson> allowancesJsonList = null;
		try {
			List<Allowances> allowancesList = (List<Allowances>) commonRepository.getAllRecordsByCompanyId(companyId, Allowances.class);
			if (allowancesList != null && allowancesList.size() > 0) {
				allowancesJsonList = new ArrayList<AllowancesJson>();
				for (Allowances allowances : allowancesList) {
					allowancesJsonList.add(TransformDomainToJson.getAllowancesJson(allowances));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allowancesJsonList;
	}
	
	
	public Boolean deleteAllowances(Integer allowancesId) {
		try {
			Allowances allowances = (Allowances) commonRepository.findById(allowancesId, Allowances.class);
			if (allowances != null) {
				allowances.setIsDeleted(Boolean.TRUE);
				commonRepository.update(allowances);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
