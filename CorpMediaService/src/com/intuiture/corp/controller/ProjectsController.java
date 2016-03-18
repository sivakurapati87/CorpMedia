package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ProjectJson;
import com.intuiture.corp.service.ProjectsService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/ProjectsController")
public class ProjectsController {
	@Autowired
	private ProjectsService projectsService;

	@RequestMapping(value = "/saveOrUpdateProject", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateProject(HttpServletRequest request, HttpServletResponse response, @RequestBody ProjectJson projectJson) {
		if (projectJson != null && projectJson.getStrStartDate() != null && projectJson.getStrEndDate() != null) {
			projectJson.setStartDate(MethodUtil.convertDiffferentFormatString(projectJson.getStrStartDate()));
			projectJson.setEndDate(MethodUtil.convertDiffferentFormatString(projectJson.getStrEndDate()));
		}
		return projectsService.saveOrUpdateProject(projectJson);
	}

	@RequestMapping(value = "/getAllProjectList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectJson> getAllProjectList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {

		return projectsService.getAllProjectList(companyId);
	}

	@RequestMapping(value = "/deleteProject/{projectId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteProject(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer projectId) {
		return projectsService.deleteProject(projectId);
	}

}
