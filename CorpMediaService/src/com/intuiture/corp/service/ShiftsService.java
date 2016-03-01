package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Shifts;
import com.intuiture.corp.json.ShiftsJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ShiftsService {
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveShift(ShiftsJson shiftsJson) {
		Shifts shifts = null;

		try {
			if (shiftsJson.getShiftsId() != null) {
				shifts = (Shifts) commonRepository.findById(shiftsJson.getShiftsId(), Shifts.class);
			} else {
				shifts = new Shifts();
			}
			TransformJsonToDomain.getShifts(shifts,shiftsJson);
			if (shiftsJson.getShiftsId() != null) {
				commonRepository.update(shifts);
			} else {
				commonRepository.persist(shifts);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
