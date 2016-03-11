package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.DailyAllowanceRepository;
import com.intuiture.corp.entity.DailyAllowance;
import com.intuiture.corp.json.DailyAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class DailyAllowanceService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveDailyAllowance(DailyAllowanceJson dailyAllowanceJson) {
		DailyAllowance dailyAllowance = null;

		try {
			if (dailyAllowanceJson.getDailyAllowanceId() != null) {
				dailyAllowance = (DailyAllowance) commonRepository.findById(dailyAllowanceJson.getDailyAllowanceId(), DailyAllowance.class);
			} else {
				dailyAllowance = new DailyAllowance();
			}
			TransformJsonToDomain.getDailyAllowance(dailyAllowance, dailyAllowanceJson);
			if (dailyAllowanceJson.getDailyAllowanceId() != null) {
				commonRepository.update(dailyAllowance);
			} else {
				commonRepository.persist(dailyAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public DailyAllowanceJson getDailyAllowanceList(Integer companyId) {
		DailyAllowanceJson dailyAllowanceJson = null;
		try {
			DailyAllowance dailyAllowance = (DailyAllowance) commonRepository.getRecordByCompanyId(companyId, DailyAllowance.class);
			if (dailyAllowance != null) {
				dailyAllowanceJson = TransformDomainToJson.getDailyAllowanceJson(dailyAllowance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyAllowanceJson;
	}

}
