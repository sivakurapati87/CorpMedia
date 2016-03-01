package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.TaskAssignToHr;
import com.intuiture.corp.json.TaskAssignToHrJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TaskAssignToHrService {
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveTaskAssignToHr(TaskAssignToHrJson taskAssignToHrJson) {
		TaskAssignToHr taskAssignToHr = null;
		try {
			if (taskAssignToHrJson.getTaskAssignToHrId() != null) {
				taskAssignToHr = (TaskAssignToHr) commonRepository.findById(taskAssignToHrJson.getTaskAssignToHrId(), TaskAssignToHr.class);
			} else {
				taskAssignToHr = new TaskAssignToHr();
			}
			TransformJsonToDomain.getTaskAssignToHr(taskAssignToHr, taskAssignToHrJson);
			if (taskAssignToHrJson.getTaskAssignToHrId() != null) {
				commonRepository.update(taskAssignToHr);
			} else {
				commonRepository.persist(taskAssignToHr);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TaskAssignToHrJson> getAllTaskAssignToHrList(Integer companyId) {
		List<TaskAssignToHrJson> taskAssignToHrJsonList = null;
		try {
			List<TaskAssignToHr> taskAssignToHrList = (List<TaskAssignToHr>) commonRepository.getAllRecordsByCompanyId(companyId, TaskAssignToHr.class);
			if (taskAssignToHrList != null && taskAssignToHrList.size() > 0) {
				taskAssignToHrJsonList = new ArrayList<TaskAssignToHrJson>();
				for (TaskAssignToHr taskAssignToHr : taskAssignToHrList) {
					taskAssignToHrJsonList.add(TransformDomainToJson.getTaskAssignToHrJson(taskAssignToHr));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskAssignToHrJsonList;
	}
	
	
	public Boolean deleteTaskAssignToHr(Integer taskAssignToHrId) {
		try {
			TaskAssignToHr taskAssignToHr = (TaskAssignToHr) commonRepository.findById(taskAssignToHrId, TaskAssignToHr.class);
			if (taskAssignToHr != null) {
				taskAssignToHr.setIsDeleted(Boolean.TRUE);
				commonRepository.update(taskAssignToHr);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
