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

import com.intuiture.corp.json.JobTitlesJson;
import com.intuiture.corp.service.JobTitlesService;

@Controller
@RequestMapping("/JobTitlesController")
public class JobTitlesController {

	@Autowired
	private JobTitlesService jobTitlesService;

	@RequestMapping(value = "/saveJobTitles", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveJobTitles(HttpServletRequest request, HttpServletResponse response, @RequestBody JobTitlesJson jobTitlesJson) {
		return jobTitlesService.saveJobTitles(jobTitlesJson);
	}

	@RequestMapping(value = "/getAllJobTitlesList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<JobTitlesJson> getAllJobTitlesList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return jobTitlesService.getAllJobTitlesList(companyId);
	}

	@RequestMapping(value = "/deleteJobTitle/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteJobTitle(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer departmentId) {
		return jobTitlesService.deleteJobTitle(departmentId);
	}
}
