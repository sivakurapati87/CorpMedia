package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Projects;
import com.intuiture.corp.json.ProjectsJson;
import com.intuiture.corp.util.TransformJsonToDomain;
@Service
@Transactional
public class ProjectsService {
	@Autowired
	private CommonRepository commonRepository;
	
	
	public Boolean saveOrUpdateProjects(ProjectsJson projectsJson) {
		Projects projects = null;
		try {
			if (projectsJson != null) {
				
				if (projectsJson.getProjectsId() != null) {
					projects = (Projects) commonRepository.findById(projectsJson.getProjectsId(), Projects.class);
				} else {
					projects = new Projects();
				}
				TransformJsonToDomain.getProjects(projects, projectsJson);
				if (projectsJson.getProjectsId() != null) {
					commonRepository.update(projects);
				} else {
					commonRepository.persist(projects);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
