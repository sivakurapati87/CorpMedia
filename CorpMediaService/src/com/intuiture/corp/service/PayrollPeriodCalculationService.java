package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.PayrollPeriodCalculation;
import com.intuiture.corp.json.PayrollPeriodCalculationJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class PayrollPeriodCalculationService {
	
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean savePayrollPeriodCalculation(PayrollPeriodCalculationJson payrollPeriodCalculationJson) {
		PayrollPeriodCalculation payrollPeriodCalculation = null;

		try {
			if (payrollPeriodCalculationJson.getPayrollPeriodCalculationId() != null) {
				payrollPeriodCalculation = (PayrollPeriodCalculation) commonRepository.findById(payrollPeriodCalculationJson.getPayrollPeriodCalculationId(), PayrollPeriodCalculation.class);
			} else {
				payrollPeriodCalculation = new PayrollPeriodCalculation();
			}
			TransformJsonToDomain.getPayrollPeriodCalculation(payrollPeriodCalculation, payrollPeriodCalculationJson);
			if (payrollPeriodCalculationJson.getPayrollPeriodCalculationId() != null) {
				commonRepository.update(payrollPeriodCalculation);
			} else {
				commonRepository.persist(payrollPeriodCalculation);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
