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

import com.intuiture.corp.json.CustomAllowanceJson;
import com.intuiture.corp.service.CustomAllowanceService;

@Controller
@RequestMapping("/CustomAllowanceController")
public class CustomAllowanceController {
	
	@Autowired
	private CustomAllowanceService customAllowanceService;
	
	@RequestMapping(value = "/saveCustomAllowance", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCustomAllowance(HttpServletRequest request, HttpServletResponse response, @RequestBody CustomAllowanceJson customAllowanceJson) {
		return customAllowanceService.saveCustomAllowance(customAllowanceJson);
	}
	
	@RequestMapping(value = "/getAllCustomAllowanceList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CustomAllowanceJson> getAllCustomAllowanceList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return customAllowanceService.getAllCustomAllowanceList(companyId);
	}
	
	@RequestMapping(value = "/deleteCustomAllowance/{customAllowanceId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCustomAllowance(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer customAllowanceId) {
		return customAllowanceService.deleteCustomAllowance(customAllowanceId);
	}

}
