package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.BillingRates;
import com.intuiture.corp.json.BillingRatesJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class BillingRatesService {
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveBillingRates(BillingRatesJson billingRatesJson) {
		BillingRates billingRates = null;

		try {
			if (billingRatesJson.getBillingRatesId() != null) {
				billingRates = (BillingRates) commonRepository.findById(billingRatesJson.getBillingRatesId(), BillingRates.class);
			} else {
				billingRates = new BillingRates();
			}
			TransformJsonToDomain.getBillingRates(billingRates, billingRatesJson);
			if (billingRatesJson.getBillingRatesId() != null) {
				commonRepository.update(billingRates);
			} else {
				commonRepository.persist(billingRates);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
