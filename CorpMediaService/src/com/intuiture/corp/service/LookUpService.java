package com.intuiture.corp.service;

import java.util.ArrayList;
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

}
