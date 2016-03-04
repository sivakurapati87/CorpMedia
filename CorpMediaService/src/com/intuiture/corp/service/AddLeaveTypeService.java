package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.JobTitlesRepository;
import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.JobTitles;
import com.intuiture.corp.json.AddLeaveTypeJson;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class AddLeaveTypeService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private JobTitlesRepository jobTitlesRepository;

	public Boolean addLeaveType(AddLeaveTypeJson addLeaveTypeJson) {
		AddLeaveType addLeaveType = null;
		try {
			if (addLeaveTypeJson.getAddLeaveTypeId() != null) {
				addLeaveType = (AddLeaveType) commonRepository.findById(addLeaveTypeJson.getAddLeaveTypeId(), AddLeaveType.class);
			} else {
				addLeaveType = new AddLeaveType();
			}
			TransformJsonToDomain.getAddLeaveType(addLeaveType, addLeaveTypeJson);
			if (addLeaveTypeJson.getAddLeaveTypeId() != null) {
				commonRepository.update(addLeaveType);
			} else {
				commonRepository.persist(addLeaveType);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<JobTitlesJson> getAllJobTitlesList(Integer companyId) {
		List<JobTitlesJson> jobTitlesJsonList = null;
		try {
			List<JobTitles> jobTitlesList = (List<JobTitles>) commonRepository.getAllRecordsByCompanyId(companyId, JobTitles.class);
			if (jobTitlesList != null && jobTitlesList.size() > 0) {
				jobTitlesJsonList = new ArrayList<JobTitlesJson>();
				for (JobTitles jobTitle : jobTitlesList) {
					jobTitlesJsonList.add(TransformDomainToJson.getJobTitlesJson(jobTitle));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobTitlesJsonList;
	}

	public Boolean deleteJobTitle(Integer jobTitleId) {
		try {
			JobTitles jobTitles = (JobTitles) commonRepository.findById(jobTitleId, JobTitles.class);
			if (jobTitles != null) {
				jobTitles.setIsDeleted(Boolean.TRUE);
				commonRepository.update(jobTitles);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
