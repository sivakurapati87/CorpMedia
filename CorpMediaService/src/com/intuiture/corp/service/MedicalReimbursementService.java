package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.MedicalReimbursementRepository;
import com.intuiture.corp.entity.MedicalReimbursement;
import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class MedicalReimbursementService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private MedicalReimbursementRepository medicalReimbursementRepository;
	
	
	public Boolean saveMedicalReimbursement(MedicalReimbursementJson medicalReimbursementJson) {
		MedicalReimbursement medicalReimbursement = null;

		
		try {
			if (medicalReimbursementJson.getMedicalReimbursementId() != null) {
				medicalReimbursement = medicalReimbursementRepository.findbyId(medicalReimbursementJson.getMedicalReimbursementId());
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
	
	
	@SuppressWarnings("unchecked")
	public MedicalReimbursementJson getMedicalReimbursementList(Integer companyId) {
		MedicalReimbursementJson medicalReimbursementJson = null;
		try {
			List<MedicalReimbursement> medicalReimbursementList = (List<MedicalReimbursement>) commonRepository.getAllRecordsByCompanyId(companyId, MedicalReimbursement.class);
			if (medicalReimbursementList != null && medicalReimbursementList.size() > 0) {
				for (MedicalReimbursement medicalReimbursement : medicalReimbursementList) {
					medicalReimbursementJson =TransformDomainToJson.getMedicalReimbursementJson(medicalReimbursement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicalReimbursementJson;
	}

}
