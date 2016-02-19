package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.GeneralSettingsRepository;
import com.intuiture.corp.entity.GeneralSettings;
import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class GeneralSettingsService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private GeneralSettingsRepository generalSettingsRepository;

	public Boolean saveGeneralSettings(GeneralSettingsJson generalSettingsJson) {
		GeneralSettings generalSettings = null;
		try {
			if (generalSettingsJson.getGeneralsettingsId() != null) {
				generalSettings = (GeneralSettings) commonRepository.findById(generalSettingsJson.getGeneralsettingsId(), GeneralSettings.class);
			} else {
				generalSettings = new GeneralSettings();
			}
			TransformJsonToDomain.getTimeSheetGeneralSettings(generalSettings, generalSettingsJson);
			if (generalSettingsJson.getGeneralsettingsId() != null) {
				commonRepository.update(generalSettings);
			} else {
				commonRepository.persist(generalSettings);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public GeneralSettingsJson getCompanyGeneralSetting(Integer companyId) {
		GeneralSettingsJson generalSettingsJson = null;
		try {
			GeneralSettings generalSettings = (GeneralSettings) commonRepository.getRecordByCompanyId(companyId, GeneralSettings.class);
			if (generalSettings != null) {
				generalSettingsJson = TransformDomainToJson.getGeneralSettingsJson(generalSettings);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generalSettingsJson;
	}
}
