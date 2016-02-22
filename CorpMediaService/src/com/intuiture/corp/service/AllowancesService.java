package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.AllowancesRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Allowances;
import com.intuiture.corp.json.AllowancesJson;
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

}
