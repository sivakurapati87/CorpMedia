package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.ProjectDetails;
import com.intuiture.corp.json.ProjectDetailsJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ProjectDetailsService {
	
	@Autowired
	private CommonRepository commonRepository;
	
	public Boolean saveOrUpdateProjectDetails(ProjectDetailsJson projectDetailsJson) {
		ProjectDetails projectDetails = null;
		try {
			if (projectDetailsJson != null) {
				// This is to insert the data to professional Info Table
				if (projectDetailsJson.getProjectDetailsId() != null) {
					projectDetails = (ProjectDetails) commonRepository.findById(projectDetailsJson.getProjectDetailsId(), ProjectDetails.class);
				} else {
					projectDetails = new ProjectDetails();
				}
				TransformJsonToDomain.getProjectDetails(projectDetails, projectDetailsJson);
				if (projectDetailsJson.getProjectDetailsId() != null) {
					commonRepository.update(projectDetails);
				} else {
					commonRepository.persist(projectDetails);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
