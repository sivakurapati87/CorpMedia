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
			if (lookUpDetailList != null && lookUpDetailList.size() > 0) {
				lookUpDetailJsonList = new ArrayList<LookUpDetailJson>();
				Map<Integer, LookUpDetails> lookupMap = new HashMap<Integer, LookUpDetails>();
				for (LookUpDetails lookUpDetails : lookUpDetailList) {
					lookupMap.put(lookUpDetails.getIndexOfTheMonth(), lookUpDetails);
				}
				LookUpDetails lookUpDetails = lookupMap.get(payCycleMonth);

				for (int i = (payPeriodEnd.equals(Constants.ENDDAY) ? lookUpDetails.getDaysOfTheMonth() - 1 : payPeriodEnd - 1), j = 1; j <= 60; j++) {
					LookUpDetailJson json = new LookUpDetailJson();
					json.setDescription(lookUpDetails.getDescription() + " " + (i++));
					json.setPayDayPeriod(((payPeriodEnd.equals(Constants.ENDDAY)) ? (lookupMap.get(payCycleMonth)).getDescription() : ((lookupMap.get((payCycleMonth - 1 < 0) ? 11 : (payCycleMonth - 1)).getDescription()))) + " "
							+ (payPeriodEnd.equals(Constants.ENDDAY) ? 1 : payPeriodEnd + 1) + " - " + lookupMap.get(payCycleMonth).getDescription() + " " + (payPeriodEnd.equals(Constants.ENDDAY) ? lookUpDetails.getDaysOfTheMonth() - 1 : payPeriodEnd));

					if (lookUpDetails.getIndexOfTheMonth().equals(1) && (i > (lookUpDetails.getDaysOfTheMonth() - 1)) && cal.get(Calendar.YEAR) % 4 != 0) {
						i = 1;
						payCycleMonth = ((payCycleMonth + 1) > 11) ? 0 : (payCycleMonth + 1);
						lookUpDetails = lookupMap.get(payCycleMonth);
					} else {
						if (i > lookUpDetails.getDaysOfTheMonth()) {
							i = 1;
							payCycleMonth = ((payCycleMonth + 1) > 11) ? 0 : (payCycleMonth + 1);
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
