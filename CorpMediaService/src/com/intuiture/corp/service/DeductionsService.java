package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.DeductionsRepository;
import com.intuiture.corp.entity.Deductions;
import com.intuiture.corp.json.DeductionsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class DeductionsService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private DeductionsRepository deductionsRepository;
	
	
	public Boolean saveDeductions(DeductionsJson deductionsJson) {
		Deductions deductions = null;

		
		try {
			if (deductionsJson.getDeductionId() != null) {
				deductions = deductionsRepository.findbyId(deductionsJson.getDeductionId());
			} else {
				deductions = new Deductions();
			}
			TransformJsonToDomain.getDeductions(deductions, deductionsJson);
			if (deductionsJson.getDeductionId() != null) {
				commonRepository.update(deductions);
			} else {
				commonRepository.persist(deductions);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DeductionsJson> getAllDeductionsList(Integer companyId) {
		List<DeductionsJson> deductionsJsonList = null;
		try {
			List<Deductions> deductionsList = (List<Deductions>) commonRepository.getAllRecordsByCompanyId(companyId, Deductions.class);
			if (deductionsList != null && deductionsList.size() > 0) {
				deductionsJsonList = new ArrayList<DeductionsJson>();
				for (Deductions deductions : deductionsList) {
					deductionsJsonList.add(TransformDomainToJson.getDeductionsJson(deductions));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deductionsJsonList;
	}
	
	public Boolean deleteDeductions(Integer deductionId) {
		try {
			Deductions deductions = (Deductions) commonRepository.findById(deductionId, Deductions.class);
			if (deductions != null) {
				deductions.setIsDeleted(Boolean.TRUE);
				commonRepository.update(deductions);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	

}
