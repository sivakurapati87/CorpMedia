package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.BonusesRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Bonuses;
import com.intuiture.corp.json.BonusesJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class BonusesService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private BonusesRepository bonusesRepository;
	
	
	public Boolean saveBonuses(BonusesJson bonusesJson) {
		Bonuses bonuses = null;

		
		try {
			if (bonusesJson.getBonusesId() != null) {
				bonuses = bonusesRepository.findbyId(bonusesJson.getBonusesId());
			} else {
				bonuses = new Bonuses();
			}
			TransformJsonToDomain.getBonuses(bonuses, bonusesJson);
			if (bonusesJson.getBonusesId() != null) {
				commonRepository.update(bonuses);
			} else {
				commonRepository.persist(bonuses);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<BonusesJson> getAllBonusesList(Integer companyId) {
		List<BonusesJson> bonusesJsonList = null;
		try {
			List<Bonuses> bonusesList = (List<Bonuses>) commonRepository.getAllRecordsByCompanyId(companyId, Bonuses.class);
			if (bonusesList != null && bonusesList.size() > 0) {
				bonusesJsonList = new ArrayList<BonusesJson>();
				for (Bonuses bonuses : bonusesList) {
					bonusesJsonList.add(TransformDomainToJson.getBonusesJson(bonuses));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bonusesJsonList;
	}

}
