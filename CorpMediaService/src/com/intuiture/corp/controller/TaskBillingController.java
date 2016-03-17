package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.TaskBillingJson;
import com.intuiture.corp.service.TaskBillingService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/TaskBillingController")
public class TaskBillingController {
	
	@Autowired
	private TaskBillingService taskBillingService;
	
	@RequestMapping(value = "/saveOrUpdateTaskBilling", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateTaskBilling(HttpServletRequest request, HttpServletResponse response, @RequestBody TaskBillingJson taskBillingJson) {
		if (taskBillingJson != null && taskBillingJson.getStrFromDate() != null && taskBillingJson.getStrToDate() != null) {
			taskBillingJson.setFromDate(MethodUtil.convertDiffferentFormatString(taskBillingJson.getStrFromDate()));
			taskBillingJson.setToDate(MethodUtil.convertDiffferentFormatString(taskBillingJson.getStrToDate()));
		}
		return taskBillingService.saveOrUpdateTaskBilling(taskBillingJson);
	}

}
