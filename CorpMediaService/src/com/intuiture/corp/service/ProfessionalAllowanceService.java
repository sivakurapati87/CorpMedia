package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ProfessionalAllowanceService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveProfessionalAllowance(ProfessionalAllowanceJson professionalAllowanceJson) {
		ProfessionalAllowance professionalAllowance = null;

		try {
			if (professionalAllowanceJson.getProfessionalAllowanceId() != null) {
				professionalAllowance = (ProfessionalAllowance) commonRepository.findById(professionalAllowanceJson.getProfessionalAllowanceId(), ProfessionalAllowance.class);
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

	public ProfessionalAllowanceJson getProfessionalAllowanceList(Integer companyId) {
		ProfessionalAllowanceJson professionalAllowanceJson = null;
		try {
			ProfessionalAllowance professionalAllowance = (ProfessionalAllowance) commonRepository.getRecordByCompanyId(companyId, ProfessionalAllowance.class);
			if (professionalAllowance != null) {
				professionalAllowanceJson = TransformDomainToJson.getProfessionalAllowanceJson(professionalAllowance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalAllowanceJson;
	}

}
