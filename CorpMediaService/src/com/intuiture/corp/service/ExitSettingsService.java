package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.ExitSettings;
import com.intuiture.corp.json.ExitSettingsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ExitSettingsService {
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveExitSettings(ExitSettingsJson exitSettingsJson) {
		ExitSettings exitSettings = null;
		try {
			if (exitSettingsJson.getExitSettingsId() != null) {
				exitSettings = (ExitSettings) commonRepository.findById(exitSettingsJson.getExitSettingsId(), ExitSettings.class);
			} else {
				exitSettings = new ExitSettings();
			}
			TransformJsonToDomain.getExitSettings(exitSettings, exitSettingsJson);
			if (exitSettingsJson.getExitSettingsId() != null) {
				commonRepository.update(exitSettings);
			} else {
				commonRepository.persist(exitSettings);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<ExitSettingsJson> getAllExitSettingsList(Integer companyId) {
		List<ExitSettingsJson> exitSettingsJsonList = null;
		try {
			List<ExitSettings> exitSettingsList = (List<ExitSettings>) commonRepository.getAllRecordsByCompanyId(companyId, ExitSettings.class);
			if (exitSettingsList != null && exitSettingsList.size() > 0) {
				exitSettingsJsonList = new ArrayList<ExitSettingsJson>();
				for (ExitSettings exitSettings : exitSettingsList) {
					exitSettingsJsonList.add(TransformDomainToJson.getExitSettingsJson(exitSettings));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exitSettingsJsonList;
	}
	
	public Boolean deleteExitSettings(Integer exitSettingsId) {
		try {
			ExitSettings exitSettings = (ExitSettings) commonRepository.findById(exitSettingsId, ExitSettings.class);
			if (exitSettings != null) {
				exitSettings.setIsDeleted(Boolean.TRUE);
				commonRepository.update(exitSettings);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
