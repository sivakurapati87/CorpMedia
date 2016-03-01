package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ReportsJson;
import com.intuiture.corp.service.ReportsService;
import com.intuiture.corp.util.TransformDomainToJson;
@Controller
@RequestMapping("/ReportsController")
public class ReportsController {
	
	@Autowired
	private ReportsService reportsService;
	
	@RequestMapping(value = "/saveOrUpdateReports", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateReports(HttpServletRequest request, HttpServletResponse response, @RequestBody ReportsJson reportsJson) {
		if (reportsJson != null && reportsJson.getStrFromDate() != null && reportsJson.getStrToDate() != null) {
			reportsJson.setFromDate(TransformDomainToJson.convertDiffferentFormatString(reportsJson.getStrFromDate()));
			reportsJson.setToDate(TransformDomainToJson.convertDiffferentFormatString(reportsJson.getStrToDate()));
		}
		return reportsService.saveOrUpdateReports(reportsJson);
	}

}
