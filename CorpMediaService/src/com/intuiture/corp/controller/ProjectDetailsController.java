package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ProjectDetailsJson;
import com.intuiture.corp.service.ProjectDetailsService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/ProjectDetailsController")
public class ProjectDetailsController {
	
	@Autowired
	private ProjectDetailsService projectDetailsService;
	
	@RequestMapping(value = "/saveOrUpdateProjectDetails", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateProjectDetails(HttpServletRequest request, HttpServletResponse response, @RequestBody ProjectDetailsJson projectDetailsJson) {
		if (projectDetailsJson != null && projectDetailsJson.getStrFromDate() != null && projectDetailsJson.getStrToDate() != null) {
			projectDetailsJson.setFromDate(MethodUtil.convertDiffferentFormatString(projectDetailsJson.getStrFromDate()));
			projectDetailsJson.setToDate(MethodUtil.convertDiffferentFormatString(projectDetailsJson.getStrToDate()));
		}
		return projectDetailsService.saveOrUpdateProjectDetails(projectDetailsJson);
	}

}
