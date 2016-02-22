package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CompanyEmployeeDefaultsJson;
import com.intuiture.corp.service.CompanyEmpDefaultService;

@Controller
@RequestMapping("/CompanyEmpDefaultController")
public class CompanyEmpDefaultController {
	@Autowired
	private CompanyEmpDefaultService companyEmpDefaultService;

	@RequestMapping(value = "/saveCompanyEmpDefault", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCompanyEmpDefault(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyEmployeeDefaultsJson companyEmployeeDefaultsJson) {
		return companyEmpDefaultService.saveCompanyEmpDefault(companyEmployeeDefaultsJson);
	}

	@RequestMapping(value = "/getCompanyEmpDefault/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public CompanyEmployeeDefaultsJson getCompanyEmpDefault(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return companyEmpDefaultService.getCompanyEmpDefault(companyId);
	}
}
