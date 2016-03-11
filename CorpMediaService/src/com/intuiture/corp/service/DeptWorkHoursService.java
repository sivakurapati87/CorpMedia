package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.DeptWorkHours;
import com.intuiture.corp.json.DeptWorkHoursJson;
import com.intuiture.corp.util.TransformJsonToDomain;


@Service
@Transactional
public class DeptWorkHoursService {
	@Autowired
	private CommonRepository commonRepository;

	
	public Boolean saveDeptWorkHours(DeptWorkHoursJson deptWorkHoursJson) {
		DeptWorkHours deptWorkHours = null;

		try {
			if (deptWorkHoursJson.getDeptWorkHourId() != null) {
				deptWorkHours = (DeptWorkHours) commonRepository.findById(deptWorkHoursJson.getDeptWorkHourId(), DeptWorkHours.class);
			} else {
				deptWorkHours = new DeptWorkHours();
			}
			TransformJsonToDomain.getDeptWorkHours(deptWorkHours, deptWorkHoursJson);
			if (deptWorkHoursJson.getDeptWorkHourId() != null) {
				commonRepository.update(deptWorkHours);
			} else {
				commonRepository.persist(deptWorkHours);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
