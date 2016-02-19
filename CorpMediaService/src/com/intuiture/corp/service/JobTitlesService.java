package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.JobTitlesRepository;
import com.intuiture.corp.entity.JobTitles;
import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class JobTitlesService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private JobTitlesRepository jobTitlesRepository;
	
	
	public Boolean saveJobTitles(JobTitlesJson jobTitlesJson) {
		JobTitles jobTitles = null;

		
		try {
			if (jobTitlesJson.getJobtitlesId() != null) {
				jobTitles = jobTitlesRepository.findbyId(jobTitlesJson.getJobtitlesId());
			} else {
				jobTitles = new JobTitles();
			}
			TransformJsonToDomain.getJobTitles(jobTitles, jobTitlesJson);
			if (jobTitlesJson.getJobtitlesId() != null) {
				commonRepository.update(jobTitles);
			} else {
				commonRepository.persist(jobTitles);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
