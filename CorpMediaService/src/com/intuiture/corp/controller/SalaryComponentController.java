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

import com.intuiture.corp.json.SalaryComponentJson;
import com.intuiture.corp.service.SalaryComponentService;

@Controller
@RequestMapping("/SalaryComponentController")
public class SalaryComponentController {
	@Autowired
	private SalaryComponentService salaryComponentService;

	@RequestMapping(value = "/modifySalaryComponent", method = RequestMethod.POST)
	@ResponseBody
	public Boolean modifySalaryComponent(HttpServletRequest request, HttpServletResponse response, @RequestBody SalaryComponentJson salaryComponentJson) {
		return salaryComponentService.modifySalaryComponent(salaryComponentJson);
	}

	@RequestMapping(value = "/getSalaryComponentJson/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public SalaryComponentJson getSalaryComponentJson(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return salaryComponentService.getSalaryComponentJson(companyId);
	}

}
