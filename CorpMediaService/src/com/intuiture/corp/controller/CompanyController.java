package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CompanyJson;
import com.intuiture.corp.service.CompanyService;

@Controller
@RequestMapping("/CompanyController")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/findAllCompanies", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyJson> findAllCompanies(HttpServletRequest request, HttpServletResponse response) {
		List<CompanyJson> companyJsonList = companyService.findAllCompanies();
		return companyJsonList;
	}

	@RequestMapping(value = "/getCompanyInfo/{compName}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyJson> getCompanyInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("compName") String compName) {
		List<CompanyJson> companyJsonList = companyService.getCompanyInfo(compName);
		return companyJsonList;
	}

	@RequestMapping(value = "/findCompanyByName/{compName}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyJson> findCompanyByName(HttpServletRequest request, HttpServletResponse response, @PathVariable("compName") String compName) {
		List<CompanyJson> companyJsonList = companyService.findCompanyByName(compName);
		return companyJsonList;
	}
}
