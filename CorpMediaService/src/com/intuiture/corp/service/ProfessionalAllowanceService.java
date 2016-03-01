package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.ProfessionalAllowanceRepository;
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ProfessionalAllowanceService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private ProfessionalAllowanceRepository professionalAllowanceRepository;
	
	
	
	public Boolean saveProfessionalAllowance(ProfessionalAllowanceJson professionalAllowanceJson) {
		ProfessionalAllowance professionalAllowance = null;

		
		try {
			if (professionalAllowanceJson.getProfessionalAllowanceId() != null) {
				professionalAllowance = professionalAllowanceRepository.findbyId(professionalAllowanceJson.getProfessionalAllowanceId());
			} else {
				professionalAllowance = new ProfessionalAllowance();
			}
			TransformJsonToDomain.getProfessionalAllowance(professionalAllowance, professionalAllowanceJson);
			if (professionalAllowanceJson.getProfessionalAllowanceId() != null) {
				commonRepository.update(professionalAllowance);
			} else {
				commonRepository.persist(professionalAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public ProfessionalAllowanceJson getProfessionalAllowanceList(Integer companyId) {
		ProfessionalAllowanceJson professionalAllowanceJson = null;
		try {
			List<ProfessionalAllowance> professionalAllowanceList = (List<ProfessionalAllowance>) commonRepository.getAllRecordsByCompanyId(companyId, ProfessionalAllowance.class);
			if (professionalAllowanceList != null && professionalAllowanceList.size() > 0) {
				for (ProfessionalAllowance professionalAllowance : professionalAllowanceList) {
					professionalAllowanceJson =TransformDomainToJson.getProfessionalAllowanceJson(professionalAllowance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalAllowanceJson;
	}
	

}
