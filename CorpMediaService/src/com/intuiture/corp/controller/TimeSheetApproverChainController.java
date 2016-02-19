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

import com.intuiture.corp.json.TimeSheetApproverJson;
import com.intuiture.corp.service.TimeSheetApproverChainService;

@Controller
@RequestMapping("/TimeSheetApproverChainController")
public class TimeSheetApproverChainController {
	@Autowired
	private TimeSheetApproverChainService timeSheetApproverChainService;

	@RequestMapping(value = "/saveOrUpdateApprover", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateRole(HttpServletRequest request, HttpServletResponse response, @RequestBody List<TimeSheetApproverJson> timeSheetApproverJsonList) {
		return timeSheetApproverChainService.saveOrUpdateRole(timeSheetApproverJsonList);
	}

	@RequestMapping(value = "/getAllApproversList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<TimeSheetApproverJson> getAllApproversList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return timeSheetApproverChainService.getAllRoles(companyId);
	}
}
