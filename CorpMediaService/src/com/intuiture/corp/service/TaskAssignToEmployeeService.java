package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.TaskAssignToEmployee;
import com.intuiture.corp.json.TaskAssignToEmployeeJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TaskAssignToEmployeeService {
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveTaskAssignToEmployee(TaskAssignToEmployeeJson taskAssignToEmployeeJson) {
		TaskAssignToEmployee taskAssignToEmployee = null;
		try {
			if (taskAssignToEmployeeJson.getTaskAssignToEmployeeId() != null) {
				taskAssignToEmployee = (TaskAssignToEmployee) commonRepository.findById(taskAssignToEmployeeJson.getTaskAssignToEmployeeId(), TaskAssignToEmployee.class);
			} else {
				taskAssignToEmployee = new TaskAssignToEmployee();
			}
			TransformJsonToDomain.getTaskAssignToEmployee(taskAssignToEmployee, taskAssignToEmployeeJson);
			if (taskAssignToEmployeeJson.getTaskAssignToEmployeeId() != null) {
				commonRepository.update(taskAssignToEmployee);
			} else {
				commonRepository.persist(taskAssignToEmployee);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TaskAssignToEmployeeJson> getAllTaskAssignToEmployeeList(Integer companyId) {
		List<TaskAssignToEmployeeJson> taskAssignToEmployeeJsonList = null;
		try {
			List<TaskAssignToEmployee> taskAssignToEmployeeList = (List<TaskAssignToEmployee>) commonRepository.getAllRecordsByCompanyId(companyId, TaskAssignToEmployee.class);
			if (taskAssignToEmployeeList != null && taskAssignToEmployeeList.size() > 0) {
				taskAssignToEmployeeJsonList = new ArrayList<TaskAssignToEmployeeJson>();
				for (TaskAssignToEmployee taskAssignToEmployee : taskAssignToEmployeeList) {
					taskAssignToEmployeeJsonList.add(TransformDomainToJson.getTaskAssignToEmployeeJson(taskAssignToEmployee));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskAssignToEmployeeJsonList;
	}
	
	public Boolean deleteTaskAssignToEmployee(Integer taskAssignToEmployeeId) {
		try {
			TaskAssignToEmployee taskAssignToEmployee = (TaskAssignToEmployee) commonRepository.findById(taskAssignToEmployeeId, TaskAssignToEmployee.class);
			if (taskAssignToEmployee != null) {
				taskAssignToEmployee.setIsDeleted(Boolean.TRUE);
				commonRepository.update(taskAssignToEmployee);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
