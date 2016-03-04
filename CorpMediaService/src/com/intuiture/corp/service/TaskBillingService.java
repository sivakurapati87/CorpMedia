package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.TaskBilling;
import com.intuiture.corp.json.TaskBillingJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TaskBillingService {
	
	@Autowired
	private CommonRepository commonRepository;
	
	public Boolean saveOrUpdateTaskBilling(TaskBillingJson taskBillingJson) {
		TaskBilling taskBilling = null;
		try {
			if (taskBillingJson != null) {
				// This is to insert the data to professional Info Table
				if (taskBillingJson.getTaskBillingId() != null) {
					taskBilling = (TaskBilling) commonRepository.findById(taskBillingJson.getTaskBillingId(), TaskBilling.class);
				} else {
					taskBilling = new TaskBilling();
				}
				TransformJsonToDomain.getTaskBilling(taskBilling, taskBillingJson);
				if (taskBillingJson.getTaskBillingId() != null) {
					commonRepository.update(taskBilling);
				} else {
					commonRepository.persist(taskBilling);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
