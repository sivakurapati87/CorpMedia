package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.PayrollCycleSettings;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class PayrollCycleSettingsService {
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean savePayrollCycleSettings(PayrollCycleSettingsJson payrollCycleSettingsJson) {
		PayrollCycleSettings payrollCycleSettings = null;

		try {
			if (payrollCycleSettingsJson.getPayrollCyycleSettingsId() != null) {
				payrollCycleSettings = (PayrollCycleSettings) commonRepository.findById(payrollCycleSettingsJson.getPayrollCyycleSettingsId(), PayrollCycleSettings.class);
			} else {
				payrollCycleSettings = new PayrollCycleSettings();
			}
			TransformJsonToDomain.getPayrollCycleSettings(payrollCycleSettings, payrollCycleSettingsJson);
			if (payrollCycleSettingsJson.getPayrollCyycleSettingsId() != null) {
				commonRepository.update(payrollCycleSettings);
			} else {
				commonRepository.persist(payrollCycleSettings);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
