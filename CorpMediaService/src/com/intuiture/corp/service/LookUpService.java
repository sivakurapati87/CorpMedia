package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.LookUpRepository;
import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.MethodUtil;
import com.intuiture.corp.util.TransformDomainToJson;

@Service
@Transactional
public class LookUpService {
	@Autowired
	private LookUpRepository lookUpRepository;
	private static Logger LOG = Logger.getLogger(LookUpService.class);

	public Map<String, List<LookUpDetailJson>> getAllLookupDetailsByTypeList(List<String> typesList) {
		Map<String, List<LookUpDetailJson>> lookUpDetailsMap = new HashMap<String, List<LookUpDetailJson>>();
		try {
			List<LookUpDetails> lookUpDetailList = lookUpRepository.getAllLookupDetailsByTypeList(typesList);
			if (lookUpDetailList != null && lookUpDetailList.size() > 0) {
				for (LookUpDetails lookUpDetails : lookUpDetailList) {
					LookUpDetailJson json = TransformDomainToJson.getLookUpDetailJson(lookUpDetails);
					if (lookUpDetailsMap.get(lookUpDetails.getLookUpMaster().getLookupType()) != null) {
						lookUpDetailsMap.get(lookUpDetails.getLookUpMaster().getLookupType()).add(json);
					} else {
						List<LookUpDetailJson> list = new ArrayList<LookUpDetailJson>();
						list.add(json);
						lookUpDetailsMap.put(lookUpDetails.getLookUpMaster().getLookupType(), list);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAllLookupDetailsByTypeList() in LookUpService:" + e.getMessage());
		}
		return lookUpDetailsMap;
	}

	/**
	 * This method is to get the pay cycle
	 * 
	 * @return
	 */
	public List<LookUpDetailJson> getPayCycleList() {
		List<LookUpDetailJson> lookUpDetailJsonList = null;
		try {
			Calendar cal = Calendar.getInstance();
			Integer currentMonth = cal.get(Calendar.MONTH);
			List<Integer> monthsRange = new ArrayList<Integer>();
			for (int i = currentMonth, j = 0; j < 3; j++) {
				monthsRange.add(i--);
				if (i < 0) {
					i = 11;
				}
			}
			monthsRange.add(currentMonth + 1);

			List<LookUpDetails> lookUpDetailList = lookUpRepository.getPayCycleList(monthsRange);
			if (lookUpDetailList != null && lookUpDetailList.size() > 0) {
				lookUpDetailJsonList = new ArrayList<LookUpDetailJson>();
				for (LookUpDetails lookUpDetails : lookUpDetailList) {
					lookUpDetailJsonList.add(TransformDomainToJson.getLookUpDetailJson(lookUpDetails));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getPayCycleList() in LookUpService:" + e.getMessage());
		}
		return lookUpDetailJsonList;
	}

	public List<LookUpDetailJson> findPayDay(Integer payCycleMonth, Integer payPeriodEnd) {
		List<LookUpDetailJson> lookUpDetailJsonList = null;
		try {

			List<LookUpDetails> lookUpDetailList = lookUpRepository.getAllMonthsByMaster();
			Calendar cal = Calendar.getInstance();
			Integer paycycleYear = cal.get(Calendar.YEAR);
			if (lookUpDetailList != null && lookUpDetailList.size() > 0) {
				lookUpDetailJsonList = new ArrayList<LookUpDetailJson>();
				Map<Integer, LookUpDetails> lookupMap = new HashMap<Integer, LookUpDetails>();
				for (LookUpDetails lookUpDetails : lookUpDetailList) {
					lookupMap.put(lookUpDetails.getIndexOfTheMonth(), lookUpDetails);
				}
				LookUpDetails lookUpDetails = lookupMap.get(payCycleMonth);

				
				String payableStartMonth = null, payableEndMonth = lookupMap.get(payCycleMonth).getDescription();
				Integer payableStartDate = null, payableEndDate = null;
				Calendar paymentCycleStartDay = Calendar.getInstance();
				Calendar paymentCycleEndDay = Calendar.getInstance();

				// If we pick pay day period end date as max
				if ((payPeriodEnd.equals(Constants.ENDDAY))) {
					payableStartMonth = (lookupMap.get(payCycleMonth)).getDescription();
					payableStartDate = 1;
					payableEndDate = lookUpDetails.getDaysOfTheMonth() - 1;

					paymentCycleStartDay.set(paycycleYear, (lookupMap.get(payCycleMonth)).getIndexOfTheMonth(), payableStartDate);
					paymentCycleEndDay.set(paycycleYear, (lookupMap.get(payCycleMonth)).getIndexOfTheMonth(), payableEndDate);
				} else {
					Integer payCycleTempYear = (payCycleMonth - 1 < 0) ? paycycleYear - 1 : paycycleYear;
					Integer payCycleTempMonth = (payCycleMonth - 1 < 0) ? 11 : (payCycleMonth - 1);
					payableStartMonth = lookupMap.get((payCycleMonth - 1 < 0) ? 11 : (payCycleMonth - 1)).getDescription();
					payableStartDate = payPeriodEnd + 1;
					payableEndDate = payPeriodEnd;

					paymentCycleStartDay.set(payCycleTempYear, (lookupMap.get(payCycleTempMonth)).getIndexOfTheMonth(), payableStartDate);
					paymentCycleEndDay.set(payCycleTempYear, payCycleMonth, payableEndDate);
				}

				for (int i = (payPeriodEnd.equals(Constants.ENDDAY) ? lookUpDetails.getDaysOfTheMonth() - 1 : payPeriodEnd - 1), j = 1; j <= 60; j++) {
					LookUpDetailJson json = new LookUpDetailJson();
					// setting the pay cycle date
					cal.set(paycycleYear, payCycleMonth, i);
					// Incrementing the pay day by 1
					json.setDescription(lookUpDetails.getDescription() + " " + (i++));
					json.setStrPayDayDate(MethodUtil.convertDateToString(cal.getTime()));

					json.setStrPayCycleStartDay(MethodUtil.convertDateToString(paymentCycleStartDay.getTime()));
					json.setStrPayCycleEndDay(MethodUtil.convertDateToString(paymentCycleEndDay.getTime()));

					json.setPayDayPeriod(payableStartMonth + " " + payableStartDate + " - " + payableEndMonth + " " + payableEndDate);
					// If the iterating month is February
					if (lookUpDetails.getIndexOfTheMonth().equals(1) && (i > (lookUpDetails.getDaysOfTheMonth() - 1))
							&& cal.get(Calendar.YEAR) % 4 != 0) {
						i = 1;
						payCycleMonth = ((payCycleMonth + 1) > 11) ? 0 : (payCycleMonth + 1);
						lookUpDetails = lookupMap.get(payCycleMonth);
					} else {
						if (i > lookUpDetails.getDaysOfTheMonth()) {
							i = 1;
							payCycleMonth = ((payCycleMonth + 1) > 11) ? 0 : (payCycleMonth + 1);
							if (payCycleMonth.equals(0)) {
								paycycleYear++;
							}
							lookUpDetails = lookupMap.get(payCycleMonth);
						}
					}

					lookUpDetailJsonList.add(json);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getPayCycleList() in LookUpService:" + e.getMessage());
		}
		return lookUpDetailJsonList;
	}
}
