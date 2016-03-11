package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Shifts;
import com.intuiture.corp.json.ShiftsJson;
import com.intuiture.corp.util.TransformDomainToJson;
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
	
	@SuppressWarnings("unchecked")
	public List<ShiftsJson> getAllShiftsList(Integer companyId) {
		List<ShiftsJson> shiftsJsonList = null;
		try {
			List<Shifts> shiftsList = (List<Shifts>) commonRepository.getAllRecordsByCompanyId(companyId, Shifts.class);
			if (shiftsList != null && shiftsList.size() > 0) {
				shiftsJsonList = new ArrayList<ShiftsJson>();
				for (Shifts shifts  : shiftsList) {
					shiftsJsonList.add(TransformDomainToJson.getShiftsJson(shifts));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shiftsJsonList;
	}
	
	
	public  Boolean deleteShift(Integer shiftsId) {
		try {
			Shifts shifts= (Shifts) commonRepository.findById(shiftsId, Shifts.class);
			if (shifts != null) {
				shifts.setIsDeleted(Boolean.TRUE);
				commonRepository.update(shifts);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
