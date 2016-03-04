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
	@Autowired
	private TravelReimbursementRepository travelReimbursementRepository;
	
	
	
	public Boolean saveTravelReimbursement(TravelReimbursementJson travelReimbursementJson) {
		TravelReimbursement travelReimbursement = null;

		
		try {
			if (travelReimbursementJson.getTravelReimbursementId() != null) {
				travelReimbursement = travelReimbursementRepository.findbyId(travelReimbursementJson.getTravelReimbursementId());
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
	
	@SuppressWarnings("unchecked")
	public TravelReimbursementJson getTravelReimbursementList(Integer companyId) {
		TravelReimbursementJson travelReimbursementJson = null;
		try {
			List<TravelReimbursement> travelReimbursementList = (List<TravelReimbursement>) commonRepository.getAllRecordsByCompanyId(companyId, TravelReimbursement.class);
			if (travelReimbursementList != null && travelReimbursementList.size() > 0) {
				for (TravelReimbursement travelReimbursement : travelReimbursementList) {
					travelReimbursementJson =TransformDomainToJson.getTravelReimbursementJson(travelReimbursement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelReimbursementJson;
	}
	
	

}
