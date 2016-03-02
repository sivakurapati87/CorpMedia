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

import com.intuiture.corp.json.CompanyLeavePlansJson;
import com.intuiture.corp.service.CompanyLeavePlanService;

@Controller
@RequestMapping("/CompanyLeavePlanController")
public class CompanyLeavePlanController {
	@Autowired
	private CompanyLeavePlanService companyLeavePlanService;

	@RequestMapping(value = "/saveCompanyLeavePlans", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCompanyLeavePlans(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyLeavePlansJson companyLeavePlansJson) {
		return companyLeavePlanService.saveCompanyLeavePlans(companyLeavePlansJson);
	}

	@RequestMapping(value = "/getAllCompanyLeavePlansList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyLeavePlansJson> getAllCompanyLeavePlansList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return companyLeavePlanService.getAllCompanyLeavePlansList(companyId);
	}

	@RequestMapping(value = "/deleteCompanyLeavePlans/{companyBankId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCompanyLeavePlans(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyLeavePlanId) {
		return companyLeavePlanService.deleteCompanyLeavePlans(companyLeavePlanId);
	}
}
