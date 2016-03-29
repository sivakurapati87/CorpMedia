package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.PayrollCycleSettings;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class PayrollCycleSettingsService {

	@Autowired
	private CommonRepository commonRepository;

	public PayrollCycleSettingsJson savePayrollCycleSettings(PayrollCycleSettingsJson payrollCycleSettingsJson) {
		PayrollCycleSettings payrollCycleSettings = null;
		try {
			if (payrollCycleSettingsJson.getPayrollCycleSettingsId() != null) {
				payrollCycleSettings = (PayrollCycleSettings) commonRepository.findById(payrollCycleSettingsJson.getPayrollCycleSettingsId(),
						PayrollCycleSettings.class);
			} else {
				payrollCycleSettings = new PayrollCycleSettings();
			}
			TransformJsonToDomain.getPayrollCycleSettings(payrollCycleSettings, payrollCycleSettingsJson);
			if (payrollCycleSettingsJson.getPayrollCycleSettingsId() != null) {
				commonRepository.update(payrollCycleSettings);
			} else {
				commonRepository.persist(payrollCycleSettings);
			}
			payrollCycleSettingsJson = TransformDomainToJson.getPayrollCycleSettingsJson(payrollCycleSettings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollCycleSettingsJson;
	}

	public PayrollCycleSettingsJson getPayrollCycleSettingsJson(Integer companyId) {
		PayrollCycleSettingsJson payrollCycleSettingsJson = null;
		try {
			PayrollCycleSettings payrollCycleSettings = (PayrollCycleSettings) commonRepository.getRecordByCompanyId(companyId,
					PayrollCycleSettings.class);
			if (payrollCycleSettings != null) {
				payrollCycleSettingsJson = TransformDomainToJson.getPayrollCycleSettingsJson(payrollCycleSettings);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollCycleSettingsJson;
	}
}
