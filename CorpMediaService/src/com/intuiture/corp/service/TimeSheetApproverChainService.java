package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TimeSheetApproverRepository;
import com.intuiture.corp.entity.TimeSheetApprovers;
import com.intuiture.corp.json.TimeSheetApproverJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TimeSheetApproverChainService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private TimeSheetApproverRepository timeSheetApproverRepository;

	public Boolean saveOrUpdateRole(List<TimeSheetApproverJson> timeSheetApproverJsonList) {
		TimeSheetApprovers timeSheetApprovers = null;
		try {
			if (timeSheetApproverJsonList != null && timeSheetApproverJsonList.size() > 0) {
				for (TimeSheetApproverJson timeSheetApproverJson : timeSheetApproverJsonList) {
					if (timeSheetApproverJson.getTimeSheetApproverId() != null) {
						timeSheetApprovers = (TimeSheetApprovers) commonRepository.findById(timeSheetApproverJson.getTimeSheetApproverId(), TimeSheetApprovers.class);
					} else {
						timeSheetApprovers = new TimeSheetApprovers();
					}
					TransformJsonToDomain.getTimeSheetApprover(timeSheetApprovers, timeSheetApproverJson);
					if (timeSheetApproverJson.getTimeSheetApproverId() != null) {
						commonRepository.update(timeSheetApprovers);
					} else {
						commonRepository.persist(timeSheetApprovers);
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<TimeSheetApproverJson> getAllApproversList(Integer companyId) {
		List<TimeSheetApproverJson> timeSheetApproverJsonList = null;
		try {
			List<TimeSheetApprovers> timeSheetApproverList = (List<TimeSheetApprovers>) commonRepository.getAllRecordsByCompanyId(companyId, TimeSheetApprovers.class);
			if (timeSheetApproverList != null && timeSheetApproverList.size() > 0) {
				timeSheetApproverJsonList = new ArrayList<TimeSheetApproverJson>();
				for (TimeSheetApprovers timeSheetApprovers : timeSheetApproverList) {
					timeSheetApproverJsonList.add(TransformDomainToJson.getTimeSheetApproverJson(timeSheetApprovers));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeSheetApproverJsonList;
	}
}
