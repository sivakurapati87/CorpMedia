package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.ReimbursementRepository;
import com.intuiture.corp.entity.Reimbursement;
import com.intuiture.corp.json.ReimbursementJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ReimbursementService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private ReimbursementRepository reimbursementRepository;
	
	
	public Boolean saveReimbursement(ReimbursementJson reimbursementJson) {
		Reimbursement reimbursement = null;

		
		try {
			if (reimbursementJson.getReimbursementId() != null) {
				reimbursement = reimbursementRepository.findbyId(reimbursementJson.getReimbursementId());
			} else {
				reimbursement = new Reimbursement();
			}
			TransformJsonToDomain.getReimbursement(reimbursement, reimbursementJson);
			if (reimbursementJson.getReimbursementId() != null) {
				commonRepository.update(reimbursement);
			} else {
				commonRepository.persist(reimbursement);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReimbursementJson> getAllReimbursementList(Integer companyId) {
		List<ReimbursementJson> reimbursementJsonList = null;
		try {
			List<Reimbursement> reimbursementList = (List<Reimbursement>) commonRepository.getAllRecordsByCompanyId(companyId, Reimbursement.class);
			if (reimbursementList != null && reimbursementList.size() > 0) {
				reimbursementJsonList = new ArrayList<ReimbursementJson>();
				for (Reimbursement reimbursement : reimbursementList) {
					reimbursementJsonList.add(TransformDomainToJson.getReimbursementJson(reimbursement));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursementJsonList;
	}
	
	public Boolean deleteReimbursement(Integer reimbursementId) {
		try {
			Reimbursement reimbursement = (Reimbursement) commonRepository.findById(reimbursementId, Reimbursement.class);
			if (reimbursement != null) {
				reimbursement.setIsDeleted(Boolean.TRUE);
				commonRepository.update(reimbursement);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
