package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TravelReimbursementRepository;
import com.intuiture.corp.entity.TravelReimbursement;
import com.intuiture.corp.json.TravelReimbursementJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TravelReimbursementService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveTravelReimbursement(TravelReimbursementJson travelReimbursementJson) {
		TravelReimbursement travelReimbursement = null;

		try {
			if (travelReimbursementJson.getTravelReimbursementId() != null) {
				travelReimbursement = (TravelReimbursement) commonRepository.findById(travelReimbursementJson.getTravelReimbursementId(), TravelReimbursement.class);
			} else {
				travelReimbursement = new TravelReimbursement();
			}
			TransformJsonToDomain.getTravelReimbursement(travelReimbursement, travelReimbursementJson);
			if (travelReimbursementJson.getTravelReimbursementId() != null) {
				commonRepository.update(travelReimbursement);
			} else {
				commonRepository.persist(travelReimbursement);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public TravelReimbursementJson getTravelReimbursementList(Integer companyId) {
		TravelReimbursementJson travelReimbursementJson = null;
		try {
			TravelReimbursement travelReimbursement = (TravelReimbursement) commonRepository.getRecordByCompanyId(companyId, TravelReimbursement.class);
			if (travelReimbursement != null) {
				travelReimbursementJson = TransformDomainToJson.getTravelReimbursementJson(travelReimbursement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelReimbursementJson;
	}

}
