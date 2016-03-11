package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.MedicalReimbursement;
import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class MedicalReimbursementService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveMedicalReimbursement(MedicalReimbursementJson medicalReimbursementJson) {
		MedicalReimbursement medicalReimbursement = null;

		try {
			if (medicalReimbursementJson.getMedicalReimbursementId() != null) {
				medicalReimbursement = (MedicalReimbursement) commonRepository.findById(medicalReimbursementJson.getMedicalReimbursementId(), MedicalReimbursement.class);
			} else {
				medicalReimbursement = new MedicalReimbursement();
			}
			TransformJsonToDomain.getMedicalReimbursement(medicalReimbursement, medicalReimbursementJson);
			if (medicalReimbursementJson.getMedicalReimbursementId() != null) {
				commonRepository.update(medicalReimbursement);
			} else {
				commonRepository.persist(medicalReimbursement);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public MedicalReimbursementJson getMedicalReimbursementList(Integer companyId) {
		MedicalReimbursementJson medicalReimbursementJson = null;
		try {
			MedicalReimbursement medicalReimbursement = (MedicalReimbursement) commonRepository.getRecordByCompanyId(companyId, MedicalReimbursement.class);
			if (medicalReimbursement != null) {
				medicalReimbursementJson = TransformDomainToJson.getMedicalReimbursementJson(medicalReimbursement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicalReimbursementJson;
	}

}
