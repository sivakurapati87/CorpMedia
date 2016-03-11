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

import com.intuiture.corp.json.ProjectsJson;
import com.intuiture.corp.service.ProjectsService;
import com.intuiture.corp.util.TransformDomainToJson;
@Controller
@RequestMapping("/ProjectsController")
public class ProjectsController {
	@Autowired
	private ProjectsService projectsService;
	
	
	@RequestMapping(value = "/saveOrUpdateProjects", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateProjects(HttpServletRequest request, HttpServletResponse response, @RequestBody ProjectsJson projectsJson) {
		if (projectsJson != null && projectsJson.getStrStartDate() != null && projectsJson.getStrEndDate() != null) {
			projectsJson.setStartDate(TransformDomainToJson.convertDiffferentFormatString(projectsJson.getStrStartDate()));
			projectsJson.setEndDate(TransformDomainToJson.convertDiffferentFormatString(projectsJson.getStrEndDate()));
		}
		return projectsService.saveOrUpdateProjects(projectsJson);
	}
	
	@RequestMapping(value = "/getAllProjectsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectsJson> getAllProjectsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		
		return projectsService.getAllProjectsList(companyId);
	}
	
	@RequestMapping(value = "/deleteProjects/{projectsId}", method = RequestMethod.GET)
	 @ResponseBody
	 public Boolean deleteProjects(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer projectsId) {
	 return projectsService.deleteProjects(projectsId);
	 }

}
