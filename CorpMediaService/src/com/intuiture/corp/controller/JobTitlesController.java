package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
