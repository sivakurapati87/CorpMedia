package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.CompanyClientWorkHours;
import com.intuiture.corp.json.ClientWorkHoursJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ClientWorkHoursService {
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveClientworkHours(ClientWorkHoursJson clientWorkHoursJson) {
		CompanyClientWorkHours clientWorkHours = null;

		try {
			if (clientWorkHoursJson.getClientWorkHourId() != null) {
				clientWorkHours = (CompanyClientWorkHours) commonRepository.findById(clientWorkHoursJson.getClientWorkHourId(), CompanyClientWorkHours.class);
			} else {
				clientWorkHours = new CompanyClientWorkHours();
			}
			TransformJsonToDomain.getClientWorkHours(clientWorkHours, clientWorkHoursJson);
			if (clientWorkHoursJson.getClientWorkHourId() != null) {
				commonRepository.update(clientWorkHours);
			} else {
				commonRepository.persist(clientWorkHours);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
