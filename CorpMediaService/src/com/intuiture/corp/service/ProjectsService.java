package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Project;
import com.intuiture.corp.json.ProjectJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ProjectsService {
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveOrUpdateProject(ProjectJson projectJson) {
		Project projects = null;
		try {
			if (projectJson != null) {

				if (projectJson.getProjectId() != null) {
					projects = (Project) commonRepository.findById(projectJson.getProjectId(), Project.class);
				} else {
					projects = new Project();
				}
				TransformJsonToDomain.getProject(projects, projectJson);
				if (projectJson.getProjectId() != null) {
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

	@SuppressWarnings("unchecked")
	public List<ProjectJson> getAllProjectList(Integer companyId) {
		List<ProjectJson> projectJsonList = null;
		try {
			List<Project> projectsList = (List<Project>) commonRepository.getAllRecordsByCompanyId(companyId, Project.class);
			if (projectsList != null && projectsList.size() > 0) {
				projectJsonList = new ArrayList<ProjectJson>();
				for (Project projects : projectsList) {
					projectJsonList.add(TransformDomainToJson.getProjectJson(projects));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectJsonList;
	}

	public Boolean deleteProject(Integer projectsId) {
		try {
			Project projects = (Project) commonRepository.findById(projectsId, Project.class);
			if (projects != null) {
				projects.setIsDeleted(Boolean.TRUE);
				commonRepository.update(projects);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
